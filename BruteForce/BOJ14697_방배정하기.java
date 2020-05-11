import java.io.*;
import java.util.*;

public class BOJ14697_방배정하기 {
	static int a,b,c,n;
	static boolean flg;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		l : for(int i=0; a*i<= n; i++) {
			int ta = a*i;
			if(ta == n) {
				flg = true;
				break l;
			}
			for(int j=0; b*j <= n-ta; j++) {
				int tb = b*j;
				if(ta+tb == n) {
					flg = true;
					break l;
				}
				for(int k=0; c*k <= n-ta-tb; k++) {
					int tc = c*k;
					if(ta+tb+tc == n) {
						flg = true;
						break l;
					}
				}
			}
		}
		if(flg) System.out.println(1);
		else System.out.println(0);
	}
}
