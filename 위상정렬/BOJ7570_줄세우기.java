import java.io.*;
import java.util.*;

public class BOJ7570_줄세우기 {
	static int N,M;
	static int[] in;
	static List<Integer>[] adj;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adj = new ArrayList[N+1];
		in = new int[N+1];
		for(int i=1; i<=N; i++) {
			adj[i] = new ArrayList<>();
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a].add(b);
			in[b]++;
		}
		tsort();
		System.out.println(sb);
	}
	static void tsort() {
		Queue<Integer> q = new LinkedList<>();
		for(int i=1; i<=N; i++) {
			if(in[i]==0) q.offer(i);
		}
		for(int i=0; i<N; i++) {
			int n = q.poll();
			sb.append(n).append(" ");
			for(int idx=0; idx<adj[n].size(); idx++) {
				int nn = adj[n].get(idx);
				in[nn]--;
				if(in[nn]==0) q.offer(nn);
			}
		}
	}
}
