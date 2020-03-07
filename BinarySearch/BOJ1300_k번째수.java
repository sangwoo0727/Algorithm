
import java.io.*;
import java.util.*;

public class BOJ1300_k번째수 {
	static int N,K;
	static int ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		bs(1,K);
		System.out.println(ans);
	}
	static void bs(int l, int r) {
		if(l>r) return;
		int m = (l+r)/2;
		int sum = 0;
		for(int i=1; i<=N; i++) {
			sum += Math.min(N, m/i);
		}
		if(sum >= K) {
			ans = m;
			bs(l,m-1);
		}
		else if(sum < K) bs(m+1,r);
	}
}
