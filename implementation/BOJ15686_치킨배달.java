import java.io.*;
import java.util.*;

public class BOJ15686_치킨배달 {
	static int N,M;
	static int[][] bd;
	static List<Pair> list = new ArrayList<>();
	static Pair[] input;
	static int ans = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		bd = new int[N][N];
		input = new Pair[M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				bd[i][j] = Integer.parseInt(st.nextToken());
				if(bd[i][j]==2) {
					list.add(new Pair(i,j));
				}
			}
		}
		comb(0,0);
		System.out.println(ans);
	}
	static void calc() {
		int sum=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(bd[i][j]==1) {
					int Min = Integer.MAX_VALUE;
					for(int k=0; k<input.length; k++) {
						Min= Math.min(Min, Math.abs(i-input[k].n)+Math.abs(j-input[k].m)); 
					}
					sum+=Min;
				}
			}
		}
		ans = Math.min(ans, sum);
	}
	static void comb(int idx, int r) {
		if(r==M) {
			calc();
			return;
		}
		if(idx>=list.size()) return;
		input[r]=list.get(idx);
		comb(idx+1,r+1);
		comb(idx+1,r);
	}
	static class Pair{
		int n,m;
		Pair(int n, int m){this.n=n; this.m=m;}
	}
}
