import java.io.*;
import java.util.*;

public class SWEA5656_벽돌깨기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[][] bd;
	static int[][] d = {{0,0,-1,1},{1,-1,0,0}};
	static int N,W,H;
	static int ans;
	
	public static void main(String[] args) throws Exception {
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			bd = new int[H+1][W+1];
			ans = Integer.MAX_VALUE;
			for(int i=0; i<H; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<W; j++) {
					bd[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			permu(0);
			if(ans==Integer.MAX_VALUE) ans=0;
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}
	static void permu(int r) {
		int[][] tmp = new int[H+1][W+1];
		if(r==N) {
			int cnt = 0;
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					if(bd[i][j]!=0) cnt++;
				}
			}
			ans = Math.min(ans, cnt);
			return;
		}
		for(int i=0; i<W; i++) {
			for(int h=0; h<H; h++) {
				for(int w=0; w<W; w++) {
					tmp[h][w] = bd[h][w];
				}
			}
			boolean flg = false;
			int y = 0;
			for(int h=0; h<H; h++) {
				if(bd[h][i]!=0) {
					flg = true;
					y=h;
					break;
				}
			}
			if(flg) {
				solve(i,y);
				down();
				permu(r+1);
				for(int h=0; h<H; h++) {
					for(int w=0; w<W; w++) {
						bd[h][w] = tmp[h][w];
					}
				}
			}
		}
	}
	static void solve(int w, int h) {
		int score = bd[h][w];
		bd[h][w] = 0;
		for (int k = 0; k < score; k++) {
			for (int n = 0; n < 4; n++) {
				int nh = h + d[0][n] * k;
				int nw = w + d[1][n] * k;
				if(inner(nh,nw)) 
					solve(nw, nh);
			}
		}
	}
	
	static void down() {
		for(int j=0; j<W; j++) {
			for(int i=H-1; i>0; i--) {
				if(bd[i][j]==0) {
					for(int k=i-1; k>=0; k--) {
						if(bd[k][j]!=0) {
							bd[i][j] = bd[k][j];
							bd[k][j] = 0;
							break;
						}
					}
				}
			}
		}
	}
	static boolean inner(int n, int m) {
		return 0<=n && n<H && 0<=m && m<W && bd[n][m]!=0;
	}
}
