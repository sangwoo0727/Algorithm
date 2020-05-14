import java.io.*;
import java.util.*;

public class BOJ2458_키순서 {
	static int[][] bd;
	static int[] output;
	static int N,M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		bd = new int[N][N];
		output = new int[N];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			bd[a][b] = 1;
		}
		for(int k=0; k<N; k++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(bd[i][k]==1 && bd[k][j]==1) bd[i][j]=1;
				}
			}
		}
		int ans = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(bd[i][j]==1) {
					output[j]++;
					output[i]++;
				}
			}
		}
		for(int c: output) {
			if(c==N-1) ans++;
		}
		System.out.println(ans);
	}
}
