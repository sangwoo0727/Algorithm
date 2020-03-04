
import java.io.*;
import java.util.*;

public class B_Kuroni_and_Simple_Strings {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static boolean[] ck;
	
	public static void main(String[] args) throws Exception {
		String s = br.readLine();
		StringBuilder sb = new StringBuilder();
		ck = new boolean[s.length()];
		int k = 0;
		while(true) {
			int l=0;
			int r=s.length()-1;
			boolean flg = false;
			while(l<r) {
				if(ck[l]==true) {
					l++; continue;
				}
				if(ck[r]==true) {
					r--; continue;
				}
				if(s.charAt(l)=='(' && s.charAt(r)==')') {
					flg = true;
					ck[l]=true;
					ck[r]=true;
					l++; r--;
				}else if(s.charAt(l)=='(' && s.charAt(r)=='(') {
					r--;
				}else if(s.charAt(l)==')' && s.charAt(r)==')') {
					l++;
				}else {
					l++; r--;
				}
			}
			if(flg) k++;
			else break;
		}
		int cnt = 0;
		
		for(int i=0; i<ck.length; i++) {
			if(ck[i]) {
				cnt++;
				sb.append(i+1).append(" ");
			}
		}
		if(k==0) {
			System.out.println(k);	
		}else {
			System.out.println(k);	
			System.out.println(cnt);
			System.out.println(sb);
		}
	}
}
