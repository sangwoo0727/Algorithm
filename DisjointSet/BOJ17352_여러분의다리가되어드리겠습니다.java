import java.io.*;
import java.util.*;

public class BOJ17352_여러분의다리가되어드리겠습니다 {
	static int N, ans = -1;
	static int[] p;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		p = new int[N];
		for(int i=0; i<N; i++) {
			p[i] = i;
		}
		for(int i=0; i<N-2; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			merge(a,b);
		}
		for(int i=0; i<N; i++) {
			find(i);
			if(ans==-1) ans = p[i];
			else if(ans != p[i]) {
				System.out.println(ans+1 + " " + (p[i]+1));
				break;
			}
		}
	}
	static void merge(int n, int m) {
		n = find(n); m = find(m);
		if(n<m) p[n] = m;
		else p[m] = n;
	}
	static int find(int n) {
		if(n==p[n]) return n;
		else return p[n] = find(p[n]);
	}
}
