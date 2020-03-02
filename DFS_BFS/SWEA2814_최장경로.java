import java.util.*;
import java.io.*;

public class SWEA2814_최장경로 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static List<Integer>[] v;
	static boolean[] visit;
	static int N,M;
	static int Max;
	
	public static void main(String[] args) throws Exception {
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			sb.append("#").append(t).append(" ");
			Max = Integer.MIN_VALUE;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			v = new ArrayList[N+1];
			visit = new boolean[N+1];
			for(int i=1; i<=N; i++) {
				v[i] = new ArrayList<>();
			}
			for(int m=0; m<M; m++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				v[a].add(b);
				v[b].add(a);
			}
			for(int i=1; i<=N; i++) {
				Arrays.fill(visit, false);
				dfs(i,1);
			}
			sb.append(Max).append("\n");
		}
		System.out.println(sb);
	}
	static void dfs(int n,int cnt) {
		visit[n] = true;
		Max = Math.max(Max, cnt);
		for(int k=0; k<v[n].size(); k++) {
			int nn = v[n].get(k);
			if(!visit[nn]) {
				dfs(nn,cnt+1);
				visit[nn] = false;
			}
		}
	}
}
