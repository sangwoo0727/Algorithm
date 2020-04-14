import java.io.*;
import java.util.*;

public class BOJ17472_다리만들기2 {
	static int N,M;
	static PriorityQueue<Node> pq = new PriorityQueue<Node>(
		(Node o1, Node o2)->{
			return Integer.compare(o1.w, o2.w);
	});
	static int[] p;
	static int[][] bd;
	static int[][] ck;
	static int[][] d = {{0,0,-1,1},{1,-1,0,0}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		bd = new int[N][M];
		ck = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				bd[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int num = 1;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(bd[i][j]==1 && ck[i][j]==0) {
					floodFill(i,j,num++);
				}
			}
		}
		p = new int[num];
		for(int i=1; i<num; i++) {
			p[i] = i;
		}
		bridge();
		System.out.println(solve(num-1));
	}
	static int solve(int num) {
		int ans = -1;
		int result = 0;
		int cnt = 0;
		while(!pq.isEmpty()) {
			int u = pq.peek().u;
			int v = pq.peek().v;
			if(find(u)==find(v)) {
				pq.poll();
				continue;
			}
			merge(u,v);
			cnt++;
			result += pq.poll().w;
			if(cnt==num-1) {
				ans = result;
				break;
			}
		}
		return ans;
	}
	static int find(int u) {
		if(u==p[u]) return u;
		return p[u] = find(p[u]);
	}
	static void merge(int u, int v) {
		u = find(u);
		v = find(v);
		if(u<v) p[u] = v;
		else p[v]=u;
	}
	static void bridge() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(bd[i][j]==1) {
					int num = ck[i][j];
					for(int k=0; k<4; k++) {
						int n = i+d[0][k];
						int m = j+d[1][k];
						if(!inner(n,m) || num == ck[n][m])
							continue;
						int cnt = 0;
						while(true) {
							if(!inner(n,m)) break;
							if(num!=ck[n][m] && bd[n][m]==1) {
								if(cnt!=1) {
									pq.add(new Node(num,ck[n][m],cnt));							
								}
								break;
							}
							n += d[0][k];
							m += d[1][k];
							cnt++;
						}
						
					}
				}
			}
		}
	}
	static void floodFill(int i,int j,int num) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(i,j));
		while(!q.isEmpty()) {
			int n = q.peek().n;
			int m = q.poll().m;
			ck[n][m] = num;
			for(int k=0; k<4; k++) {
				int nn = n+d[0][k];
				int nm = m+d[1][k];
				if(inner(nn,nm) && bd[nn][nm]==1 && ck[nn][nm]==0) {
					ck[nn][nm]=num;
					q.offer(new Pair(nn,nm));
				}
			}
		}
	}
	static boolean inner(int n,int m) {
		return 0<=n && n<N && 0<=m && m<M;
	}
	static class Node{
		int u,v,w;
		Node(int u, int v, int w){
			this.u=u;
			this.v=v;
			this.w=w;
		}
	}
	static class Pair{
		int n,m;
		Pair(int n, int m){this.n=n;this.m=m;}
	}
}
