import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class BOJ10826_피보나치수4 {
	static BigInteger dp[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		dp = new BigInteger[n+2];
		dp[0] = BigInteger.ZERO;
		dp[1] = BigInteger.ONE;
		for(int i=2; i<=n; i++) {
			dp[i] = dp[i-1].add(dp[i-2]);
		}
		System.out.println(dp[n]);
		sc.close();
	}
}
