import java.io.*;
import java.util.*;
public class BOJ2110_공유기설치 {
	static int N,C;
	static int arr[];
	static int ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		bs(1,arr[N-1]-arr[0]);
		System.out.println(ans);
	}
	static void bs(int l, int r) {
		int m=0;
		while(l<=r) {
			m = (l+r)/2;
			int tmp = arr[0];
			int cnt = 1;
			boolean flg = false;
			for(int i=1; i<N; i++) {
				if(arr[i]-tmp < m) continue;
				else if(arr[i]-tmp == m) {
					flg = true;
					cnt++;
					tmp = arr[i];
				}else if(arr[i]-tmp > m) {
					cnt++;
					tmp = arr[i];
				}
			}
			if(cnt < C) {
				r = m-1;
			}else {
				if(flg) ans=m;
				l = m+1;
			}
		}
	}
}
