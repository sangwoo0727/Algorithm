import java.io.*;
import java.util.*;

public class BOJ6987_월드컵 {
	static int[][] input;
	static int[][] match = {{0,0,0,0,0,1,1,1,1,2,2,2,3,3,4},{1,2,3,4,5,2,3,4,5,3,4,5,4,5,5}};
	static boolean flg;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		for(int t=0; t<4; t++) {
			flg = false;
			st = new StringTokenizer(br.readLine());
			input = new int[6][3];
			for(int i=0; i<6; i++) {
				for(int j=0; j<3; j++) {
					input[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i=0; i<6; i++) {
				int sum = 0;
				for(int j=0; j<3; j++) {
					sum += input[i][j];
				}
				if(sum!=5) {
					sb.append("0 ");
					flg = true;
					break;
				}
			}
			if(!flg) {
				solve(0);
				sb.append(flg? 1 : 0).append(" ");
			}
		}
		System.out.println(sb);
	}
	static void solve(int r) {
		if(r==15) {
			flg = true;
			return;
		}
		int i = match[0][r];
		int j = match[1][r];
		if(input[i][0]>0 && input[j][2]>0) {
			input[i][0]-=1;
			input[j][2]-=1;
			solve(r+1);
			if(flg) return;
			input[i][0]+=1;
			input[j][2]+=1;
		}
		if(!flg && input[i][1]>0 && input[j][1]>0) {
			input[i][1]-=1;
			input[j][1]-=1;
			solve(r+1);
			if(flg) return;
			input[i][1]+=1;
			input[j][1]+=1;
		}
		if(!flg && input[i][2]>0 && input[j][0]>0) {
			input[i][2]-=1;
			input[j][0]-=1;
			solve(r+1);
			if(flg) return;
			input[i][2]+=1;
			input[j][0]+=1;
		}
	}
}
