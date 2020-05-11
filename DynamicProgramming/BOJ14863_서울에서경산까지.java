import java.io.*;
import java.util.*;

public class BOJ14863_서울에서경산까지 {
	static long[][] dp;
	static int[][] arr; 
	static int N,K;
	static long ans = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N][4];
		dp = new long[N+1][K+1];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int t1 = Integer.parseInt(st.nextToken());
			int a1 = Integer.parseInt(st.nextToken());
			int t2 = Integer.parseInt(st.nextToken());
			int a2 = Integer.parseInt(st.nextToken());
			if(i==0) {
				dp[i+1][t1] = a1;
				dp[i+1][t2] = Math.max(dp[i+1][t2], a2);
				continue;
			}
			for(int k=0; k<=K; k++) {
				if(dp[i][k]!=0) {
					if(k+t1<=K) {
						dp[i+1][k+t1] = Math.max(dp[i+1][k+t1], dp[i][k]+a1);
					}
					if(k+t2<=K) {
						dp[i+1][k+t2] = Math.max(dp[i+1][k+t2], dp[i][k]+a2);
					}
				}
			}
		}
		for(int i=0; i<=K; i++) {
			ans = Math.max(ans, dp[N][i]);
		}
		System.out.println(ans);
	}
}
