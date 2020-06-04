import java.io.*;
import java.util.*;

public class BOJ18809_Gaaaaaarden {
	static List<Pair> list = new ArrayList<>();
	static Queue<Node> q;
	static int[][] bd;
	static Pair[][] visit;
	static int[][] d = {{0,0,-1,1},{1,-1,0,0}};
	static int[] input;
	static int N,M,G,R,ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		bd = new int[N][M];
		int cnt = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				bd[i][j] = Integer.parseInt(st.nextToken());
				if(bd[i][j]==2) {
					cnt++;
					list.add(new Pair(i,j));
				}
			}
		}
		input = new int[cnt];
		for(int i=0; i<R; i++) {
			input[i] = 1; //red
		}
		for(int i=R; i<R+G; i++) {
			input[i] = 2; //green
		}
		Arrays.sort(input);
		do {
			q = new LinkedList<>();
			visit = new Pair[N][M];
			for(int i=0; i<cnt; i++) {
				if(input[i]!=0) {
					q.offer(new Node(list.get(i).f,list.get(i).s,input[i],0));
					visit[list.get(i).f][list.get(i).s] = new Pair(input[i],0);
				}
			}
			bfs();
		}while(next_permutation());
		System.out.println(ans);
	}
	static void bfs() {
		int cnt = 0;
		while(!q.isEmpty()) {
			int n = q.peek().n;
			int m = q.peek().m;
			int c = q.peek().c;
			int l = q.poll().l;
			if(visit[n][m].f==3) continue;
			visit[n][m] = new Pair(c,l);
			for(int k=0; k<4; k++) {
				int nn = n+d[0][k];
				int nm = m+d[1][k];
				if(inner(nn,nm)) {
					if(visit[nn][nm]==null) {
						visit[nn][nm] = new Pair(c,l+1);
						q.offer(new Node(nn,nm,c,l+1));
					}else {
						if(visit[nn][nm].f!=3 && visit[nn][nm].f!=c && visit[nn][nm].s==l+1) {
							visit[nn][nm].f=3;
							cnt++;
						}
					}
				}
			}
		}
		ans = Math.max(ans, cnt);
	}
	static boolean inner(int n, int m) {
		return 0<=n && n<N && 0<=m && m<M && bd[n][m]!=0;
	}
	static boolean next_permutation() {
		int i = input.length-1;
		while(i>0 && input[i-1]>=input[i]) --i;
		if(i==0) return false;
		
		int j = input.length-1;
		while(input[i-1]>=input[j]) --j;
		
		int t = input[i-1];
		input[i-1] = input[j];
		input[j] = t;
		
		int k = input.length-1;
		while(i<k) {
			t = input[i];
			input[i] = input[k];
			input[k] = t;
			++i; --k;
		}
		return true;
	}
	static class Node{
		int n,m,c,l;
		Node(int n,int m,int c, int l){
			this.n=n; this.m=m;
			this.c=c; this.l=l;
		}
	}
	static class Pair{
		int f,s;
		Pair(int f,int s){
			this.f=f; this.s=s;
		}
	}
}
