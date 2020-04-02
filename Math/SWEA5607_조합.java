import java.io.*;
import java.util.*;

public class SWEA5607_조합 {
	static long[] fac = new long[1000001]; 
	static final int MOD = 1234567891;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		fact();
		for(int t=1; t<=tc; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			long parent = (fac[r] * fac[n-r])%MOD;
			long ans = calc(parent, MOD-2);
			sb.append((fac[n]*ans)%MOD).append("\n");
		}
		System.out.println(sb);
	}
	static void fact() {
		fac[0]=1; fac[1]=1;
		for(int i=2; i<=1000000; i++) {
			fac[i] = (fac[i-1] * i)%MOD;
		}
	}
	static long calc(long n, int m) {
		if(m==0) return 1;
		long tmp = calc(n, m/2);
		long result = (tmp*tmp)%MOD;
		if(m%2==0) return result;
		else return (result*n)%MOD;
	}
}
