import java.io.*;
import java.util.*;

public class BOJ10868_최솟값 {
	static int N,M;
	static int[] input,tree;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		input = new int[N+1];
		tree = new int[N*4];
		for(int i=1; i<=N; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		init(1,N,1);
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			sb.append(find(1,l,r,1,N)).append("\n");
		}
		System.out.println(sb);
	}
	static int find(int node, int l, int r, int s, int e) {
		if(e<l || s>r) {
			return Integer.MAX_VALUE;
		}
		if(l<=s && e<=r) {
			return tree[node];
		}
		int m = (s+e)>>1;
		return Math.min(find(node*2,l,r,s,m), find(node*2+1,l,r,m+1,e));
	}
	static int init(int s, int e, int node) {
		if(s==e) return tree[node]=input[s];
		int m = (s+e)>>1;
		return tree[node]=Math.min(init(s,m,node*2), init(m+1,e,node*2+1));
	}
}
