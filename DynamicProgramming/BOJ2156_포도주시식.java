import java.util.*;
import java.io.*;

public class BOJ2156_포도주시식 {
	static int n;
	static int[][] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		dp = new int[3][n];
		for(int i=0; i<n; i++) {
			int val = Integer.parseInt(br.readLine());
			if(i==0) {
				dp[0][i] = 0;
				dp[1][i] = val;
				dp[2][i] = val;
			}else {
				dp[0][i] = Math.max(dp[2][i-1], Math.max(dp[0][i-1], dp[1][i-1]));
				dp[1][i] = dp[0][i-1] + val;
				dp[2][i] = dp[1][i-1] + val;
			}
		}
		System.out.println(Math.max(dp[2][n-1], Math.max(dp[0][n-1], dp[1][n-1])));
	}
	
}
