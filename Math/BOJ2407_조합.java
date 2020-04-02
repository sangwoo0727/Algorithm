import java.io.*;
import java.util.*;
import java.math.*;

public class BOJ2407_조합 {
	static int N,M;
	static BigInteger[][] comb = new BigInteger[101][101];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		System.out.println(combi(N,M));
	}
	static BigInteger combi(int n, int m) {
		if(m==0) return new BigInteger("1");
		if(m==1) return new BigInteger(Integer.toString(n));
		if(n==m) return new BigInteger(Integer.toString(1));
		if(comb[n][m]==null) {
			comb[n][m] = combi(n-1,m-1).add(combi(n-1,m)); 
		}
		return comb[n][m];
	}
}
