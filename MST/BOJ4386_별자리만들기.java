import java.io.*;
import java.util.*;

public class BOJ4386_별자리만들기 {
	static double[][] v;
	static boolean[] visit;
	static PriorityQueue<Node> pq = new PriorityQueue<>(
			(Node o1, Node o2)-> {
				return Double.compare(o1.w,o2.w);
	});
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		v = new double[N][2];
		visit = new boolean[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			v[i][0] = Double.parseDouble(st.nextToken());
			v[i][1] = Double.parseDouble(st.nextToken());
		}
		System.out.println(prim(0));
	}
	static double prim(int s) {
		visit[s] = true;
		for(int i=0; i<N; i++) {
			double w = Math.sqrt(Math.pow(v[s][0]-v[i][0], 2)+Math.pow(v[s][1]-v[i][1], 2));
			pq.offer(new Node(i,w));
		}
		double result = 0;
		int cnt = 0;
		while(!pq.isEmpty()) {
			int u = pq.peek().v;
			double w = pq.poll().w;
			if(visit[u]) continue;
			result += w;
			cnt++;
			visit[u]=true;
			if(cnt==N-1) break;
			for(int i=0; i<N; i++) {
				if(visit[i]) continue;
				double nw = Math.sqrt(Math.pow(v[u][0]-v[i][0], 2)+Math.pow(v[u][1]-v[i][1], 2));
				pq.offer(new Node(i,nw));
			}
		}
		return result;
	}
	static class Node{
		int v;
		double w;
		Node(int v, double w){
			this.v=v; this.w=w;
		}
	}
}
