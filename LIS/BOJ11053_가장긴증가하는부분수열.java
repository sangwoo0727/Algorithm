import java.io.*;
import java.util.*;

public class BOJ11053_가장긴증가하는부분수열 {
	static int N;
	static int[] arr;
	static int[] lis;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		lis = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		lis[0] = arr[0];
		int idx = 0;
		for(int i=1; i<N; i++) {
			if(arr[i]>lis[idx]) {
				lis[++idx] = arr[i];
			}else {
				int ii = lower_bound(0,idx,arr[i]);
				lis[ii] = arr[i];
			}
		}
		System.out.println(idx+1);
	}
	static int lower_bound(int l, int r, int k) {
		int m;
		while(l<r) {
			m = (l+r)/2;
			if(lis[m]<k) l = m+1;
			else {
				r = m;
			}
		}
		return r;
	}
}
