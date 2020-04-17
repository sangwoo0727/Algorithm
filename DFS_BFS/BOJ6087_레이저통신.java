import java.io.*;
import java.util.*;

public class BOJ6087_레이저통신 {
	static Queue<Node> q = new LinkedList<>();
	static int W,H;
	static char[][] bd;
	static int[][] visit;
	static int sn,sm,en,em;
	static int[][] d = {{0,0,-1,1},{1,-1,0,0}};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		bd = new char[H][W];
		visit = new int[H][W];
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				visit[i][j] = -1;
			}
		}
		boolean flg = false;
		for(int i=0; i<H; i++) {
			String s = br.readLine();
			for(int j=0; j<W; j++) {
				bd[i][j] = s.charAt(j);
				if(bd[i][j] == 'C') {
					if(!flg) {
						sn=i; sm=j;
						flg = true;
					}else {
						en=i; em=j;
					}
				}
			}
		}
		bfs();
		System.out.println(visit[en][em]);
	}
	static void bfs() {
		q.offer(new Node(sn,sm,-1,0));
		while(!q.isEmpty()) {
			int n = q.peek().n;
			int m = q.peek().m;
			int dir = q.peek().dir;
			int cnt = q.poll().cnt;
			if(visit[n][m]!=-1 && cnt > visit[n][m]) continue;
			visit[n][m] = cnt;
			for(int k=0; k<4; k++) {
				int nn = n+d[0][k];
				int nm = m+d[1][k];
				if(inner(nn,nm)) {
					if(dir==-1) {
						visit[nn][nm]=cnt;
						q.offer(new Node(nn,nm,k,cnt));
					}else {
						if(dir==k) {
							if(visit[nn][nm]==-1) {
								visit[nn][nm]=cnt;
								q.offer(new Node(nn,nm,k,cnt));
							}else {
								if(visit[nn][nm]>=cnt) {
									visit[nn][nm]=cnt;
									q.offer(new Node(nn,nm,k,cnt));
								}
							}
						}else {
							if(visit[nn][nm]==-1) {
								visit[nn][nm]=cnt+1;
								q.offer(new Node(nn,nm,k,cnt+1));
							}else {
								if(visit[nn][nm]>=cnt+1) {
									visit[nn][nm]=cnt+1;
									q.offer(new Node(nn,nm,k,cnt+1));
								}
							}
						}
					}
				}
			}
		}
		
	}
	static boolean inner(int n,int m) {
		return 0<=n && n<H && 0<=m && m<W && bd[n][m]!='*';
	}
	static class Node{
		int n,m,dir,cnt;
		Node(int n, int m, int dir, int cnt){
			this.n = n;
			this.m = m;
			this.dir=dir;
			this.cnt=cnt;
		}
	}
}
