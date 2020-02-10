import java.io.*;
import java.util.*;


public class BOJ2805_나무자르기 {
	static int N,M;
	static int Max = Integer.MIN_VALUE;
	static int[] arr;
	static int ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for(int n=0; n<N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
			if(arr[n]>Max) Max = arr[n];
		}
		bs(0,Max);
		System.out.println(ans);
	}
	static void bs(int left, int right) {
		if(left > right) return;
		int mid = (left+right)/2;
		long sum = 0;
		for(int a:arr) {
			if(a>mid)
				sum+= a-mid;
		}
		if(sum >= M) {
			if(mid >= ans) ans = mid;
			bs(mid+1, right);
		}else {
			bs(left, mid-1);
		}
	}
}