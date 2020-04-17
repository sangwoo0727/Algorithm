import java.io.*;
import java.util.*;

public class BOJ1107_리모컨 {
	static int N;
	static int M;
	static int ans = Integer.MAX_VALUE;
	static boolean[] button = new boolean[10];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		if(M>0) {
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<M; i++) {
				button[Integer.parseInt(st.nextToken())]=true;
			}
		}
		if(N==100) {
			System.out.println(0);
			return;
		}
		int d = N;
		int u = N;
		int aans = Math.abs(N-100);
		while(true) {
			if(check(d)) {
				ans = calc(d);
				break;
			}
			if(check(u)) {
				ans = calc(u);
				break;
			}
			if(d==0 && !button[d]) {
				ans = calc(d);
				break;
			}
			if(d>0) d--;
			u++;
			if(u-N > aans) break;
		}
		System.out.println(aans > ans? ans: aans);
	}
	static int calc(int n) {
		int cnt = Integer.toString(n).length();
		cnt += Math.abs(N-n);
		return cnt;
	}
	static boolean check(int n) {
		boolean flg = false;
		if(n==0) {
			if(button[n]) return false;
			return true;
		}
		while(n>0) {
			int mod = n%10;
			if(button[mod]) {
				flg = true;
				break;
			}
			n /= 10;
		}
		if(flg) return false;
		return true;
	}
}