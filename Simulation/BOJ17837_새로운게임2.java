import java.io.*;
import java.util.*;

public class BOJ17837_새로운게임2 {
	static int N,K;
	static int[][] bd;
	static int[][] d = {{0,0,-1,1},{1,-1,0,0}};
	static Node[] node;
	static Deque<Integer>[][] move;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		bd = new int[N][N];
		move = new Deque[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				bd[i][j] = Integer.parseInt(st.nextToken());
				move[i][j] = new ArrayDeque<>();
			}
		}
		node = new Node[K];
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken())-1;
			int m = Integer.parseInt(st.nextToken())-1;
			int dir = Integer.parseInt(st.nextToken())-1;
			node[i] = new Node(n,m,dir);
			move[n][m].addLast(i);
		}
		int ans = 1;
		label:for(;ans<=1000; ans++) {
			for(int i=0; i<K; i++) {
				int n = node[i].n;
				int m = node[i].m;
				int dir = node[i].dir;
				List<Integer> list = new ArrayList<>();
				for(;;) {
					if(move[n][m].peekFirst()==i) break;
					int num = move[n][m].pollFirst();
					list.add(num);
				}
				int nn = n + d[0][dir];
				int nm = m + d[1][dir];
				if(inner(nn,nm)) {
					if(bd[nn][nm]==0) {
						while(!move[n][m].isEmpty()) {
							int tnum = move[n][m].pollFirst();
							move[nn][nm].addLast(tnum);
							node[tnum] = new Node(nn,nm,node[tnum].dir);
						}
					}else if(bd[nn][nm]==1) {
						while(!move[n][m].isEmpty()) {
							int tnum = move[n][m].pollLast();
							move[nn][nm].addLast(tnum);
							node[tnum] = new Node(nn,nm,node[tnum].dir);
						}
					}else {
						dir = changePos(dir);
						int tn = n+d[0][dir];
						int tm = m+d[1][dir];
						node[i] = new Node(n,m,dir);
						if(inner(tn,tm)) {
							if(bd[tn][tm]==0) {
								while(!move[n][m].isEmpty()) {
									int tnum = move[n][m].pollFirst();
									move[tn][tm].addLast(tnum);
									node[tnum] = new Node(tn,tm,node[tnum].dir);
								}
							}else if(bd[tn][tm]==1) {
								while(!move[n][m].isEmpty()) {
									int tnum = move[n][m].pollLast();
									move[tn][tm].addLast(tnum);
									node[tnum] = new Node(tn,tm,node[tnum].dir);
								}
							}
						}
					}
				}else {
					dir = changePos(dir);
					int tn = n+d[0][dir];
					int tm = m+d[1][dir];
					node[i] = new Node(n,m,dir);
					if(inner(tn,tm)) {
						if(bd[tn][tm]==0) {
							while(!move[n][m].isEmpty()) {
								int tnum = move[n][m].pollFirst();
								move[tn][tm].addLast(tnum);
								node[tnum] = new Node(tn,tm,node[tnum].dir);
							}
						}else if(bd[tn][tm]==1) {
							while(!move[n][m].isEmpty()) {
								int tnum = move[n][m].pollLast();
								move[tn][tm].addLast(tnum);
								node[tnum] = new Node(tn,tm,node[tnum].dir);
							}
						}
					}
				}
				for(int s=list.size()-1; s>=0; s--) {
					move[n][m].addFirst(list.get(s));					
				}
				for(int r=0; r<N; r++) {
					for(int c=0; c<N; c++) {
						if(move[r][c].size()>=4) {
							break label;
						}
					}
				}
			}
		}
		if(ans>=1000) ans = -1;
		System.out.println(ans);
	}
	static int changePos(int dir) {
		if(dir==0) return 1;
		else if(dir==1) return 0;
		else if(dir==2) return 3;
		else return 2;
	}
	static boolean inner(int n,int m) {
		return 0<=n && n<N && 0<=m && m<N;
	}
	static class Node{
		int n,m,dir;
		Node(int n,int m,int dir){
			this.n=n; this.m=m; this.dir=dir;
		}
	}
}
