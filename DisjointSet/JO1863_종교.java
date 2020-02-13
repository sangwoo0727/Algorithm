import java.io.*;
import java.util.*;

public class JO1863_종교 {
	static int N,M;
	static int[] p;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		p = new int[N+1];
		for(int i=1; i<=N; i++) {
			p[i]=i;
		}
		while(M-->0) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			merge(i,j);
		}
		int ans = 0;
		for(int i=1; i<=N; i++) {
			if(i==p[i]) ans++;
		}
		System.out.println(ans);
	}
	public static void merge(int n, int m) {
		n = find(n);
		m = find(m);
		if(n!=m) {
			if(n<m) p[m]=n;
			else p[n]=m;
		}
	}
	private static int find(int n) {
		if(n == p[n]) return n;
		return p[n]=find(p[n]);
	}
	
}
