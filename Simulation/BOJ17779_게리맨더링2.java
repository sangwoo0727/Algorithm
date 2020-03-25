import java.io.*;
import java.util.*;

public class BOJ17779_게리맨더링2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] bd;
	static boolean[][] visit;
	static int[] sum;
	static int[][] d = {{0,1,0},{-1,0,1}};
	static int N;
	static int ans = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		bd = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				bd[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int x=1; x<=N-2; x++) {
			for(int y=2; y<N; y++) {
				makeLine(x,y);
			}
		}
		System.out.println(ans);
	}
	static void checkSum(int x, int y,int d1, int d2) {
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(visit[i][j]==true) {
					int k=j+1;
					boolean flg = false;
					while(!visit[i][k]) {
						k++;
						if(k>N) {
							flg = true;
							break;
						}
					}
					if(flg) {
						sum[5]+= bd[i][j];
						continue;
					}
					else {
						for(int m=j; m<=k; m++) {
							sum[5] += bd[i][m];
						}
						j=k;
					}
				}else if(i< x+d1 && j<=y) {
					sum[1] += bd[i][j];
				}else if(i<= x+d2 && y<= j && j<=N) {
					sum[2] += bd[i][j];
				}else if(x+d1<=i && j<y-d1+d2) {
					sum[3] += bd[i][j];
				}else if(x+d2<=i && y-d1+d2<=j) {
					sum[4] += bd[i][j];
				}
			}
		}
		int Max = Integer.MIN_VALUE;
		int Min = Integer.MAX_VALUE;
		for(int i=1; i<=5; i++) {
			Max = Math.max(Max, sum[i]);
			Min = Math.min(Min, sum[i]);
		}
		ans = Math.min(ans, Max-Min);
	}
	static void makeLine(int x, int y) {
		for(int d1 = 1; d1 <= y-1; d1++) {
			for(int d2= 1; d2<= N-y; d2++) {
				if(x+d1+d2 > N || y-d1 <0 || y+d2>N) continue;
				visit = new boolean[N+1][N+1];
				int i=x, j=y;
				while(i<=x+d1 && j>=y-d1) {
					visit[i][j]=true;
					i++; j--;
				}
				i--; j++;
				while(i<=x+d1+d2 && j<=y-d1+d2) {
					visit[i][j]=true;
					i++; j++;
				}
				i=x; j=y;
				while(i<=x+d2 && j<=y+d2) {
					visit[i][j]=true;
					i++; j++;
				}
				i--; j--;
				while(i<=x+d1+d2 && j>=y+d2-d1) {
					visit[i][j]=true;
					i++; j--;
				}
				sum = new int[6];
				checkSum(x,y,d1,d2);
			}
		}
	}
	
}
