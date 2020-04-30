import java.util.*;
import java.io.*;

public class SWEA6109_추억의2048게임 {
	static int N;
	static int[][] bd;
	static boolean[][] ck;
	static int[] dc = {0,0,-1,1};
	static int[] dr = {-1,1,0,0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			sb.append("#").append(t).append("\n");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			String s = st.nextToken();
			bd = new int[N][N];
			ck = new boolean[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					bd[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			if(s.equals("left")) solve(0);
			else if(s.equals("right")) solve(1);
			else if(s.equals("up")) solve(2);
			else if(s.equals("down")) solve(3);
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					sb.append(bd[i][j]).append(" ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
	static void solve(int op) {
		int n=0,m=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(op==0 || op==2) {
					n=i; m=j;
				}else if(op==1) {
					n=i; m=N-1-j;
				}else {
					n=N-1-i; m=j;
				}
				if(bd[n][m]==0 || ck[n][m]) {
					continue;
				}
				int num = bd[n][m];
				bd[n][m] = 0;
				int nn = n+dc[op];
				int nm = m+dr[op];
				while(inner(nn,nm) && bd[nn][nm]==0) {
					n = nn;
					m = nm;
					nn+=dc[op];
					nm+=dr[op];
				}
				if(inner(nn,nm) && bd[nn][nm]==num && !ck[nn][nm]){
					bd[nn][nm]=2*num;
					ck[nn][nm]=true;
				}else {
					bd[n][m]=num;
				}
			}
		}
	}
	static boolean inner(int n,int m) {
		return 0<=n && n<N && 0<=m && m<N;
	}
}
