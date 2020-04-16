import java.io.*;
import java.util.*;

public class BOJ17141_연구소2 {
	static int N,M;
	static int[][] bd;
	static boolean[][] visit;
	static List<Pair> canVirus = new ArrayList<>();
	static Pair[] input;
	static int[][] d = {{0,0,-1,1},{1,-1,0,0}};
	static int ans = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		bd = new int[N][N];
		input = new Pair[M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				bd[i][j] = Integer.parseInt(st.nextToken());
				if(bd[i][j]==2) canVirus.add(new Pair(i,j));
			}
		}
		comb(0,0);
		if(ans == Integer.MAX_VALUE) System.out.println("-1");
		else System.out.println(ans);
	}
	static void comb(int r, int idx) {
		if(r==M) {
			bfs();
			return;
		}
		if(idx >= canVirus.size()) return;
		input[r] = canVirus.get(idx);
		comb(r+1,idx+1);
		comb(r, idx+1);
	}
	static void bfs() {
		Queue<Node> q = new LinkedList<>();
		visit = new boolean[N][N];
		int maxLev = 0;
		for(int i=0; i<input.length; i++) {
			int n = input[i].n;
			int m = input[i].m;
			q.offer(new Node(n,m,0));
			visit[n][m] = true;
		}
		while(!q.isEmpty()) {
			int n = q.peek().n;
			int m = q.peek().m;
			int lev = q.poll().lev;
			maxLev = lev;
			visit[n][m] = true;
			for(int k=0; k<4; k++) {
				int nn = n+d[0][k];
				int nm = m+d[1][k];
				if(inner(nn,nm)) {
					q.offer(new Node(nn,nm,lev+1));
					visit[nn][nm]=true;
				}
			}
		}
		boolean flg = false;
		label : for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(bd[i][j]!=1 && !visit[i][j]) {
					flg = true;
					break label;
				}
			}
		}
		if(flg) return;
		ans = Math.min(ans, maxLev);
	}
	static boolean inner(int n,int m) {
		return 0<=n && n<N && 0<=m && m<N && bd[n][m]!=1 && !visit[n][m];
	}
	static class Node{
		int n,m,lev;
		Node(int n,int m, int lev){
			this.n=n;
			this.m=m;
			this.lev=lev;
		}
	}
	static class Pair{
		int n,m;
		Pair(int n, int m){
			this.n=n; this.m=m;
		}
	}
}
