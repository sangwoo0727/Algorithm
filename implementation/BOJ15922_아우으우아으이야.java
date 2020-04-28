import java.io.*;
import java.util.*;

public class BOJ15922_아우으우아으이야 {
	static int result,sn,en;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if(i==0) {
				sn = x; en = y;
				continue;
			}
			if(sn==x) {
				en = y;
				continue;
			}
			if(sn < x) {
				if(en < x) {
					result += en-sn;
					sn = x; en = y;
				}else {
					if(en < y) en = y;
				}
			}
		}
		result += en-sn;
		System.out.println(result);
	}
}
