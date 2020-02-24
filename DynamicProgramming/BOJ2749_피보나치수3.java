import java.io.*;
import java.util.*;

public class BOJ2749_피보나치수3 {
	static long n;
	static int[] dp;
	static final int MOD = 1000000;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Long.parseLong(br.readLine());
		if(n==1) {
			System.out.println("1");
			return;
		}
		int n1 = 0, n2 = 1;
		int tmp1 = 0 , tmp2 = 1;
		long range = n;
		boolean flg = false;
		for(long i=2; i<=n; i++) {
			int tmp = (tmp1+tmp2)%MOD;
			tmp1 = tmp2;
			tmp2 = tmp;
			if(tmp1==n1 && tmp2==n2) {
				flg = true;
				range = i-1;
				break;
			}
		}
		if(flg) {
			n %= range;
		}
		int ans = 0;
		for(long i=2; i<=n; i++) {
			ans = (n1 + n2)%MOD;
			n1 = n2;
			n2 = ans;
		}
		System.out.println(ans);
	}
}