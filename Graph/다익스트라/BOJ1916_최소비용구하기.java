import java.io.*;
import java.util.*;

public class BOJ1916_최소비용구하기 {
	static int N,M;
	static int start,end;
	static List<Node>[] adj;
	static int[] dist;
	static PriorityQueue<Node> pq = new PriorityQueue<Node>(
		(Node o1, Node o2)->{ 
			return Integer.compare(o1.w, o2.w);
	});
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		adj = new ArrayList[N+1];
		dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		for(int i=1; i<=N; i++)
			adj[i] = new ArrayList<>();
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adj[u].add(new Node(v,w));
		}
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		dijk(start);
		System.out.println(dist[end]);
	}
	static void dijk(int n) {
		dist[n] = 0;
		pq.offer(new Node(n,0));
		while(!pq.isEmpty()) {
			int noww = pq.peek().w;
			int now = pq.poll().v;
			if(dist[now] < noww)
				continue;
			for(Node next:adj[now]) {
				if(dist[next.v] > dist[now]+next.w) {
					dist[next.v]= dist[now]+next.w;
					pq.offer(new Node(next.v,dist[next.v]));
				}
			}
		}
	}
	static class Node{
		int v,w;
		public Node(int v,int w) {
			this.v=v; this.w=w;
		}
	}
}
