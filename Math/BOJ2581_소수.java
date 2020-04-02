import java.io.*;
import java.util.*;

public class BOJ2581_소수 {
	static int N,M;
	static boolean[] prime;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		prime = new boolean[M+1];
		make();
		int sum = 0;
		int min = 0;
		boolean flg = false;
		for(int i=N; i<=M; i++) {
			if(!prime[i] && i!=1) {
				if(!flg) {
					flg = true;
					min = i;
				}
				sum += i;
			}
		}
		if(sum==0) {
			sb.append(-1);
		}else {
			sb.append(sum).append("\n").append(min);
		}
		System.out.println(sb);
	}
	static void make() {
		for(int i=2; i<=M; i++) {
			if(prime[i]) continue;
			if(!prime[i]) {
				for(int j=i+i; j<=M; j+=i) {
					prime[j]=true;
				}
			}
		}
	}
}
