import java.io.*;
import java.util.*;

public class BOJ2468_안전영역 {
	static int[][] bd;
	static boolean[][] visit;
	static int[][] d = {{0,0,-1,1},{1,-1,0,0}};
	static int N ,mx= Integer.MIN_VALUE,mi=Integer.MAX_VALUE, ans=Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		bd = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				bd[i][j] = Integer.parseInt(st.nextToken());
				mx = Math.max(mx, bd[i][j]);
				mi = Math.min(mi, bd[i][j]);
			}
		}
		for(int m=mi; m<=mx; m++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(bd[i][j]==m) bd[i][j]=0;
				}
			}
			visit = new boolean[N][N];
			int cnt = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!visit[i][j]&&bd[i][j]!=0) {
						bfs(i,j);
						cnt++;
					}
				}
			}
			ans = Math.max(ans, cnt);
		}
		System.out.println(ans);
	}
	static void bfs(int i,int j) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(i,j));
		while(!q.isEmpty()) {
			int n = q.peek().n;
			int m = q.poll().m;
			visit[n][m]=true;
			for(int k=0; k<4; k++) {
				int nn = n+d[0][k];
				int nm = m+d[1][k];
				if(inner(nn,nm)) {
					visit[nn][nm]=true;
					q.offer(new Pair(nn,nm));
				}
			}
		}
	}
	static boolean inner(int n,int m) {
		return 0<=n && n<N && 0<=m && m<N && !visit[n][m] && bd[n][m]!=0;
	}
	static class Pair{
		int n,m;
		Pair(int n,int m){this.n=n; this.m=m;}
	}
}
