import java.io.*;
import java.util.*;

public class BOJ1822_차집합 {
	static int N,M;
	static int[] aa;
	static int[] ba;
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		aa = new int[N];
		ba = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			aa[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(aa);
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			ba[i] = Integer.parseInt(st.nextToken());
		}
		int cnt = 0;
		for(int i=0; i<N; i++) {
			if(!bs(0,M-1,aa[i])) {
				sb.append(aa[i]).append(" ");
				cnt++;
			}
		}
		if(cnt==0) System.out.println(0);
		else {
			System.out.println(cnt);
			System.out.println(sb);
		}
	}
	static boolean bs(int l, int r, int k) {
		int m;
		while(l<=r) {
			m = (l+r)/2;
			if(ba[m]<k) l = m+1;
			else if(ba[m]>k) r = m-1;
			else return true;
		}
		return false;
	}
}
