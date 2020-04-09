import java.io.*;
import java.util.*;

public class BOJ1197_최소스패닝트리_kruskal {
	static int V,E;
	static int[] p;
	
	static PriorityQueue<Node> q = new PriorityQueue<>(new Comparator<Node>() {
		@Override
		public int compare(Node o1, Node o2) {
			return Integer.compare(o1.w, o2.w);
		}
	});
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			q.offer(new Node(u,v,w));
		}
		p = new int[V+1];
		for(int i=1; i<=V; i++)
			p[i] = i;
		long result = 0;
		int cnt = 0;
		while(!q.isEmpty()) {
			int a = q.peek().u;
			int b = q.peek().v;
			if(find(a)==find(b)) {
				q.poll();
				continue;
			}
			merge(a,b);
			cnt++;
			result += q.poll().w;
			if(cnt==V-1) {
				break;
			}
		}
		System.out.println(result);
	}
	static int find(int u) {
		if(u==p[u]) return u;
		return p[u] = find(p[u]);
	}
	static void merge(int u, int v) {
		u = find(u);
		v = find(v);
		if(u<v) p[u] = v;
		else p[v]=u;
	}
	static class Node{
		int u,v,w;
		Node(int u, int v, int w){
			this.u=u;
			this.v=v;
			this.w=w;
		}
	}
}
