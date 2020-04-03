import java.io.*;

public class BOJ1699_제곱수의합 {
	static int N;
	static int[] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[N+1];
		for(int i=1; i<=N; i++) {
			dp[i] = i;
			for(int j=2;j*j<=i; j++) {
				dp[i] = dp[i-j*j]+1 <= dp[i] ? dp[i-j*j]+1 : dp[i]; 					
			}
		}
		System.out.println(dp[N]);
	}
}
