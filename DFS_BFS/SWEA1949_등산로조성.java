import java.io.*;
import java.util.*;
public class SWEA1949_등산로조성 {
	static int N,K,stNum;
	static int[][] bd;
	static int[][] d = {{0,0,-1,1},{-1,1,0,0}};
	static boolean[][] visit;
	static int ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			bd = new int[N][N];
			visit = new boolean[N][N];
			stNum=0;
			ans = Integer.MIN_VALUE;
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					bd[i][j] = Integer.parseInt(st.nextToken());
					stNum = Math.max(stNum, bd[i][j]);
				}
			}
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(bd[i][j]==stNum) {
						dfs(i,j,1,false);
						visit[i][j]=false;
					}
				}
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}
	static void dfs(int n, int m, int cnt, boolean flg) {
		visit[n][m]=true;
		ans = Math.max(ans, cnt);
		for(int k=0; k<4; k++) {
			int nn = n+d[0][k];
			int nm = m+d[1][k];
			if(inner(nn,nm)&& !visit[nn][nm]) {
				if(bd[n][m]>bd[nn][nm]) {
					visit[nn][nm]=true;
					dfs(nn,nm,cnt+1,flg);
				}else {
					int range = bd[nn][nm]-bd[n][m];
					if(range<K && !flg) {
						int tmp = bd[nn][nm];
						bd[nn][nm]=bd[n][m]-1;
						visit[nn][nm]=true;
						dfs(nn,nm,cnt+1,!flg);
						bd[nn][nm]=tmp;
					}
				}
				visit[nn][nm]=false;
			}
		}
	}
	static boolean inner(int n, int m) {
		return 0<=n && n<N && 0<=m && m<N;
	}
}
