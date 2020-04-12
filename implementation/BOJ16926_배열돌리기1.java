import java.io.*;
import java.util.*;

public class BOJ16926_배열돌리기1 {
	static int N,M,R;
	static int[][] bd;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		bd = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				bd[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int startN=0, startM=0;
		int endN=N-1, endM=M-1;
		while((startN<endN) && (startM<endM)) {
			rounding(startN,startM,endN,endM);
			startN++; startM++; endN--; endM--;
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				sb.append(bd[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	static void rounding(int n,int m, int en, int em) {
		int cycle = (en-n+1)*2 + (em-1-m)*2;
		Queue<Integer> q = new LinkedList<>();
		for(int j=m; j<em; j++)
			q.offer(bd[n][j]);
		for(int i=n; i<en; i++) 
			q.offer(bd[i][em]);
		for(int j=em; j>m; j--)
			q.offer(bd[en][j]);
		for(int i=en; i>n; i--)
			q.offer(bd[i][m]);
		int tmp = R%cycle;
		while(tmp-->0) {
			int val = q.poll();
			q.offer(val);
		}
		for(int j=m; j<em; j++)
			bd[n][j] = q.poll();
		for(int i=n; i<en; i++) 
			bd[i][em] = q.poll();
		for(int j=em; j>m; j--)
			bd[en][j] = q.poll();
		for(int i=en; i>n; i--)
			bd[i][m] = q.poll();
	}
}
