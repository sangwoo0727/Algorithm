import java.io.*;
import java.util.*;
public class BOJ12100_2048Easy {
	static int N,ans;
	static int[][] bd;
	static boolean[][] check;
	static int[] dc = {0,0,-1,1};
	static int[] dr = {-1,1,0,0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		bd = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				bd[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		rep_permu(0);
		System.out.println(ans);
	}
	static void rep_permu(int r) {
		if(r==5) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(bd[i][j]!=0) {
						ans = Math.max(ans, bd[i][j]);
					}
				}
			}
			return;
		}
		int[][] tmp = new int[N][N];
		copy(tmp,bd);
		for(int idx=0; idx<4; idx++) {
			solve(idx);
			rep_permu(r+1);
			copy(bd,tmp);
		}
	}
	static void solve(int op) {
		check = new boolean[N][N];
		int n=0,m=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(op==0||op==2) {n=i; m=j;}
				else if(op==1) {n=i; m=N-1-j;}
				else {n=N-1-i; m=j;}
				if(bd[n][m]==0 || check[n][m]) continue;
				int num = bd[n][m];
				bd[n][m]=0;
				int nn = n+dc[op];
				int nm = m+dr[op];
				while(inner(nn,nm)&&bd[nn][nm]==0) {
					n=nn; m=nm;
					nn+=dc[op]; nm+=dr[op];
				}
				if(inner(nn,nm)&& bd[nn][nm]==num && !check[nn][nm]) {
					bd[nn][nm]=2*num;
					check[nn][nm]=true;
				}else {
					bd[n][m]=num;
				}
			}
		}
	}
	static void copy(int[][] arr1, int[][] arr2) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				arr1[i][j]=arr2[i][j];
			}
		}
	}
	static boolean inner(int n, int m) {
		return 0<=n && n<N && 0<=m && m<N;
	}
}
