import java.io.*;
import java.util.*;

public class SWEA5215_햄버거다이어트 {
	static int[][] dp;
	static int[][] k;
	static int N,L;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			k = new int[N+1][2];
			dp = new int[N+1][L+1];
			for(int i=1; i<=N; i++) {
				st = new StringTokenizer(br.readLine());
				k[i][0] = Integer.parseInt(st.nextToken()); //맛
				k[i][1] = Integer.parseInt(st.nextToken()); //칼로리
			}
			for(int i=0; i<=N; i++) {
				for(int w=0; w<=L; w++) {
					if(i==0 || w==0) dp[i][w]=0;
					else {
						if(k[i][1] > w) {
							dp[i][w] = dp[i-1][w];
						}else {
							dp[i][w] = Math.max(dp[i-1][w-k[i][1]]+k[i][0], dp[i-1][w]);
						}						
					}
				}
			}
			sb.append(dp[N][L]).append("\n");
		}
		System.out.println(sb);
	}
}
