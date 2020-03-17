import java.io.*;
import java.util.*;

public class SWEA4012_요리사 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static boolean[] ck;
	static int[][] bd;
	static int[] a,b;
	static int N,Min;
	
	public static void main(String[] args) throws Exception {
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			sb.append("#").append(t).append(" ");
			N = Integer.parseInt(br.readLine());
			Min = Integer.MAX_VALUE;
			bd = new int[N+1][N+1];
			ck = new boolean[N+1];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					bd[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			comb(0,0);
			sb.append(Min).append("\n");
		}
		System.out.println(sb);
	}
	static void comb(int r, int idx) {
		if(Min==0) return;
		if(r==N/2) {
			int ls=0,rs=0;
			a = new int[N/2];
            b = new int[N/2];
            int ai=0,bi=0;
            for(int i=0; i<N; i++) {
                if(ck[i]) a[ai++]=i;
                else b[bi++]=i;
            }
			for(int i=0; i<r-1; i++) {
				for(int j=i+1; j<r; j++) {
					ls += bd[a[i]][a[j]]+bd[a[j]][a[i]];
					rs += bd[b[i]][b[j]]+bd[b[j]][b[i]];
				}
			}
			Min = Math.min(Min, Math.abs(ls-rs));
			return;
		}
		if(idx>=N) return;
		ck[idx]=true;
		comb(r+1,idx+1);
		ck[idx]=false;
		comb(r,idx+1);
	}
}
