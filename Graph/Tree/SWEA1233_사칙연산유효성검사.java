import java.io.*;
import java.util.*;


public class Solution {
	static int N,C,R;
	static char[][] arr;
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		N = s.length();
		int sq = (int) Math.sqrt(N);
		for(int i=1; i<=sq; i++) {
			if(N%i==0) {
				System.out.println(i+" "+ N/i);
				R=i;
				C=N/R;
			}
		}
		arr = new char[R+1][C+1];
		int idx = 0;
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				arr[r][c]=s.charAt(idx++);
			}
		}
		for(int c=0; c<C; c++) {
			for(int r=0; r<R; r++) {
				sb.append(arr[r][c]);
			}
		}
		System.out.println(sb);
	}
	
}