import java.io.*;
import java.util.*;

public class BOJ17825_주사위윷놀이 {
	static int[][] bd = {
			{0,2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40},
			{10,13,16,19,25},
			{20,22,24,25},
			{30,28,27,26,25},
			{25,30,35,40,-1}
	};
	static boolean[][] visit;
	static int[] move = new int[10];
	static int[][] mal = new int[4][2];
	static int Max = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<10; i++) {
			move[i] = Integer.parseInt(st.nextToken());
		}
		visit = new boolean[5][];
		for(int i=0; i<5; i++) {
			visit[i] = new boolean[bd[i].length];
		}
		rep(0,0);
		System.out.println(Max);
	}
	static void rep(int r,int ans) {
		if(r==10) {
			Max = Math.max(Max,ans);
			return;
		}
		for(int i=0; i<4; i++) {
			int d = move[r];
			int n = mal[i][0];
			int m = mal[i][1];
			if(n==-1 && m==-1) continue;
			int nn = n, nm = m+d;
			visit[n][m] = false;
			if(n==0) {
				if(nm > 20) {
					nn = -1; nm = -1;
					mal[i][0] = -1;
					mal[i][1] = -1;
				}else if(bd[nn][nm]==10) {
					if(visit[1][0]) {
						visit[n][m] =true;
						continue;
					}
					nn = 1; nm = 0;
				}else if(bd[nn][nm]==20) {
					if(visit[2][0]) {
						visit[n][m] =true;
						continue;
					}
					nn = 2; nm = 0;
				}else if(bd[nn][nm]==30) {
					if(visit[3][0]) {
						visit[n][m] =true;
						continue;
					}
					nn = 3; nm = 0;
				}else if(bd[nn][nm]==40){
					if(visit[4][3]) {
						visit[n][m] =true;
						continue;
					}
					nn = 4; nm = 3;
				}else if(visit[nn][nm]) {
					visit[n][m] =true;
					continue;
				}
			}else {
				if(n==1 || n==3) {
					if(nm >= 4) {
						nn = 4;
						nm = nm-4;
						if(nm >=4) {
							nn = -1; nm = -1;
							mal[i][0] = -1;
							mal[i][1] = -1;
						}else if(visit[nn][nm]) {
							visit[n][m] = true;
							continue;
						}
					}else if(visit[nn][nm]) {
						visit[n][m] = true;
						continue;
					}
				}else if(n==2) {
					if(nm >= 3) {
						nn = 4; nm = nm-3;
						if(nm >= 4) {
							nn = -1; nm = -1;
							mal[i][0] = -1;
							mal[i][1] = -1;
						}else if(visit[nn][nm]) {
							visit[n][m] = true;
							continue;
						}
					}else if(visit[nn][nm]) {
						visit[n][m] = true;
						continue;
					}
				}else if(n==4) {
					if(nm >= 4) {
						nn = -1; nm = -1;
						mal[i][0] = -1;
						mal[i][1] = -1;
					}else if(visit[nn][nm]) {
						visit[n][m] = true;
						continue;
					}
				}
			}
			if(nn!=-1) {
				visit[nn][nm] = true;
				mal[i][0] = nn;
				mal[i][1] = nm;
			}
			rep(r+1, nn==-1? ans: ans+bd[nn][nm]);
			if(nn!=-1) {
				visit[nn][nm] = false;
			}
			mal[i][0] = n;
			mal[i][1] = m;
			visit[n][m] = true;	
		}
	}
}