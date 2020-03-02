
import java.io.*;
import java.util.*;

public class SWEA4534_트리흑백색칠 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static final int MOD = 1000000007;
	static List<Integer>[] v;
	static boolean[] visit;
	static int[][] dp;
	static int N;
	
	
	public static void main(String[] args) throws Exception {
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			sb.append("#").append(t).append(" ");
			N = Integer.parseInt(br.readLine());
			v = new ArrayList[N+1];
			dp = new int[2][N+1];
			visit = new boolean[N+1];
			for(int i=1; i<=N; i++) {
				v[i] = new ArrayList<>();
			}
			for(int i=1; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				v[a].add(b);
				v[b].add(a);
			}
			sb.append(((solve(0,1)%MOD + solve(1,1)%MOD)%MOD)).append("\n");
		}
		System.out.println(sb);
	}
	static int solve(int col, int node) {
		visit[node]=true;
		if(dp[col][node]!=0) {
			return dp[col][node];
		}
		
		if(col==0) { //white
			long tmp = 1;
			for(int k=0; k<v[node].size(); k++) {
				int nn = v[node].get(k);
				if(!visit[nn]) {
					int sum = 0;
					visit[nn]=true;
					sum = (sum + (solve(0,nn)%MOD + solve(1,nn)%MOD)%MOD)%MOD;
					tmp = (tmp*sum)%MOD;
					visit[nn]=false;
				}
			}
			visit[node] = false;
			return dp[0][node] = (int)(tmp%MOD);
			
		}else{ //black
			long tmp = 1;
			for(int k=0; k<v[node].size(); k++) {
				int nn = v[node].get(k);
				if(!visit[nn]) {
					int sum = 0;
					visit[nn]=true;
					sum = (sum + solve(0,nn)%MOD)%MOD;	
					tmp = (tmp*sum)%MOD;
					visit[nn]=false;
				}
			}
			visit[node]=false;
			return dp[1][node] = (int)(tmp%MOD);
		}
		
	}
}
