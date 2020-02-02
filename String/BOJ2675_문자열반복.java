import java.util.*;
import java.io.*;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			String s = st.nextToken();
			for(int i=0; i<s.length();i++) {
				for(int k=0; k<n; k++) {
					sb.append(s.charAt(i));
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}