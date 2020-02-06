import java.io.*;
import java.util.*;

public class Main {
	static char[] c = new char[80];
	static int sum,cnt,N;
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			input(br.readLine());
			solve();
			sb.append(sum).append('\n');
		}
		System.out.println(sb);
	}

	static void input(String s) {
		sum = cnt = 0;
		N = s.length();
		for(int i=0; i<s.length(); i++) {
			c[i] = s.charAt(i);
		}
	}
	static void solve() {
		for(int i=0; i<N; i++) {
			if(c[i]=='X') {
				cnt = 0;
			}else {
				cnt++;
				sum += cnt;
			}
		}
	}
}