import java.io.*;
import java.util.*;

public class BOJ15683_감시 {
	static List<Node> list = new ArrayList<>();
	static int[][] d = {{-1,0,1,0},{0,1,0,-1}};
	static int[][][] c = {
			{{1},{2},{3},{0}},
			{{1,3},{0,2}},
			{{0,1},{1,2},{2,3},{3,0}},
			{{0,1,2},{1,2,3},{2,3,0},{3,0,1}},
			{{0,1,2,3}}
	};
	static int[][] bd;
	static boolean[][] visit;
	static int N,M,ans=Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		bd = new int[N][M];
		visit = new boolean[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				bd[i][j] = Integer.parseInt(st.nextToken());
				if(bd[i][j]>0 && bd[i][j]<6) {
					list.add(new Node(i,j,bd[i][j]));
				}
			}
		}
		solve(0);
		System.out.println(ans);
	}
	static void solve(int r) {
		boolean[][] tmp = new boolean[N][M];
		if(r==list.size()) {
			int cnt = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(!visit[i][j]&&bd[i][j]==0) cnt++;
				}
			}
			ans = Math.min(ans, cnt);
			return;
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				tmp[i][j] = visit[i][j];
			}
		}
		int n = list.get(r).n;
		int m = list.get(r).m;
		int num = list.get(r).num-1;
		for(int k=0; k<c[num].length; k++) {
			for(int dir=0; dir<c[num][k].length; dir++) {
				int nn = n+d[0][c[num][k][dir]];
				int nm = m+d[1][c[num][k][dir]];
				for(;;) {
					if(inner(nn,nm)) {
						visit[nn][nm]=true;
						if(bd[nn][nm]==6) {
							break;
						}
						nn = nn+d[0][c[num][k][dir]];
						nm = nm+d[1][c[num][k][dir]];
						continue;
					}else {
						break;
					}
				}
			}
			solve(r+1);
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					visit[i][j] = tmp[i][j];
				}
			}
		}
	}
	static boolean inner(int n,int m) {
		return 0<=n && n<N && 0<=m && m<M;
	}
	static class Node{
		int n,m,num;
		Node(int n,int m,int num){
			this.n=n; this.m=m; this.num=num;
		}
	}
}
