import java.io.*;
public class BOJ1958_LCS3 {
	static int[][][] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = "0"+br.readLine();
		String s2 = "0"+br.readLine();
		String s3 = "0"+br.readLine();
		int N = s1.length(); int M = s2.length(); int K = s3.length();
		dp = new int[N][M][K];
		for(int n=0; n<N; n++) {
			for(int m=0; m<M; m++) {
				for(int k=0; k<K; k++) {
					if(n==0 || m==0 || k==0) {
						dp[n][m][k]=0;
						continue;
					}
					if(s1.charAt(n)==s2.charAt(m) && s2.charAt(m)==s3.charAt(k)) {
						dp[n][m][k] = dp[n-1][m-1][k-1]+1;
					}else {
						dp[n][m][k] = Math.max(Math.max(dp[n-1][m][k], 
									  dp[n][m-1][k]),dp[n][m][k-1]);
					}
				}
			}
		}
		System.out.println(dp[N-1][M-1][K-1]);
	}
}
