package homework;

import java.util.*;
import java.io.*;

public class Main_bj_2580_스도쿠_서울_06_강상우 {
	static int[][] bd = new int[10][10];
	static List<Pair> v = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<9; j++) {
				bd[i][j] = Integer.parseInt(st.nextToken());
				if(bd[i][j]==0) {
					v.add(new Pair(i,j));
				}
			}
		}
		if(solve(0)) {
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					System.out.print(bd[i][j]+" ");
				}
				System.out.println();
			}
		}
	}
	static boolean solve(int idx) {
		if(idx >= v.size()) return true;
		int n = v.get(idx).n;
		int m = v.get(idx).m;
		boolean flg = false;
		for(int i=1; i<=9; i++) {	
			if(check(n,m,i)) {
				 bd[n][m] = i;
				 flg = solve(idx+1);
				 if(flg) return flg;
				 bd[n][m] = 0;
			}
		}
		return false;
	}
	static boolean check(int n, int m, int num) {
		int nroom = inner(n);
		int mroom = inner(m);
		for(int j=0; j<9; j++) {
			if(num == bd[n][j]) return false;
			if(num == bd[j][m]) return false;
		}
		for(int i=nroom*3; i<nroom*3+3; i++) {
			for(int j=mroom*3; j<mroom*3+3; j++) {
				if(num==bd[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
	
	static int inner(int n) {
		if(n<3) return 0;
		else if(3<=n && n<6) return 1;
		else return 2;
	}
	static class Pair{
		int n; int m;
		Pair(int n, int m){this.n=n; this.m=m;}
	}
}
