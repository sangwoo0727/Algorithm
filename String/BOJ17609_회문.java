import java.io.*;
import java.util.*;
public class BOJ17609_회문 {
	static char[] str;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for(int t=0; t<tc; t++) {
			str = br.readLine().toCharArray();
			sb.append(solve()).append("\n");
		}
		System.out.println(sb);
	}
	static int solve() {
		if(is()) return 0;
		else if(can(0,str.length-1,false)) return 1;
		else return 2;
	}
	static boolean can(int l, int r,boolean flg) {
		if(l>r) return true;
		if(str[l]==str[r]) return can(l+1,r-1,flg);
		else if(!flg){
			return can(l+1,r,true) || can(l,r-1,true);
		}else {
			return false;
		}
	}
	static boolean is() {
		int l=0, r=str.length-1;
		while(l<=r) {
			if(str[l]!=str[r]) {
				return false; 
			}
			l++; r--;
		}
		return true;
	}
}
