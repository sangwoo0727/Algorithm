package algo2;

import java.io.*;
import java.util.*;

public class BOJ17822_원판돌리기 {
	static int[][] bd;
	static int[][] dir = {{0,0,-1,1},{-1,1,0,0}};
	static boolean[][] visit;
	static int N,M,T;
	static Deque<Integer> dq;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		bd = new int[N+1][M+1];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=M; j++) {
				bd[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			for(int ix = x; ix<=N; ix+=x) { 
				dq = new LinkedList<>();
				for(int j=1; j<=M; j++) {
					dq.add(bd[ix][j]);
				}
				if(d==1) { 
					for(int ik=0; ik<k; ik++) {
						int tn = dq.pollFirst();
						dq.addLast(tn);
					}
					for(int j=1; j<=M; j++) {
						bd[ix][j] = dq.pollFirst();
					}
				}else {
					for(int ik=0; ik<k; ik++) {
						int tn = dq.pollLast();
						dq.addFirst(tn);
					}
					for(int j=1; j<=M; j++) {
						bd[ix][j] = dq.pollFirst();
					}
				}
			} // end of rotation
			boolean flg = false;
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=M; j++) {
					if(bd[i][j]!=0) {
						if(search(i,j)) flg = true;
					}
				}
			} // end of remove
			if(!flg) {
				double total = 0;
				int cnt = 0;
				for(int n=1; n<=N; n++) {
					for(int m=1; m<=M; m++) {
						if(bd[n][m]!=0) {
							total += bd[n][m];
							cnt++;
						}
					}
				}
				total /=cnt;
				for(int n=1; n<=N; n++) {
					for(int m=1; m<=M; m++) {
						if(bd[n][m]!=0) {
							if(bd[n][m] < total) bd[n][m]+=1;
							else if(bd[n][m] >total) bd[n][m]-=1;
						}
					}
				}	
			}
		}
		int ans = 0;
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				ans += bd[i][j];
			}
		}
		System.out.println(ans);
	}
	static boolean search(int i,int j) {
		int c = bd[i][j];
		visit = new boolean[N+1][M+1];
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(i,j));
		while(!q.isEmpty()) {
			int n = q.peek().n;
			int m = q.poll().m;
			visit[n][m] = true;
			for(int k=0; k<4; k++) {
				int nn = n+dir[0][k];
				int nm = m+dir[1][k];
				if(k==0 && nm==0) nm = M; //left
				if(k==1 && nm==M+1) nm=1;
				if(inner(nn,nm,c)) {
					visit[nn][nm] = true;
					q.offer(new Node(nn,nm));
				}
			}
		}
		boolean flg = false;
		for(int n=1; n<=N; n++) {
			for(int m=1; m<=M; m++) {
				if((n==i) && (m==j)) continue;
				if(visit[n][m]) {
					flg = true;
					bd[n][m] = 0;
				}
			}
		}
		if(flg) {
			bd[i][j] = 0;
			return true;
		}
		return false;
	}
	static boolean inner(int n,int m, int c) {
		return 0<n && n<=N && 0<m && m<=M && !visit[n][m] && bd[n][m]==c;
	}
	static class Node{
		int n,m;
		Node(int n,int m){
			this.n=n; this.m=m;
		}
	}
}
