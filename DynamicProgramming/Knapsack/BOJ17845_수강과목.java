import java.io.*;
import java.util.*;

public class BOJ17845_수강과목 {
	static int N,K;
	static int[][] dp;
	static int[][] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //최대 공부시간
		K = Integer.parseInt(st.nextToken()); //과목수
		dp = new int[K+1][N+1];
		arr = new int[K+1][2]; // 0 : 중요도, 1: 공부시간
		for(int i=1; i<=K; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		for(int i=0; i<=K; i++) {
			for(int j=0; j<=N; j++) {
				if(i==0 || j==0) {
					dp[i][j] = 0; continue;
				}
				if(arr[i][1] > j)
					dp[i][j] = dp[i-1][j];
				else
					dp[i][j] = Math.max(dp[i-1][j-arr[i][1]]+arr[i][0],dp[i-1][j]);
			}
		}
		System.out.println(dp[K][N]);
	}
}
