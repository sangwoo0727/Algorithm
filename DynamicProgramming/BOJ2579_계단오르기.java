import java.io.*;
import java.util.*;

public class BOJ2579_계단오르기 {
	static int N;
	static int[] arr;
	static int[][] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		dp = new int[2][N];
		for(int i=0; i<N; i++) 
			arr[i] = Integer.parseInt(br.readLine());
		dp[0][0] = dp[1][0] = arr[0];
		if(N>1) {
			dp[0][1] = arr[1];
			dp[1][1] = dp[1][0] + arr[1];
			for(int i=2; i<N; i++) {
				dp[0][i] = Math.max(dp[0][i-2], dp[1][i-2])+arr[i];
				dp[1][i] = dp[0][i-1]+arr[i];
			}			
		}
		System.out.println(Math.max(dp[0][N-1], dp[1][N-1]));
	}
}