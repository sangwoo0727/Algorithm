import java.io.*;
import java.util.*;

public class BOJ16946_벽부수고이동하기4 {
	static int N,M;
	static int[][] bd;
	static int[][] visit;
	static int[][] d = {{0,0,-1,1},{1,-1,0,0}};
	static HashMap<Integer,Integer> map = new HashMap<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		bd = new int[N][M];
		visit = new int[N][M];
		for(int i=0; i<N; i++) {
			char[] arr = br.readLine().toCharArray();
			for(int j=0; j<M; j++) {
				bd[i][j] = arr[j]-'0';
			}
		}
		int count = 1;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(visit[i][j]==0&&bd[i][j]==0) {
					floodFill(i,j,count);
					count++;
				}
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(bd[i][j]==0) sb.append(0);
				else {
					int total = 0;
					int[] dir = new int[4];
					for(int k=0; k<4; k++) {
						int nn=i+d[0][k];
						int nm=j+d[1][k];
						if(0<=nn && nn<N && 0<=nm && nm<M) {
							int sec = visit[nn][nm];
							boolean flg = false;
							for(int w=0; w<=k; w++) {
								if(dir[w]==sec) {
									flg = true;
									break;
								}
							}
							if(flg) continue;
							else {
								dir[k]=sec;
								total += map.get(sec)%10;
							}
						}
					}
					sb.append(total+1);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	static void floodFill(int sn,int sm,int num) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(sn,sm));
		int cnt = 0;
		while(!q.isEmpty()) {
			Pair p = q.poll();
			int n = p.n;
			int m = p.m;
			visit[n][m]=num;
			cnt++;
			for(int k=0; k<4; k++) {
				int nn = n+d[0][k];
				int nm = m+d[1][k];
				if(inner(nn,nm)) {
					visit[nn][nm]=num;
					q.offer(new Pair(nn,nm));
				}
			}
		}
		map.put(num, cnt);
	}
	static boolean inner(int n,int m) {
		return 0<=n && n<N && 0<=m && m<M && visit[n][m]==0 && bd[n][m]==0;
	}
	static class Pair{
		int n,m;
		Pair(int n,int m){this.n=n; this.m=m;}
	}
}
