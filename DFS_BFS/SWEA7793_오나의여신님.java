
import java.io.*;
import java.util.*;

public class SWEA7793_오나의여신님 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static char[][] bd;
	static boolean[][] visit;
	static int[][] d = {{0,0,-1,1},{-1,1,0,0}};
	static int N,M;
	static int sn,sm;
	static int ans;
	static Queue<Node> q;
	
	public static void main(String[] args) throws Exception {
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			bd = new char[N+1][M+1];
			visit = new boolean[N+1][M+1];
			q = new LinkedList<>();
			ans = 0;
			for(int i=0; i<N; i++) {
				String s = br.readLine();
				for(int j=0; j<M; j++) {
					bd[i][j] = s.charAt(j);
					if(bd[i][j]=='S') {
						bd[i][j]='.';
						sn=i; sm=j;
					}else if(bd[i][j]=='*') {
						q.offer(new Node(i,j,0,false));
					}
				}
			}
			bfs();
			if(ans==0) sb.append("GAME OVER");
			else sb.append(ans);
			sb.append("\n");
		}
		System.out.println(sb);
	}
	static void bfs() {
		q.offer(new Node(sn,sm,0,true));
		label:while(!q.isEmpty()) {
			int n = q.peek().n;
			int m = q.peek().m;
			int l = q.peek().l;
			boolean flg = q.poll().h;
			if(flg) visit[n][m]=true;
			for(int k=0; k<4; k++) {
				int nn = n+d[0][k];
				int nm = m+d[1][k];
				if(inner(nn,nm)) {
					if(bd[nn][nm]=='.'){
						if(!flg) {
							bd[nn][nm]='*';
							q.offer(new Node(nn,nm,l+1,flg));
						}
						else if(!visit[nn][nm]) {
							visit[nn][nm]=true;
							q.offer(new Node(nn,nm,l+1,flg));
						}
					}else if(bd[nn][nm]=='D' && flg) {
						ans = l+1;
						break label;
					}
				}
			}
		}
	}
	static boolean inner(int n, int m) {
		return 0<=n && n<N && 0<=m && m<M;
	}
	static class Node{
		int n,m,l;
		boolean h;
		Node(int n, int m, int l, boolean h){
			this.n = n;
			this.m = m;
			this.l = l;
			this.h = h;
		}
	}
}
