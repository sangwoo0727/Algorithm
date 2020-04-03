import java.io.*;
import java.util.*;

public class BOJ6502_동혁피자 {
	static int r,w,l;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int tc = 1;
		while(tc>0) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			if(r==0) break;
			w = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			sb.append("Pizza ").append(tc).append(" ");
			if(Math.pow(2*r, 2) >= Math.pow(w, 2) + Math.pow(l, 2))
				sb.append("fits on the table.").append("\n");
			else
				sb.append("does not fit on the table.").append("\n"); 
			tc++;
		}
		System.out.println(sb);
	}
}
