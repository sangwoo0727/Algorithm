import java.io.*;
import java.util.*;

public class BOJ18809_Gaaaaaaaaaarden {
	static int N,M,G,R;
	static int[][] bd;
	static Vis[][] ck;
	static List<Pair> list = new ArrayList<>();
	static Pair[] input;
	static int[] arr;
	static int[][] dir = {{0,0,-1,1},{1,-1,0,0}};
	static int Max = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		bd = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				bd[i][j] = Integer.parseInt(st.nextToken());
				if(bd[i][j]==2) list.add(new Pair(i,j,0));
			}
		}
		arr = new int[list.size()];
		input = new Pair[G+R];
		for(int i=0; i<G; i++) arr[i] = 1;
		for(int i=G; i<G+R; i++) arr[i] = 2;
		Arrays.sort(arr);
		int t = 0;
		do {
			int tmp = 0;
			t++;
			for(int i=0; i<arr.length; i++) {
				if(arr[i]==0) continue;
				int n = list.get(i).n;
				int m = list.get(i).m;
				if(arr[i]==1) { //G
					input[tmp++]=new Pair(n,m,1);
				}else if(arr[i]==2) {//R
					input[tmp++]=new Pair(n,m,2);
				}
			}
			bfs();
		}while(next_permutation());
		System.out.println(Max);
	}
	static void bfs() {
		Queue<Node> q = new LinkedList<>();
		ck = new Vis[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				ck[i][j] = new Vis(0,0);
			}
		}
		for(int i=0; i<input.length; i++) {
			int n = input[i].n;
			int m = input[i].m;
			int c = input[i].c;
			q.offer(new Node(n,m,c,0));
			ck[n][m] = new Vis(c,0);
		}
		int cnt = 0;
		while(!q.isEmpty()) {
			int n = q.peek().n;
			int m = q.peek().m;
			int c = q.peek().c;
			int lev = q.poll().lev;
			if(ck[n][m].c==3) continue;
			ck[n][m] = new Vis(c,lev);
			for(int k=0; k<4; k++) {
				int nn = n+dir[0][k];
				int nm = m+dir[1][k];
				if(inner(nn,nm)) {
					if(ck[nn][nm].c==3) continue;
					else if(ck[nn][nm].c==0) {
						q.offer(new Node(nn,nm,c,lev+1));
						ck[nn][nm] = new Vis(c,lev+1);
					}else {
						if(ck[nn][nm].lev==lev+1 && ck[nn][nm].c != c) {
							ck[nn][nm] = new Vis(3,-1);
							cnt++;
						}else continue;
					}
				}
			}
		}
		Max = Math.max(Max, cnt);
	}
	static boolean inner(int n,int m) {
		return 0<=n&&n<N&&0<=m&&m<M&&bd[n][m]!=0;
	}
	static boolean next_permutation() {
		int i = arr.length-1;
		while(i>0 && arr[i-1]>=arr[i]) --i;
		if(i==0) return false;
		int j = arr.length-1;
		while(arr[i-1]>=arr[j]) --j;
		int tmp = arr[i-1];
		arr[i-1] = arr[j];
		arr[j]=tmp;
		int k= arr.length-1;
		while(i<k) {
			tmp = arr[i];
			arr[i] = arr[k];
			arr[k] = tmp;
			++i; --k;
		}
		return true;
	}
	static class Vis{
		int c,lev;
		Vis(int c, int lev) {this.c=c;this.lev=lev;}
	}
	static class Node{
		int n,m,c,lev;
		Node(int n, int m, int c, int lev) {
			this.n=n; this.m=m; this.c=c; this.lev=lev;
		}
	}
	static class Pair{
		int n,m,c;
		Pair(int n,int m,int c) {this.n=n;this.m=m;this.c=c;}
	}
}
