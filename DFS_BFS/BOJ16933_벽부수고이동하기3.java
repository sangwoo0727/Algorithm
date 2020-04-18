import java.io.*;
import java.util.*;

public class BOJ16933_벽부수고이동하기3 {
	static Queue<Node> q = new LinkedList<>();
	static int N,M,K;
	static int[][] bd;
	static int[][][] visit;
	static int[][] d = {{0,0,-1,1},{1,-1,0,0}};
	static int ans = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		bd = new int[N+1][M+1];
		visit = new int[N+1][M+1][K+1];
		for(int i=1; i<=N; i++) {
			String s = br.readLine();
			for(int j=1; j<=M; j++) {
				bd[i][j] = s.charAt(j-1)-'0';
			}
		}
		q.offer(new Node(1,1,1,0,true));
		bfs();
		System.out.println(ans==Integer.MAX_VALUE? -1:ans);
	}
	static void bfs() {
		while(!q.isEmpty()) {
			int n = q.peek().n;
			int m = q.peek().m;
			int lev = q.peek().lev;
			int k = q.peek().k;
			boolean day = q.poll().day;
			visit[n][m][k]=lev;
			if(n==N && m==M) {
				ans = Math.min(ans, visit[N][M][k]);
				continue;
			}
			for(int w=0; w<4; w++) {
				int nn = n+d[0][w];
				int nm = m+d[1][w];
				if(inner(nn,nm)) {
					if(bd[nn][nm]==0) {
						if(visit[nn][nm][k]==0 || visit[nn][nm][k]>lev+1) {
							visit[nn][nm][k]=lev+1;
							q.offer(new Node(nn,nm,lev+1,k,!day));
						}
					}else { //벽
						if(day) {
							if(k+1<=K && (visit[nn][nm][k+1]==0 || visit[nn][nm][k+1]>lev+1)) {
								visit[nn][nm][k+1]=lev+1;
								q.offer(new Node(nn,nm,lev+1,k+1,!day));
							}
						}else {
							if(k+1<=K && (visit[nn][nm][k+1]==0 || visit[nn][nm][k+1]>lev+2)) {
								visit[nn][nm][k+1]=lev+2;
								q.offer(new Node(nn,nm,lev+2,k+1,day));
							}
						}
					}
				}
			}
		}
	}
	static boolean inner(int n, int m) {
		return 1<=n && n<=N && 1<=m && m<=M;
	}
	static class Node{
		int n,m,lev,k;
		boolean day;
		Node(int n, int m, int lev, int k, boolean day){
			this.n=n;
			this.m=m;
			this.lev=lev;
			this.k=k;
			this.day= day;
		}
	}
}