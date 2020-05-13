import java.util.*;
import java.io.*;

public class BOJ1194_달이차오른다가자 {
	static char[][] bd;
	static int[][][] visit;
	static int[][] d = {{-1,1,0,0},{0,0,-1,1}};
	static int N,M,sn,sm,ans = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		bd = new char[N][M];
		visit = new int[(1<<6)][N][M];
		for(int i=0; i<N; i++) {
			bd[i] = br.readLine().toCharArray();
			for(int j=0; j<M; j++) {
				if(bd[i][j]=='0') {
					sn = i; sm = j;
				}
			}
		}
		bfs();
		System.out.println(ans==Integer.MAX_VALUE? -1 : ans-1);
	}
	static void bfs() {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(sn,sm,1,0));
		while(!q.isEmpty()) {
			int n = q.peek().n;
			int m = q.peek().m;
			int cnt = q.peek().cnt;
			int bit = q.poll().bit;
			visit[bit][n][m] = cnt;
			for(int k=0; k<4; k++) {
				int nn = n+d[0][k];
				int nm = m+d[1][k];
				if(inner(nn,nm)) {
					if(bd[nn][nm]>='a' && bd[nn][nm]<='f') {
						int idx = bd[nn][nm]-'a';
						if(visit[bit|(1<<idx)][nn][nm]==0 || visit[bit|(1<<idx)][nn][nm] > cnt+1) {
							visit[bit|(1<<idx)][nn][nm] = cnt+1;
							q.offer(new Node(nn,nm,cnt+1,bit|(1<<idx)));
						}
					}else if(bd[nn][nm]>='A' && bd[nn][nm]<='F') {
						int idx = bd[nn][nm]-'A';
						if((bit&(1<<idx))>0) {
							if(visit[bit][nn][nm]==0 || visit[bit][nn][nm]>cnt+1) {
								visit[bit][nn][nm]=cnt+1;
								q.offer(new Node(nn,nm,cnt+1,bit));
							}
						}
					}else if(bd[nn][nm]=='.'|| bd[nn][nm]=='0') {
						if(visit[bit][nn][nm]==0 || visit[bit][nn][nm]>cnt+1) {
							visit[bit][nn][nm] = cnt+1;
							q.offer(new Node(nn,nm,cnt+1,bit));
						}
					}else if(bd[nn][nm]=='1') {
						ans = Math.min(ans, cnt+1);
						return;
					}
				}
			}
		}
	}
	static boolean inner(int n, int m) {
		return 0<=n && n<N && 0<=m && m<M && bd[n][m]!='#';
	}
	static class Pair{
		int n,m;
		Pair(int n,int m){this.n=n; this.m=m;}
	}
	static class Node{
		int n,m,cnt,bit;
		Node(int n,int m,int cnt,int bit){
			this.n=n; this.m=m; this.cnt=cnt; this.bit=bit;
		}
	}
}
