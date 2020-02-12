import java.io.*;
import java.util.*;

public class SWEA1238_Contact{
	static ArrayList<Integer>[] v;
	static Set<String> set;
	static boolean[] ck;
	static Queue<Node> q;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		for(int t=1; t<=10; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine());
			set = new HashSet<>();
			int n = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			v= new ArrayList[101];
			for(int i=0; i<=100; i++) v[i] = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				String s = a+" "+b;
				if(!set.contains(s)) {
					set.add(s);
					v[a].add(b);
				}
			}
			int ans = bfs(start);
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}
	public static int bfs(int start) {
		int ansn=0, ansc=0;
		ck = new boolean[101];
		q = new LinkedList<>();
		q.offer(new Node(start,0));
		ck[start]=true;
		while(!q.isEmpty()) {
			int n = q.peek().n;
			int cnt = q.peek().cnt;
			ck[n]=true;
			q.poll();
			if(ansc == cnt) {
				ansn = Math.max(ansn, n);
			}
			if(ansc < cnt) {
				ansc = cnt;
				ansn = n;
			}
			for(int k=0; k < v[n].size(); k++) {
				int next = v[n].get(k);
				if(!ck[next]) {
					ck[next]=true;
					q.offer(new Node(next,cnt+1));
				}
			}
		}
		return ansn;
	}
	public static class Node{
		int n, cnt;
		public Node(int n, int cnt) {
			this.n = n;
			this.cnt = cnt;
		}
	}
}
