import java.util.*;
import java.io.*;


class Node {
	int n,m,cnt;
	Node(int n, int m, int cnt){
		this.n=n;
		this.m=m;
		this.cnt=cnt;
	}
}

public class Solution {
	static int[][] b;
	static int[] dc = {-1,-2,-2,-1,1,2,2,1};
	static int[] dr = {-2,-1,1,2,2,1,-1,-2};
	static int N;
	static int n,m;
	static int en,em;
	static int ans;
	static boolean inner(int x, int y) {
		if(x<0 || x>=N || y<0 || y>=N || b[x][y]==1)
			return true;
		return false;
	}
	public static void bfs() {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(n,m,0));
		while(!q.isEmpty()) {
			Node cur = q.poll();
			if(cur.n==en && cur.m==em) {
				ans = cur.cnt;
				break;
			}
			b[cur.n][cur.m]=1;
			for(int k=0; k<8; k++) {
				int nn = cur.n +dc[k];
				int nm = cur.m +dr[k];
				if(inner(nn,nm)) continue;
				b[nn][nm]=1;
				q.add(new Node(nn,nm,cur.cnt+1));
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			b = new int[N][N];
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			en = Integer.parseInt(st.nextToken());
			em = Integer.parseInt(st.nextToken());
			bfs();
			System.out.println(ans);
		}
	}
}