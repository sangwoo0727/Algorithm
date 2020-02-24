import java.util.*;
import java.io.*;
 
public class A_DeadPixel {
	static int m, n, M, N;
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int tc = Integer.parseInt(br.readLine());
		while(tc-- >0) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			int k = N*m;
			k = Math.max(k, N*(M-m-1));
			k = Math.max(k, M*n);
			k = Math.max(k, M*(N-n-1));
			sb.append(k).append("\n");
		}
		System.out.println(sb);
	}
}