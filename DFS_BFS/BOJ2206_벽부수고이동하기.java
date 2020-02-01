import java.util.*;
import java.io.*;

class Node {
	int n;
	int m;
	int wall;
	int cnt;
	Node(int n, int m, int wall, int cnt){
		this.n = n;
		this.m = m;
		this.wall = wall;
		this.cnt = cnt;
	}
}

public class Solution {
	static int[][] arr;
	static int[] dc = {0,0,-1,1};
	static int[] dr = {-1,1,0,0};
	static boolean[][][] check;
	static int N,M;
	static int Min = Integer.MAX_VALUE;
	
	static boolean inner(int n, int m, int wall) {
		if(n<1 || n>N || m<1 || m>M || check[n][m][wall]) {
			return false;
		}
		return true;
	}
	
	static void bfs(int n, int m) {
		Queue<Node> q = new	LinkedList<>();
		q.add(new Node(n,m,0,1));
		while(!q.isEmpty()) {
			Node cur = q.poll();
			check[cur.n][cur.m][cur.wall] = true;
			if(cur.n==N && cur.m==M) {
				if(cur.cnt < Min) {
					Min = cur.cnt;
				}
				continue;
			}
			for(int k=0; k<4; k++) {
				int nn = cur.n+dc[k];
				int nm = cur.m+dr[k];
				if(inner(nn,nm,cur.wall)) {
					if(arr[nn][nm]==0) {
						check[nn][nm][cur.wall]=true;
						q.add(new Node(nn,nm,cur.wall,cur.cnt+1));
					}
					if(arr[nn][nm]==1) {
						if(cur.wall==1) continue;
						else {
							check[nn][nm][1] = true;
							q.add(new Node(nn,nm,1,cur.cnt+1));
						}
					}
				}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N+1][M+1];
		check = new boolean[N+1][M+1][2];
		for(int i=1; i<=N; i++) {
			String[] s = br.readLine().split("");
			for(int j=1; j<=M; j++) {
				arr[i][j] = Integer.parseInt(s[j-1]);
			}
		}
		bfs(1,1);
		if(Min == Integer.MAX_VALUE) {
			System.out.println("-1");
		}
		else {
			System.out.println(Min);
		}
	}
}