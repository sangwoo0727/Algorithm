import java.util.*;
import java.io.*;

public class Solution {
	static int[][] arr;
	static int N;
	public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("res/sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			int dir = 1, len = N, num = 1;
			int i=0,j=-1;
			while(true) {
				for(int k=0; k<len; k++) {
					j += dir;
					arr[i][j]= num++;
				}
				len--;
				if(len < 0) break;
				for(int k=0;k<len;k++) {
					i += dir;
					arr[i][j] = num++;
				}
				dir *= -1;
			}
			System.out.println("#"+t);
			for(int n=0;n<N;n++) {
				for(int m=0;m<N;m++) {
					System.out.print(arr[n][m]+" ");
				}
				System.out.println();
			}
		}
    }

}
