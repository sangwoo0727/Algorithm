import java.io.*;
import java.util.*;

public class SWEA2112_보호필름 {
	static int N,M,K,ans;
	static int[][] bd;
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
			ans = N;
			bd = new int[N][M];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<M; j++) {
					bd[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			dfs(0,0);
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}
	static void dfs(int r, int idx) {
		if(r>=ans) return;
		if(r>N) return;
		if(idx==N) {
			if(check(bd)) {
				ans = Math.min(ans, r);
			}			
		}
		if(idx>=N) return;
		int[] tmp = new int[M];
		for(int j=0; j<M; j++) {
			tmp[j] = bd[idx][j];
		}
		for(int j=0; j<M; j++) {
			bd[idx][j] = 0;
		}
		dfs(r+1,idx+1);
		for(int j=0; j<M; j++) {
			bd[idx][j] = 1;
		}
		dfs(r+1,idx+1);
		for(int j=0; j<M; j++) {
			bd[idx][j] = tmp[j];
		}
		dfs(r,idx+1);
	}
	static boolean check(int[][] tbd) {
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
				return false;
			}
		}
		return true;
	}
}
