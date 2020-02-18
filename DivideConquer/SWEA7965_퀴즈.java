import java.io.*;

public class SWEA7965_퀴즈 {
	static final int MOD = 1000000007;
	static long[] ans = new long[1000001];
	static int N;
	public static void main(String[] args) throws Exception {
		ans[1]=1;
		ans[2]=5;
		for(int i=3; i<1000001; i++) {
			ans[i] = (ans[i-1]%MOD + solve(i,i)%MOD)%MOD;
		}
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			sb.append("#").append(t).append(" ");
			N = Integer.parseInt(br.readLine());
			sb.append(ans[N]).append("\n");
		}
		System.out.println(sb);
	}
	static long solve(int n,int m) {
		if(m==0) return 1;
		if(m==1) return n;
		long even = solve(n,m/2)%MOD;
		if(m%2==1) {
			return (even*((even*n)%MOD))%MOD; 
		}
		else {
			return (even*even)%MOD;
		}
	}
}
