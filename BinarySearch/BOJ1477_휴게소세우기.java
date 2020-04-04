import java.io.*;
import java.util.*;

public class BOJ1477_휴게소세우기 {
	static int N,M,L;
	static int arr[];
	static int ans = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		arr = new int[N+2];
		st = new StringTokenizer(br.readLine());
		arr[N+1] = L;
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		bs(1,L-1);
		System.out.println(ans);
	}
	static void bs(int l, int r) {
		int m;
		while(l<=r) {
			int cnt = 0;
			m = (l+r)/2;
			for(int i=1; i<=N+1; i++) {
				int dist = arr[i]-arr[i-1];
				cnt += dist/m;
				if(dist%m==0) --cnt;
			}
			if(cnt<=M) {
				if(cnt==M) {
					ans = Math.min(ans, m);
				}
				r = m-1;
			}else {
				l = m+1;
			}
		}
	}
}
