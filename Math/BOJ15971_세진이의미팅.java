import java.io.*;
import java.util.*;

public class BOJ15971_세진이의미팅 {
	static final int MOD = 1000000007;
	static long fn=1,fnk=1,fk=1;
	static int N,M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		fac();
		long parent = (fnk * fk)%MOD;
		long ans = solve(parent,MOD-2)%MOD;
		System.out.println((fn*ans)%MOD);
	}
	static long solve(long n, int m) {
		if(m==0) return 1;
		long tmp = solve(n,m/2)%MOD;
		long ans = (tmp*tmp)%MOD;
		if(m%2==0) return ans;
		else return (ans*n)%MOD;
	}
	static void fac() {
		long f = 1;
		for(int i=1; i<=N; i++) {
			f = (f*i)%MOD;
			if(i==N) fn = f;
			if(i==M) fk=f;
			if(i==N-M) fnk = f;
		}
	}
}
