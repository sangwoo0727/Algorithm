import java.io.*;
import java.util.*;

public class BOJ11054_가장긴바이토닉부분수열 {
	static int N;
	static int[] arr;
	static int[][] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		dp = new int[2][N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[0][i] = dp[1][i] = 1;
		}
		for(int i=1; i<N; i++) {
			for(int j=0; j<i; j++) {
				if(arr[i]>arr[j] && dp[0][j]+1>dp[0][i])
					dp[0][i] = dp[0][j]+1;
			}
		}
		for(int i=N-2; i>=0; i--) {
			for(int j=N-1; j>i; j--) {
				if(arr[i]>arr[j] && dp[1][j]+1 > dp[1][i])
					dp[1][i] = dp[1][j]+1;
			}
		}
		int ans = 0;
		for(int i=0; i<N; i++) {
			ans = Math.max(ans, dp[0][i]+dp[1][i]-1);
		}
		System.out.println(ans);
	}
}
