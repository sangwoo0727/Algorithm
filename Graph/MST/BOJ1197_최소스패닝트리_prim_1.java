import java.io.*;
import java.util.*;

public class BOJ1197_최소스패닝트리_prim_1 {
	static int V,E;
	static List<P>[] adj; 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		adj = new ArrayList[V+1];
		for(int i=1; i<=V; i++) {
			adj[i] = new ArrayList<>();
		}
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adj[a].add(new P(b,w));
			adj[b].add(new P(a,w));
		}
		boolean[] ck = new boolean[V+1];
		int[] k = new int[V+1];
		int[] p = new int[V+1];
		Arrays.fill(k, Integer.MAX_VALUE);
		p[1] = -1;
		k[1] = 0;
		for(int i=0; i<V-1; i++) {
			int min = Integer.MAX_VALUE;
			int idx = -1;
			for(int j=1; j<=V; j++) {
				if(!ck[j] && k[j]<=min) {
					idx = j;
					min = k[j];
				}
			}
			ck[idx] = true;
			for(int j=0; j<adj[idx].size();j++) {
				int tmp = adj[idx].get(j).v;
				if(!ck[tmp] && adj[idx].get(j).w != 0 && k[tmp]>adj[idx].get(j).w) {
					p[tmp] = idx;
					k[tmp] = adj[idx].get(j).w;
				}
			}
		}
		long result = 0;
		for(int i=1; i<=V; i++) {
			result += k[i];
		}
		System.out.println(result);
	}
	static class P{
		int v; int w;
		P(int v, int w) {
			this.v=v; this.w=w;
		}
	}
}
