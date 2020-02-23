import java.io.*;
import java.util.*;

public class BOJ1003_피보나치함수 {
	static Pair[] dp;
	static int tc,N;
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		tc = Integer.parseInt(br.readLine());
		dp = new Pair[41];
		pp();
		while(tc-- > 0) {
			N = Integer.parseInt(br.readLine());
			sb.append(dp[N].z +" "+ dp[N].o + "\n");
		}
		System.out.println(sb);
	}
	public static void pp() {
		dp[0] = new Pair(1,0);
		dp[1] = new Pair(0,1);
		for(int i=2; i<=40; i++) {
			dp[i] = new Pair(dp[i-2].z + dp[i-1].z, dp[i-2].o + dp[i-1].o);
		}
	}
	public static class Pair{
		int z;
		int o;
		Pair(int z, int o){
			this.z = z; this.o=o;
		}
	}
}

