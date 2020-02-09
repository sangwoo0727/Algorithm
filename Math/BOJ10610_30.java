import java.io.*;
import java.util.*;

public class BOJ10610_30 {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] ca= br.readLine().toCharArray();
		boolean flg = false;
		Arrays.sort(ca);
		int sum = 0;
		if(ca[0]=='0') flg = true;
		for(int i=0; i<ca.length; i++) {
			sum += ca[i];
		}
		if(sum%3==0 && flg) {
			sb.append(new String(ca)).reverse();
			System.out.println(sb);
		}else {
			System.out.println("-1");
		}
	}
}