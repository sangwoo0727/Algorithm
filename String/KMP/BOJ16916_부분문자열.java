import java.io.*;
import java.util.*;

public class BOJ16916_부분문자열 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String P = br.readLine();
		if(solve(S,P)) System.out.println("1");
		else System.out.println("0");
	}
	static int[] getPi(String p) {
		int[] pi = new int[p.length()];
		int j=0;
		for(int i=1; i<p.length(); i++) {
			while(j>0 && p.charAt(i) != p.charAt(j)){
				j = pi[j-1];
			}
			if(p.charAt(i)==p.charAt(j)) {
				pi[i] = ++j;
			}
		}
		return pi;
	}
	static boolean solve(String s, String p) {
		int[] pi = getPi(p);
		int j=0;
		for(int i=0; i<s.length(); i++) {
			while(j>0 && s.charAt(i)!= p.charAt(j)) {
				j=pi[j-1];
			}
			if(s.charAt(i)==p.charAt(j)) {
				if(j==p.length()-1) {
					j = pi[j];
					return true;
				}else j++;
			}
		}
		return false;
	}
}
