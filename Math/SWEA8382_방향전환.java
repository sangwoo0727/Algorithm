import java.io.*;
import java.util.*;

public class SWEA8382_방향전환 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int n,m,nn,nm;
	
	public static void main(String[] args) throws Exception {
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			nn = Integer.parseInt(st.nextToken());
			nm = Integer.parseInt(st.nextToken());
			int ans = 0;
			int xlen = Math.abs(nn-n);
			int ylen = Math.abs(nm-m);
			if(xlen<ylen) {
				int tmp = xlen; xlen = ylen; ylen = tmp; 
			}
			ans += 2*ylen;
			if((xlen-ylen)%2==0) ans += (xlen-ylen)*2;
			else ans += (xlen-ylen)*2-1;
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}
}
