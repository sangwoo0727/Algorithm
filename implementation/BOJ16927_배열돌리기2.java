import java.io.*;
import java.util.*;

public class BOJ16927_배열돌리기2 {
	static int N,M,R;
	static int[][] bd;
	static int sn,sm,en,em;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
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
		en = N-1; em = M-1;
		while(sn<en && sm<em) {
			round();
			sn++; en--; sm++; em--;
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				sb.append(bd[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	static void round() {
		int cnt = (em-sm+1)*2 + (en-sn-1)*2;
		cnt = R%cnt;
		Queue<Integer> q = new LinkedList<>();
		for(int j=sm; j<em; j++)
			q.offer(bd[sn][j]);
		for(int i=sn; i<en; i++)
			q.offer(bd[i][em]);
		for(int j=em; j>sm; j--)
			q.offer(bd[en][j]);
		for(int i=en; i>sn; i--)
			q.offer(bd[i][sm]);
		while(cnt-->0) {
			int tmp = q.poll();
			q.offer(tmp);
		}
		for(int j=sm; j<em; j++)
			bd[sn][j] = q.poll();
		for(int i=sn; i<en; i++)
			bd[i][em] = q.poll();
		for(int j=em; j>sm; j--)
			bd[en][j] = q.poll();
		for(int i=en; i>sn; i--)
			bd[i][sm] = q.poll();	
	}
}
