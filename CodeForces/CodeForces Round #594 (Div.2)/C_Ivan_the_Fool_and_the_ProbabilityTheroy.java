
import java.io.*;
import java.util.*;
 
public class C_Ivan_the_Fool_and_the_ProbabilityTheroy {	
	static final int MOD = 1000000007;
	static int[] dp;
	static int n,m;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int Max = Math.max(n, m);
		dp = new int[Max+1];
		dp[1]=2;
		if(Max>1) {
			pp(Max);	
		}
		System.out.println((dp[n]+dp[m]-2)%MOD);
	}
	static void pp(int Max) {
		dp[2] = 4;
		for(int i=3; i<=Max; i++) {
			dp[i] = (dp[i-1] %MOD + dp[i-2]%MOD)%MOD;
		}
	}
}