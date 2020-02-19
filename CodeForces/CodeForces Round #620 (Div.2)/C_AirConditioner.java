import java.io.*;
import java.util.*;
 
 
public class C_AirConditioner{	
	static int[][] cus = new int[100][3];
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		while(tc-- >0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				cus[i][0] = Integer.parseInt(st.nextToken());
				cus[i][1] = Integer.parseInt(st.nextToken());
				cus[i][2] = Integer.parseInt(st.nextToken());
			}
			Boolean flg = false;
			int before = 0;
			int ml = m, mr = m;
			for(int i=0; i<n; i++) {
				mr += cus[i][0]	- before;
				ml -= cus[i][0] - before;
				if(mr < cus[i][1] || ml > cus[i][2]) {
					flg = true;
					break;
				}
				mr = Math.min(mr, cus[i][2]);
				ml = Math.max(ml, cus[i][1]);
				before = cus[i][0];
			}
			if(!flg) sb.append("YES").append("\n");
			else sb.append("NO").append("\n");
		}
		System.out.println(sb);
	}
}