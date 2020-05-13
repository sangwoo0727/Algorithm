import java.io.*;
import java.util.*;

public class BOJ2042_구간합구하기 {
	static long[] tree,input;
	static int n,m,k;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		input = new long[n+1];
		tree = new long[n*4];
		for(int i=1; i<=n; i++) {
			input[i] = Long.parseLong(br.readLine());
		}
		init(1,n,1);
		for(int i=0; i<m+k; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			if(a==1) {
				long diff = c-input[b];
				input[b] = c;
				update(1,1,n,b,diff);
			}else {
				sb.append(find(1,b,(int)c,1,n)).append("\n");
			}
		}
		System.out.println(sb);
	}
	static void update(int node, int s, int e, int b, long diff) {
		if(s<=b && b<=e) {
			tree[node] += diff;
		}else return;
		if(s==e) return;
		int m = (s+e)>>1;
		update(node*2,s,m,b,diff);
		update(node*2+1,m+1,e,b,diff);
	}
	static long find(int node, int l, int r, int s, int e) {
		if(l>e || r<s) return 0;
		if(l<=s && e<=r) return tree[node];
		int m = (s+e)>>1;
		return find(node*2,l,r,s,m)+find(node*2+1,l,r,m+1,e);
	}
	static long init(int s, int e, int node) {
		if(s==e) return tree[node] = input[s];
		int m = (s+e)>>1;
		return tree[node]=init(s,m,node*2)+init(m+1,e,node*2+1);
	}
}
