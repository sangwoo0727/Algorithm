import java.io.*;
import java.util.*;

public class SWEA1953_탈주범검거 {
	static boolean[][] tun = {
			{true,true,true,true},
			{true,false,true,false},
			{false,true,false,true},
			{true,true,false,false},
			{false,true,true,false},
			{false,false,true,true},
			{true,false,false,true}
	};
	static int[][] bd;
	static boolean[][] visit;
	static int[][] d = {{-1,0,1,0},{0,1,0,-1}};
	static int N,M,R,C,L;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			bd = new int[N][M];
			visit = new boolean[N][M];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<M; j++) {
					bd[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			bfs();
			int ans = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(visit[i][j]) ans++;
				}
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}
	static void bfs() {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(R,C,1));
		while(!q.isEmpty()) {
			int n = q.peek().n;
			int m = q.peek().m;
			int cnt = q.poll().cnt;
			visit[n][m] = true;
			if(cnt==L) break;
			int tnum = bd[n][m]-1;
			for(int k=0; k<4; k++) {
				if(tun[tnum][k]) {
					int nn = n+d[0][k];
					int nm = m+d[1][k];
					if(inner(nn,nm)) {
						int tmp = bd[nn][nm]-1;
						if(ckPos(k,tmp)) {
							q.offer(new Node(nn,nm,cnt+1));
							visit[nn][nm]=true;							
						}
					}
				}
			}
		}
	}
	static boolean ckPos(int k, int tmp) {
		if(k==0 && tun[tmp][2]) return true;
		if(k==1 && tun[tmp][3]) return true;
		if(k==2 && tun[tmp][0]) return true;
		if(k==3 && tun[tmp][1]) return true;
		return false;
	}
	static boolean inner(int n, int m) {
		return 0<=n && n<N && 0<=m && m<M && !visit[n][m] && bd[n][m]!=0;
	}
	static class Node{
		int n,m,cnt;
		Node(int n,int m, int cnt){
			this.n=n; this.m=m;
			this.cnt=cnt;
		}
	}
}
