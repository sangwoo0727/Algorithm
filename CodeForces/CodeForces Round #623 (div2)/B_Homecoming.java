import java.util.*;
import java.io.*;

public class B_Homecoming {
	static int a,b,p;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = null;
    static StringTokenizer st = null;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = null;
		int tc = Integer.parseInt(br.readLine());
		while(tc-- >0) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			p = Integer.parseInt(st.nextToken());
			String s = br.readLine();
			int n = s.length()-1;
			int pidx = n;
			for(int i=n-1; i>=0; i--) {
				if(i==0) {
					if(s.charAt(i)=='A' && p-a>=0) {
						pidx = 0;
					}else if(s.charAt(i)=='B' && p-b>=0) {
						pidx = 0;
					}
				}else if(s.charAt(i)!=s.charAt(i-1)) {
					if(s.charAt(i)=='B') {
						if(p-b>=0) {
							p-=b;
							pidx = i;
						}else break;
					}else {
						if(p-a>=0) {
							p-=a;
							pidx = i;
						}else break;
					}
				}
			}
			
			sb.append(pidx+1).append("\n");
		}
		System.out.println(sb);
	}
}