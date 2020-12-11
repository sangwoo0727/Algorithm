import java.io.*;
import java.util.*;

public class BOJ11404_플로이드 {
	static int N,M;
	static int[][] adj;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		adj = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				adj[i][j] = -1;
			}
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			if(adj[u][v]==-1) adj[u][v]=w;
			else adj[u][v] = Math.min(adj[u][v], w);
		}
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				if(k==i) continue;
				for(int j=1; j<=N; j++) {
					if(k==j || j==i) continue;
					if(adj[i][k]!=-1 && adj[k][j]!=-1) {
						if(adj[i][j]==-1) adj[i][j] = adj[i][k]+adj[k][j];
						else adj[i][j] = Math.min(adj[i][j], adj[i][k]+adj[k][j]);
					}
				}
			}
		}
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(adj[i][j]==-1) sb.append("0").append(" ");
				else sb.append(adj[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
