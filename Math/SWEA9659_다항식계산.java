import java.io.*;
import java.util.*;

public class SWEA9659_다항식계산 {
	static final int MOD = 998244353;
	static int N,M;
	static int[][] bd;
	static long[][] ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			sb.append("#").append(t).append(" ");
			N = Integer.parseInt(br.readLine());
			bd = new int[N+2][3];
			for(int i=2; i<=N; i++) {
				st = new StringTokenizer(br.readLine());
				bd[i][0] = Integer.parseInt(st.nextToken());
				bd[i][1] = Integer.parseInt(st.nextToken());
				bd[i][2] = Integer.parseInt(st.nextToken());
			}
			M = Integer.parseInt(br.readLine());
			ans = new long[N+2][M];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<M; i++) {
				ans[0][i] = 1;
				ans[1][i] = Long.parseLong(st.nextToken());
			}
			for(int i=2; i<=N; i++) {
				for(int j=0; j<M; j++) {
					if(bd[i][0]==1) {
						ans[i][j] = (ans[bd[i][1]][j] + ans[bd[i][2]][j])%MOD;
					}else if(bd[i][0]==2) {
						ans[i][j] = (bd[i][1] * ans[bd[i][2]][j])%MOD;
					}else {
						ans[i][j] = (ans[bd[i][1]][j] * ans[bd[i][2]][j])%MOD;
					}
				}
			}
			for(int i=0; i<M; i++) {
				sb.append(ans[N][i]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
