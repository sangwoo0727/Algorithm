import java.util.*;
import java.io.*;

public class Solution {
	static int[][] arr;
	static boolean[][] check;
	static int[] dc = {-1,1,0,0};
	static int[] dr = {0,0,-1,1};
	static int N;
	
	public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1 ; tc <= T; tc++) {
        	input(br);
        	solve(tc);
        }
    }

	static void input(BufferedReader br) throws Exception {
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		check = new boolean[N][N];
		for(int i=0;i<N;i++) {
			String[] s = br.readLine().split("");
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(s[j]);
			}
		}
	}
	static void solve(int tc) {
		int cent = N/2;
		int sum = bfs(cent);
		System.out.println("#"+tc+" "+sum);
	}
	static int bfs(int cent) {
		int sum = 0;
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(cent,cent,0));
		while(!q.isEmpty()) {
			Node n= q.poll();
			check[n.n][n.m]= true;
			sum+=arr[n.n][n.m];
			for(int k=0;k<4;k++) {
				int nn = n.n+dc[k];
				int mn = n.m+dr[k];
				if(nn<0 || nn>=N || mn<0 || mn>=N)
					continue;
				else if(check[nn][mn] || n.cnt + 1 > cent)
					continue;
				check[nn][mn]=true;
				q.add(new Node(nn,mn,n.cnt+1));
			}
		}
		return sum;
	}
	
    static class Node{
		int n,m,cnt;
		Node(int n, int m, int cnt){
			this.n = n;
			this.m = m;
			this.cnt = cnt;
		}
	}
	
}
