import java.io.*;
import java.util.*;

public class BOJ11401_이항계수3 {
	static final int MOD = 1000000007;
	static long[] fac;
	static long fn=1,fk=1,fnk=1;
	static int n,k;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		dp();
		long parent = (fk*fnk)%MOD;
		long ans = calc(parent,MOD-2)%MOD;
		System.out.println((fn*ans)%MOD);
	}
	static long calc(long n,int parent) {
		if(parent==0) return 1;
		long tmp = calc(n,parent/2);
		long result = tmp*tmp%MOD;
		if(parent%2==0) return result;
		else return (result*n)%MOD;
	}
	static void dp() {
		long f = 1;
		for(int i=1; i<=n; i++) {
			f = (f*i)%MOD;
			if(i==n) fn = f;
			if(i==n-k) fnk = f;
			if(i==k) fk=f;
		}
	}
}
