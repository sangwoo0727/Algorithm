import java.io.*;
import java.util.*;
public class BOJ1806_부분합 {
	static int N,S;
	static int ans = Integer.MAX_VALUE;
	static int[] input;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		input = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		int l = 0, r = 0;
		int sum = input[0];
		for(;;) {
			if(l>r || r>=N) break;
			if(sum < S) {
				r++;
				if(r<N) sum += input[r];
			}else {
				ans = Math.min(ans, r-l+1);
				sum -= input[l];
				l++;
			}
		}
		System.out.println(ans == Integer.MAX_VALUE ? 0 : ans);
	}
}
