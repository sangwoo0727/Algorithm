import java.io.*;
import java.util.*;

public class SWEA2112_보호필름 {
	static int[][] bd;
	static int[] input;
	static int N,M,K;
	static boolean total;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			bd = new int[N][M];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<M; j++) {
					bd[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			total = false;
			for(int i=0; i<=N; i++) {
				input = new int[i];
				comb(0,0,i);
				if(total) {
					sb.append(i).append("\n");
					break;
				}
			}
		}
		System.out.println(sb);
	}
	static void comb(int idx, int r, int R) {
		if(R==0) {
			if(!check(bd)) {
				total = true;
			}
			return;
		}else {
			if(r>=R) {
				if(!check(bd)) {
					total = true;
				}
				return;
			}
			if(idx>=N) return;
			int[][] tmp = new int[N][M];
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					tmp[i][j] = bd[i][j];
				}
			}
			for(int j=0; j<M; j++) {
				bd[idx][j]=1;
			}
			comb(idx+1,r+1,R);
			for(int j=0; j<M; j++) {
				bd[idx][j]=0;
			}
			if(total) return;
			comb(idx+1,r+1,R);
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					bd[i][j] = tmp[i][j];
				}
			}
			if(total) return;
			comb(idx+1,r,R);
		}
	}
	static boolean check(int[][] tbd) {
		boolean tflg = false;
		for(int j=0; j<M; j++) {
			boolean flg = false;
			int n = tbd[0][j];
			int cnt = 1;
			for(int i=1; i<N; i++) {
				if(cnt>=K) {
					flg = true;
					break;
				}
				if(n==tbd[i][j]) {
					cnt++;
				}else {
					cnt = 1;
					n = tbd[i][j];
				}
			}
			if(cnt>=K) flg = true;
			if(flg) continue;
			else {
				tflg = true;
				break;
			}
		}
		return tflg;
	}
}