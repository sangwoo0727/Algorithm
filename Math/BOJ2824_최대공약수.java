import java.io.*;
import java.util.*;

public class BOJ2824_최대공약수 {
	static final int RANGE = 1000000000;
	static int[] aa;
	static int[] ba;
	static int N,M;
	static long ans = 1;
	public static void main(String[] args) throws Exception {
		StringBuilder sb= new StringBuilder();
		StringTokenizer st = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		aa = new int[N];
		st = new StringTokenizer(br.readLine());
		boolean flg = false;
		for(int i=0; i<N; i++) {
			aa[i]= Integer.parseInt(st.nextToken());
		}
		M = Integer.parseInt(br.readLine());
		ba = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			ba[i]=Integer.parseInt(st.nextToken());
		}
		for(int i=0; i<N; i++) {
			if(aa[i]==1) continue;
			for(int j=0; j<M; j++) {
				if(ba[j]==1) continue;
				int num = gcd(aa[i],ba[j]);
				ans *= num;
				if(ans > RANGE) flg = true;
				ans %= RANGE;
				aa[i] /= num; 
				ba[j] /= num;
			}
		}
		String s = String.valueOf(ans);
		int len = s.length();
		if(len < 9 && flg) {
			for(int i=0; i<9-len; i++) sb.append("0");
		}
		sb.append(ans);
		System.out.println(sb);
	}
	static int gcd(int a, int b) {
		if(b==0) return a;
		return gcd(b, a%b);
	}
}