import java.io.*;
import java.util.*;

public class SWEA1251_하나로_prim {
	static PriorityQueue<Node> pq;
	static int N;
	static double E;
	static boolean[] visit;
	static int[][] v;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			sb.append("#").append(t).append(" ");
			N = Integer.parseInt(br.readLine());
			v = new int[N][2];
			visit = new boolean[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				int x = Integer.parseInt(st.nextToken());
				v[i][0]=x;
			}
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				int y = Integer.parseInt(st.nextToken());
				v[i][1]=y;
			}
			E = Double.parseDouble(br.readLine());
			long ans = prim(0);
			sb.append(Math.round(ans*E)).append("\n");
		}
		System.out.println(sb);
	}
	static long prim(int start) {
		visit[start] = true;
		pq = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return Double.compare(o1.w, o2.w);
			}
		});
		for(int i=0; i<N; i++) {
			int next = i;
			long weight = (long) (Math.pow(v[start][0]-v[i][0], 2) + Math.pow(v[start][1]-v[i][1], 2));
			pq.offer(new Node(next,weight));
		}
		long result = 0;
		int cnt = 0;
		while(!pq.isEmpty()) {
			int u = pq.peek().v;
			long w = pq.poll().w;
			if(visit[u]) continue;
			result += w;
			cnt++;
			visit[u] = true;
			if(cnt==N-1) break;
			for(int i=0; i<N; i++) {
				int next = i;
				long weight = (long) (Math.pow(v[u][0]-v[i][0], 2) + Math.pow(v[u][1]-v[i][1], 2));
				pq.offer(new Node(next,weight));
			}
		}
		return result;
	}
	static class Node{
		int v;
		long w;
		Node(int v, long w){
			this.v=v;
			this.w=w;
		}
	}
}
