import java.io.*;
import java.util.*;

public class BOJ2839_설탕배달 {
	static int M;
	static int[] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		M = Integer.parseInt(br.readLine());
		dp = new int[M+1];
		for(int i=0; i<dp.length; i++) {
			if(i%3==0) dp[i] = i/3;
			else dp[i] = Integer.MAX_VALUE-1;
		}
		for(int i=5; i<dp.length; i++) {
			if(dp[i]>dp[i-5]+1) {
				dp[i] = dp[i-5]+1;
			}
		}
		System.out.println(dp[M]==Integer.MAX_VALUE-1? -1 : dp[M]);
	}
}
