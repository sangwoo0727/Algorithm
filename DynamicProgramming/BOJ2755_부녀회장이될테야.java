import java.io.*;
import java.util.*;

public class BOJ2755_부녀회장이될테야 {
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] apart;
	static int k,n;
	
	public static void main(String[] args) throws Exception {
		int tc = Integer.parseInt(br.readLine());
		pp();
		while(tc-- >0) {
			k = Integer.parseInt(br.readLine());
			n = Integer.parseInt(br.readLine());
			sb.append(apart[k][n]).append("\n");
		}
		System.out.println(sb);
	}
	public static void pp() {
		apart = new int[15][15];
		for(int i=1; i<15; i++) {
			apart[0][i] = i;
		}
		for(int i=1; i<15; i++) {
			apart[i][1] = apart[i-1][1];
			for(int j=2; j<15; j++) {
				apart[i][j] = apart[i][j-1] + apart[i-1][j];
			}
		}
	}
}

