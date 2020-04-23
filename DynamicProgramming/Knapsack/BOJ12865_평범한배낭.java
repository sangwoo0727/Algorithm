import java.io.*;
import java.util.*;

public class BOJ12865_평범한배낭 {
	static int N,K;
	static int[] w;
	static int[] v;
	static int[][] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		w = new int[N+1];
		v = new int[N+1];
		dp = new int[N+1][K+1];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			w[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<=N; i++) {
			for(int j=0; j<=K; j++) {
				if(i==0||j==0) {
					dp[i][j]=0; continue;
				}
				if(w[i]>j) dp[i][j] = dp[i-1][j];
				else {
					dp[i][j] = Math.max(dp[i-1][j-w[i]]+v[i], dp[i-1][j]);
				}
			}
		}
		System.out.println(dp[N][K]);
	}
}
