import java.io.*;
import java.util.*;

public class BOJ16236_아기상어 {
	static Queue<Node> q = new LinkedList<>();
	static List<Pair> list;
	static int[][] bd;
	static boolean[][] visit;
	static int[][] d = {{-1,0,0,1},{0,-1,1,0}};
	static int N,ans,sn,sm;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		bd = new int[N][N];
		visit = new boolean[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				bd[i][j] = Integer.parseInt(st.nextToken());
				if(bd[i][j]==9) {
					bd[i][j] = 0;
					sn = i; sm = j;
				}
			}
		}
		bfs();
		System.out.println(ans);
	}
	static void bfs() {
		q.offer(new Node(sn,sm,0));
		int lev=2,l=0,cnt=0,max=0;
		list = new ArrayList<>();
		while(!q.isEmpty()) {
			if(!list.isEmpty()) {
				Collections.sort(list,(Pair p1, Pair p2)->{
					if(p1.n==p2.n) return Integer.compare(p1.m,p2.m);
					else return Integer.compare(p1.n,p2.n);
				});
				Pair p = list.get(0);
				list = new ArrayList<>();
				visit = new boolean[N][N];
				bd[p.n][p.m] = 0;
				if(l+1==lev) {
					lev++; l=0;
				}else l++;
				cnt = q.peek().cnt;
				while(!q.isEmpty()) q.poll();
				q.offer(new Node(p.n,p.m,cnt));
			}
			int size = q.size();
			for(int s=0; s<size; s++) {
				int n = q.peek().n;
				int m = q.peek().m;
				cnt = q.poll().cnt;
				visit[n][m] = true;
				for(int k=0; k<4; k++) {
					int nn = n + d[0][k];
					int nm = m + d[1][k];
					if(inner(nn,nm)) {
						if(bd[nn][nm] > lev) continue;
						if(bd[nn][nm]!=0 && bd[nn][nm] < lev) {
							visit[nn][nm]=true;
							list.add(new Pair(nn,nm));
							max = cnt+1;
							q.offer(new Node(nn,nm,cnt+1));
						}else {
							visit[nn][nm]=true;
							q.offer(new Node(nn,nm,cnt+1));
						}
					}
				}
			}
		}
		ans = max;
	}
	static boolean inner(int n, int m) {
		return 0<=n && n<N && 0<=m && m<N && !visit[n][m];
	}
	static class Pair{
		int n,m;
		Pair(int n,int m){this.n=n;this.m=m;}
	}
	static class Node{
		int n,m,cnt;
		Node(int n, int m,int cnt){
			this.n=n; this.m=m;
			this.cnt=cnt;
		}
	}
}