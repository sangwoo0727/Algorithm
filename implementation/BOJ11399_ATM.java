import java.io.*;
import java.util.*;

public class BOJ11399_ATM {
	static int[] ar;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ar = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			ar[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(ar);
		int sum = 0;
		int ans = 0;
		for(int i=0; i<N; i++) {
			sum+=ar[i];
			ans += sum;
		}
		System.out.println(ans);
	}
}