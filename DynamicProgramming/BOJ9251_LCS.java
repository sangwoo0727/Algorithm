import java.io.*;

public class BOJ9251_LCS {
	static int[][] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = "0"+br.readLine();
		String s2 = "0"+br.readLine();
		dp = new int[s1.length()][s2.length()];
		for(int i=0; i<dp.length; i++) {
			for(int j=0; j<dp[i].length; j++) {
				if(i==0) dp[i][j] = 0;
				if(j==0) dp[i][j] = 0;
				if(i==0 || j==0) continue;
				if(s1.charAt(i)== s2.charAt(j)) {
					dp[i][j] = dp[i-1][j-1]+1;
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		System.out.println(dp[s1.length()-1][s2.length()-1]);
	}
}
