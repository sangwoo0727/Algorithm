import java.io.*;
import java.util.*;

public class BOJ2606_바이러스 {
	static int N,M;
	static int[] p;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		p = new int[N+1];
		for(int i=1; i<=N; i++) {
			p[i]=i;
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			merge(n,m);
		}
		int cnt = 0;
		find(1);
		for(int i=2; i<=N; i++) {
			find(i);
			if(p[i]==p[1]) cnt++;
		}
		System.out.println(cnt);
	}
	static void merge(int n, int m) {
		n = find(n);
		m = find(m);
		if(n<m) p[m] = n;
		else p[n] = m;
	}
	static int find(int n) {
		if(n==p[n]) return n;
		return p[n] = find(p[n]);
	}
}
