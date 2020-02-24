import java.util.*;
import java.io.*;

public class C_RestoringPermutation {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = null;
    static StringTokenizer st = null;
    static int n;
    static int[] ba;
    static boolean[] ck;
    
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = null;
		int tc = Integer.parseInt(br.readLine());
		while(tc-- >0) {
			n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			ba = new int[n+1];
			ck = new boolean[2*n+2];
			boolean flg = false;
			for(int i=1; i<=n; i++) {
				ba[i] = Integer.parseInt(st.nextToken());
				if(ba[i]>=2 * n) {
					flg = true;
				}else {
					ck[ba[i]]=true;
				}
			}
			StringBuilder ans = new StringBuilder();
			for(int i=1; i<=n; i++) {
				ans.append(ba[i]).append(" ");
				int tmp = ++ba[i];
				while(ck[tmp] && tmp<=2*n) {
					tmp++;
				}
				if(tmp<=2*n) {
					ans.append(tmp).append(" ");
					ck[tmp]=true;	
				}else {
					flg = true;
					break;
				}
			}
			if(flg) sb.append("-1").append("\n");
			else sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}
}