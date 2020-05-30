import java.io.*;
import java.util.*;

public class BOJ2931_가스관 {
	static boolean[][] tun = {
			{true,true,true,true},
			{false,true,true,false},
			{true,true,false,false},
			{true,false,false,true},
			{false,false,true,true},
			{true,false,true,false},
			{false,true,false,true}
	};
	static int[][] d = {{-1,0,1,0},{0,1,0,-1}};
	static char[][] bd;
	static boolean[][] visit;
	static boolean[] dir = new boolean[4];
	static int N,M,sn,sm,en,em;
	static int an,am;
	static char ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		bd = new char[N][M];
		visit = new boolean[N][M];
		for(int i=0; i<N; i++) {
			bd[i] = br.readLine().toCharArray();
			for(int j=0; j<M; j++) {
				if(bd[i][j]=='+') bd[i][j]='0';
				else if(bd[i][j]=='|') bd[i][j]='5';
				else if(bd[i][j]=='-') bd[i][j]='6';
				else if(bd[i][j]=='M') {
					sn = i; sm = j;
				}else if(bd[i][j]=='Z') {
					en = i; em = j;
				}
			}
		}
		for(int k=0; k<4; k++) {
			int nn = sn+d[0][k];
			int nm = sm+d[1][k];
			if(inner(nn,nm) && bd[nn][nm]>='0' && bd[nn][nm]<='6') {
				visit[sn][sm]=true;
				sn = nn; sm = nm;
				break;
			}
		}
		bfs(sn,sm);
		for(int i=0; i<7; i++) {
			boolean flg = true;
			for(int j=0; j<4; j++) {
				if(dir[j]==tun[i][j]) continue;
				else {
					flg = false;
					break;
				}
			}
			if(flg) {
				if(i==0) ans = '+';
				else if(i==1) ans = '1';
				else if(i==2) ans = '2';
				else if(i==3) ans = '3';
				else if(i==4) ans = '4';
				else if(i==5) ans = '|';
				else ans = '-';
				break;
			}
		}
		System.out.println(an+" "+am+" "+ans);
	}
	static void bfs(int s,int e) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(s,e));
		while(!q.isEmpty()) {
			int n = q.peek().n;
			int m = q.poll().m;
			int tnum = bd[n][m] -'0';
			visit[n][m] = true;
			for(int k=0; k<4; k++) {
				if(tun[tnum][k]) {
					int nn = n+d[0][k];
					int nm = m+d[1][k];
					if(inner(nn,nm)&& !visit[nn][nm] && bd[nn][nm]=='.') {
						an = nn+1;
						am = nm+1;
						solve(nn,nm);
						return;
					}
					if(inner(nn,nm) && !visit[nn][nm] && bd[nn][nm]!='.') {
						visit[nn][nm] = true;
						q.offer(new Pair(nn,nm));
					}
				}
			}
		}
	}
	static void solve(int n,int m) {
		for(int k=0; k<4; k++) {
			int nn = n+d[0][k];
			int nm = m+d[1][k];
			if(inner(nn,nm)) {
				if(bd[nn][nm]=='.' || bd[nn][nm]=='M' || bd[nn][nm]=='Z') {
					dir[k] = false;
				}else {
					if(k==0 && tun[bd[nn][nm]-'0'][2]) dir[k] = true;
					else if(k==1 && tun[bd[nn][nm]-'0'][3]) dir[k] = true;
					else if(k==2 && tun[bd[nn][nm]-'0'][0]) dir[k] = true;
					else if(k==3 && tun[bd[nn][nm]-'0'][1]) dir[k] = true;
					else dir[k] = false;
				}
			}else {
				dir[k] = false;
			}
		}
	}
	static boolean inner(int n,int m) {
		return 0<=n && n<N && 0<=m && m<M;
	}
	static class Pair{
		int n,m;
		Pair(int n,int m){
			this.n=n; this.m=m;
		}
	}
}
