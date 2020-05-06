import java.io.*;
import java.util.*;

public class BOJ2146_다리만들기 {
	static int[][] bd;
	static boolean[][] ck;
	static int[][] d = {{0,0,-1,1},{1,-1,0,0}};
	static int N , ans = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		bd = new int[N][N];
		ck = new boolean[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				bd[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int num=1;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(bd[i][j]==1 && !ck[i][j]) {
					ff(i,j,num++);
				}
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(bd[i][j]!=0) {
					ck = new boolean[N][N];
					bfs(i,j);
				}				
			}
		}
		System.out.println(ans);
	}
	static void bfs(int i, int j) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(i,j,0));
		while(!q.isEmpty()) {
			int n = q.peek().n;
			int m = q.peek().m;
			int cnt = q.poll().cnt;
			if(cnt >= ans) break;
			for(int k=0; k<4; k++) {
				int nn = n+d[0][k];
				int nm = m+d[1][k];
				if(inner(nn,nm) && !ck[nn][nm] && bd[nn][nm]!=bd[i][j]) {
					if(bd[nn][nm]!=0) {
						ck[nn][nm]=true;
						ans = Math.min(ans, cnt);
					}else {
						ck[nn][nm]=true;
						q.offer(new Node(nn,nm,cnt+1));
					}
				}
			}
		}
	}
	static void ff(int i, int j, int num) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(i,j));
		while(!q.isEmpty()) {
			int n = q.peek().n;
			int m = q.poll().m;
			ck[n][m]=true;
			bd[n][m]=num;
			for(int k=0; k<4; k++) {
				int nn = n+d[0][k];
				int nm = m+d[1][k];
				if(inner(nn,nm) && !ck[nn][nm] && bd[nn][nm]==1) {
					q.offer(new Pair(nn,nm));
					ck[nn][nm]=true;
				}
			}
		}
	}
	static boolean inner(int n, int m) {
		return 0<=n && n<N && 0<=m && m<N;
	}
	static class Node{
		int n; int m; int cnt;
		Node(int n, int m, int cnt){
			this.n=n; this.m=m;
			this.cnt=cnt;
		}
	}
	static class Pair{
		int n; int m;
		Pair(int n, int m){this.n=n; this.m=m;}
	}
}
