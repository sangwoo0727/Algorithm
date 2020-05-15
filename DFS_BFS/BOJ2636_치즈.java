import java.io.*;
import java.util.*;

public class BOJ2636_치즈 {
	static Queue<Pair> q = new LinkedList<>();
	static int[][] bd;
	static boolean[][] visit;
	static int[][] d = {{0,0,-1,1},{1,-1,0,0}};
	static int N,M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		bd = new int[N+1][M];
		visit = new boolean[N+1][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				bd[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ff(N,0);
		bfs();
	}
	static void bfs() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(visit[i][j]) q.offer(new Pair(i,j));
			}
		}
		int t = 0,cnt=0;
		while(!q.isEmpty()) {
			cnt = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(bd[i][j]==1) cnt++; 
				}
			}
			int size = q.size();
			for(int s=0; s<size; s++) {
				int n = q.peek().n;
				int m = q.poll().m;
				bd[n][m]=0;
				for(int k=0; k<4; k++) {
					int nn = n+d[0][k];
					int nm = m+d[1][k];
					if(inner(nn,nm)) {
						if(bd[nn][nm]==1) {
							dfs(nn,nm);
						}
						visit[nn][nm]=true;
						q.offer(new Pair(nn,nm));
					}
				}
			}
			t++;
		}
		System.out.println(t-1);
		System.out.println(cnt);
	}
	static void dfs(int n,int m) {
		visit[n][m] = true;
		for(int k=0; k<4; k++) {
			int nn = n+d[0][k];
			int nm = m+d[1][k];
			if(inner(nn,nm)&& bd[nn][nm]==0) {
				visit[nn][nm]=true;
				q.offer(new Pair(nn,nm));
				dfs(nn,nm);
			}
		}
	}
	static void ff(int i,int j) {
		Queue<Pair> qq = new LinkedList<>();
		qq.offer(new Pair(i,j));
		while(!qq.isEmpty()) {
			int n = qq.peek().n;
			int m = qq.poll().m;
			visit[n][m]=true;
			for(int k=0; k<4; k++) {
				int nn = n+d[0][k];
				int nm = m+d[1][k];
				if(inner(nn,nm) && bd[nn][nm]==0) {
					visit[nn][nm]=true;
					qq.offer(new Pair(nn,nm));
				}
			}
		}
	}
	static boolean inner(int n,int m) {
		return 0<=n && n<N && 0<=m && m<M && !visit[n][m];
	}
	static class Pair{
		int n,m;
		Pair(int n,int m){this.n=n; this.m=m;}
	}
}
