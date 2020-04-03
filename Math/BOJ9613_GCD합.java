import java.io.*;
import java.util.*;

public class BOJ9613_GCD합 {
	static int n;
	static int[] arr;
	static int[] input = new int[2];
	static long ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		while(tc-->0) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			ans = 0;
			arr = new int[n];
			for(int i=0; i<n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			comb(0,0);
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}
	static void comb(int r,int idx) {
		if(r==2) {
			ans += gcd(input[0],input[1]);
			return;
		}
		if(idx>=n) return;
		input[r] = arr[idx];
		comb(r+1,idx+1);
		comb(r,idx+1);
	}
	static int gcd(int a, int b) {
		if(b==0) return a;
		return gcd(b,a%b);
	}
}
