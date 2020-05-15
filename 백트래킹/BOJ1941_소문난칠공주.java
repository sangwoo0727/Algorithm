import java.io.*;

public class BOJ1941_소문난칠공주 {
	static char[][] bd = new char[5][5];
	static int[][] d = {{0,0,-1,1},{1,-1,0,0}};
	static int[] input = new int[7];
	static boolean[][] visit;
	static int ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<5; i++) {
			bd[i] = br.readLine().toCharArray();
		}
		comb(0,0,0);
		System.out.println(ans);
	}
	static void comb(int r, int idx,int cnt) {
		if(r==7) {
			visit = new boolean[5][5];
			int n = 0;
			for(int a: input) {
				if(bd[a/5][a%5]=='S') n++;
			}
			if(n>=4) {
				dfs(input[0]/5,input[0]%5);				
			}
			return;
		}
		if(idx>=25) return;
		char c = bd[idx/5][idx%5];
		input[r] = idx;
		if(r>=4 && cnt==0) return;
		if(c=='S') {
			comb(r+1,idx+1,cnt+1);			
		}else {
			comb(r+1,idx+1,cnt);
		}
		comb(r,idx+1,cnt);
	}
	static void dfs(int n,int m) {
		visit[n][m]=true;
		int cnt = 0;
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(visit[i][j]) cnt++;
			}
		}
		if(cnt==7) {
			ans++;
			return;
		}
		for(int k=0; k<4; k++) {
			int nn = n+d[0][k];
			int nm = m+d[1][k];
			if(inner(nn,nm)&& check(nn,nm)) {
				visit[nn][nm]=true;
				dfs(nn,nm);
			}
		}
	}
	static boolean check(int n,int m) {
		for(int i=0; i<7; i++) {
			int num = input[i];
			if(num/5==n && num%5==m) return true;
		}
		return false;
	}
	static boolean inner(int n,int m) {
		return 0<=n && n<5 && 0<=m && m<5 && !visit[n][m];
	}
}
