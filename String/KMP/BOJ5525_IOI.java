import java.io.*;
import java.util.*;

public class BOJ5525_IOI {
	static int N,M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		StringBuilder pattern = new StringBuilder();
		pattern.append("I");
		for(int i=0; i<N; i++) {
			pattern.append("O").append("I");
		}
		String S = br.readLine();
		System.out.println(kmp(S,pattern.toString()));
	}
	static int[] makeTable(String p) {
		int[] table = new int[p.length()];
		int j=0;
		for(int i=1; i<table.length; i++) {
			if(p.charAt(i)==p.charAt(j)) {
				table[i] = ++j; 
			}else {
				while(j>0 && p.charAt(i)!=p.charAt(j)) {
					j = table[j-1];
				}
			}
		}
		return table;
	}
	static int kmp(String s, String p) {
		int[] table = makeTable(p);
		int cnt = 0;
		int j = 0;
		for(int i=0; i<s.length(); i++) {
			while(j>0 && s.charAt(i)!=p.charAt(j)) {
				j = table[j-1];
			}
			if(s.charAt(i)==p.charAt(j)) {
				if(j==p.length()-1) {
					cnt++;
					System.out.println(i);
					j = table[j];
				}else {
					j++;
				}
			}
		}
		return cnt;
	}
}
