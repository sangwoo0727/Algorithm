import java.io.*;
import java.util.*;

public class BOJ2502_떡먹는호랑이 {
	static int[][] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int D = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		dp = new int[2][D+1];
		dp[0][0] = 1; dp[1][0] = 0;
		dp[0][1] = 0; dp[1][1] = 1;
		for(int i=0; i<=1; i++) {
			for(int j=2; j<D; j++) {
				dp[i][j] = dp[i][j-1] + dp[i][j-2];
			}
		}
		int a = dp[0][D-1]; int b = dp[1][D-1];
		int cnt = 1;
		while(true) {
			if((K-a*cnt)%b==0) {
				System.out.println(cnt);
				System.out.println((K-a*cnt)/b);
				break;
			}
			cnt++;
		}
	}
}
