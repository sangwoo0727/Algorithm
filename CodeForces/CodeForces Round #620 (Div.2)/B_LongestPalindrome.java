import java.io.*;
import java.util.*;
 
public class B_LongestPalindrome {
	static int N,M;
	static HashMap<String,Integer> map = new HashMap<>();
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());

		String OwnPalind = null;
		boolean flg = false;
		for(int n=0; n<N; n++) {
			String s = br.readLine();
			String rev = reverseString(s);
			if(s.equals(rev) && !flg) {
				OwnPalind = s;
				flg = true;
			}else {
				if(s.equals(rev)) continue;
				map.put(s, 0);
			}
		}
		for(String s: map.keySet()) {
			String rev = reverseString(s);
			if(map.get(s)==0) {
				if(map.containsKey(rev)) {
					sb.insert(sb.length()/2, s+rev);
					map.put(s, 1);
					map.put(rev, 1);
				}
			}
		}
		if(flg) {
			sb.insert(sb.length()/2, OwnPalind);
		}
		System.out.println(sb.length());
		System.out.println(sb);
	}
	public static String reverseString(String s) {
		return (new StringBuilder(s)).reverse().toString();
	}
}