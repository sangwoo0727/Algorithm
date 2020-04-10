import java.io.*;
import java.util.*;

public class BOJ1753_최단경로 {
	static int V,E,S;
	static PriorityQueue<Node> pq = new PriorityQueue<>();
	static int[] d;
	static List<Node>[] adj;
	static boolean[] visit;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(br.readLine());
		d = new int[V+1];
		adj = new ArrayList[V+1];
		for(int i=1; i<=V; i++)
			adj[i] = new ArrayList<>();
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adj[u].add(new Node(v,w));
		}
		dijk();
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=V; i++) {
			if(d[i] == Integer.MAX_VALUE)
				sb.append("INF").append("\n");
			else sb.append(d[i]).append("\n");
		}
		System.out.println(sb);
	}
	static void dijk() {
		for(int i=1; i<=V; i++) {
			if(i==S) d[i] = 0;
			else d[i] = Integer.MAX_VALUE;				
		}
		pq.offer(new Node(S,0));
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if(d[now.v]<now.w) continue;
			for(Node next: adj[now.v]) {
				if(d[next.v] > d[now.v] + next.w) {
					d[next.v] = d[now.v] + next.w;
					pq.offer(new Node(next.v,d[next.v]));
				}
			}
		}
	}
	static class Node implements Comparable<Node>{
		int v,w;
		public Node(int v, int w) {
			this.v=v; this.w=w;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.w, o.w);
		}
		
	}
}
