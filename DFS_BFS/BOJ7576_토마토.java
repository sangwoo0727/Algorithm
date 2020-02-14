package homework;

import java.io.*;
import java.util.*;

public class BOJ7576_토마토 {
	static Queue<Node> q = new LinkedList<>();
	static int[][] bd;
	static int[][] d = {{0,0,1,-1,},{-1,1,0,0,}};
	static int N,M;
	static int ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		bd = new int[N+1][M+1];
		boolean flg = false;
		int cnt = 0;
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m=0; m<M; m++) {
				bd[n][m] = Integer.parseInt(st.nextToken());
				if(bd[n][m]==0) {
					cnt++;
					flg = true;
				}
				if(bd[n][m]==1) {
					q.offer(new Node(n,m,0));
				}
			}
		}
		if(!flg) System.out.println("0");
		else {
			if(cnt == bfs()) {
				System.out.println(ans);
			}else {
				System.out.println("-1");
			}
		}
		
	}
	static int bfs() {
		int cnt = 0;
		while(!q.isEmpty()) {
			int n = q.peek().x;
			int m = q.peek().y;
			int day = q.poll().day;
			ans = day;
			for(int k=0; k<4; k++) {
				int nn = n + d[0][k];
				int nm = m + d[1][k];
				if(inner(nn,nm)) {
					q.offer(new Node(nn,nm,day+1));
					cnt++;
					bd[nn][nm]=1;
				}
			}
		}
		return cnt;
	}
	static boolean inner(int n, int m) {
		return 0<=n && n<N && 0<=m && m<M && bd[n][m]==0;
	}
	static class Node{
		int x, y, day;
		Node(int x, int y, int day){
			this.x = x; this.y=y; this.day=day;
		}
	}
}
