import java.io.*;
import java.util.*;

public class BOJ2193_이친수 {
	static int N;
	static long dp1,dp2;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp1 = 0;
		dp2 = 1;
		long tmp = 0;
		for(int i=1; i<N; i++) {
			tmp = dp1 + dp2;
			dp2 = dp1;
			dp1 = tmp;
		}
		System.out.println(dp1+dp2);
	}
}