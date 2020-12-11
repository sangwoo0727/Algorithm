import java.io.*;
import java.util.*;

public class SWEA5643_키순서 {
	static int[][] dist;
	static int[] cnt;
	static int N,M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			sb.append("#").append(t).append(" ");
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			dist = new int[N][N];
			cnt = new int[N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(i==j) dist[i][j] = 0;
					else dist[i][j] = Integer.MAX_VALUE;
				}
			}
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				dist[a-1][b-1] = 1;
			}
			for(int k=0; k<N; k++) {
				for(int i=0; i<N; i++) {
					if(i==k) continue;
					for(int j=0; j<N; j++) {
						if(j==k || j==i) continue;
						if(dist[i][k]!=Integer.MAX_VALUE && dist[k][j]!=Integer.MAX_VALUE){
							dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);							
						}
					}
				}
			}
			int ans = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(i==j) continue;
					if(dist[i][j]!=Integer.MAX_VALUE) {
						cnt[i]++;
						cnt[j]++;
					}
				}
			}
			for(int c: cnt) {
				if(c==N-1) ans++;
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}
	
}
