import java.io.*;
import java.util.*;

public class SWEA1251_하나로 {
	static int[] p;
	static int[][] v;
	static PriorityQueue<Node> q;
	static int N;
	static double E;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			sb.append("#").append(t).append(" ");
			q = new PriorityQueue<>(new Comparator<Node>() {
				@Override
				public int compare(Node o1, Node o2) {
					return Double.compare(o1.w, o2.w);
				}
			});
			N = Integer.parseInt(br.readLine());
			p = new int[N];
			v = new int[N][2];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				int x = Integer.parseInt(st.nextToken());
				v[i][0] = x;
			}
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				int y = Integer.parseInt(st.nextToken());
				v[i][1] = y;
			}
			
			E = Double.parseDouble(br.readLine());
			double dist = 0;
			for(int i=0; i<N-1; i++) {
				for(int j=i+1; j<N; j++) {
					dist = (long)(Math.pow(v[i][0]-v[j][0], 2)+ Math.pow(v[i][1]-v[j][1], 2));
					q.offer(new Node(i,j,dist));
				}
			}
			for(int i=0; i<N; i++) {
				p[i] = i;
			}
			dist = 0;
			int cnt = 0;
			while(!q.isEmpty()) {
				int a = find(q.peek().x);
				int b = find(q.peek().y);
				if(a==b) {
					q.poll();
					continue;
				}
				union(a,b);
				dist += q.poll().w;
				cnt++;
				if(cnt==N-1) break;
			}
			sb.append(Math.round(dist*E)).append("\n");
		}
		System.out.println(sb);
	}
	static int find(int x) {
		if(x==p[x]) return x;
		else return p[x] = find(p[x]);
	}
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x<y) p[y]=x;
		else p[x]=y;
	}
	static class Node{
		int x,y;
		double w;
		Node(int x, int y, double w){
			this.x=x;
			this.y=y;
			this.w=w;
		}
	}
}
