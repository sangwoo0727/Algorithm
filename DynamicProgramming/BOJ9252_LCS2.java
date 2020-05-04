import java.io.*;

public class BOJ9252_LCS2 {
	static int[][] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s1 = "0"+br.readLine();
		String s2 = "0"+br.readLine();
		int N = s1.length(); int M = s2.length();
		dp = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(i==0 || j==0) {
					dp[i][j] = 0;
					continue;
				}
				if(s1.charAt(i)==s2.charAt(j))
					dp[i][j] = dp[i-1][j-1]+1;
				else
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		System.out.println(dp[N-1][M-1]);
		int n = N-1, m=M-1;
		for(;;) {
			if(dp[n][m]==0) break;
			if(dp[n][m]==dp[n-1][m]) n--;
			else if(dp[n][m]==dp[n][m-1]) m--;
			else if(dp[n][m]-1 == dp[n-1][m-1]) {
				sb.append(s1.charAt(n));
				n--; m--;
			}
		}
		System.out.println(sb.reverse());
	}
}
