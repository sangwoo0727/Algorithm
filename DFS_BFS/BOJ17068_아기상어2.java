import java.io.*;
import java.util.*;

public class BOJ17068_아기상어2 {
	static int[][] bd,dist;
	static boolean[][] visit;
	static int[][] d = {{-1,-1,-1,0,1,1,1,0},{-1,0,1,1,1,0,-1,-1}};
	static int N,M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		bd = new int[N][M];
		dist = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				bd[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(bd[i][j]==1) {
					visit = new boolean[N][M];
					bfs(i,j);
				}
			}
		}
		int ans = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				ans = Math.max(ans, dist[i][j]);
			}
		}
		System.out.println(ans);
	}
	static void bfs(int i, int j) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(i,j));
		int cnt = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int s=0; s<size; s++) {
				int n = q.peek().n;
				int m = q.poll().m;
				visit[n][m] = true;
				dist[n][m] = cnt;
				for(int k=0; k<8; k++) {
					int nn = n+d[0][k];
					int nm = m+d[1][k];
					if(inner(nn,nm)&& (dist[nn][nm]==0 ||dist[nn][nm]>=cnt+1)) {
						visit[nn][nm] = true;
						q.offer(new Pair(nn,nm));
					}
				}
			}
			cnt++;
		}
	}
	static boolean inner(int n,int m) {
		return 0<=n && n<N && 0<=m && m<M && bd[n][m]==0 && !visit[n][m];
	}
	static class Pair{
		int n,m;
		Pair(int n,int m){
			this.n=n; this.m=m;
		}
	}
}
