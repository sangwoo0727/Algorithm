import java.io.*;
import java.util.*;

public class SWEA5650_핀볼게임 {
	static int N, ans , sn,sm;
	static Pair[][] warm = new Pair[6][2];
	static boolean[] wflg;
	static int[][] bd;
	static int[][] d = {{-1,0,1,0},{0,1,0,-1}};
	static int[][] block = {
			{2,3,1,0},
			{1,3,0,2},
			{3,2,0,1},
			{2,0,3,1},
			{2,3,0,1}
	};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int tc = Integer.parseInt(br.readLine().trim());
		for(int t=1; t<=tc; t++) {
			sb.append("#").append(t).append(" ");
			N = Integer.parseInt(br.readLine().trim());
			ans = 0;
			bd = new int[N][N];
			warm = new Pair[6][2];
			wflg = new boolean[6];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					bd[i][j] = Integer.parseInt(st.nextToken());
					if(bd[i][j]>=6 && bd[i][j]<=10) {
						int w = bd[i][j]-6;
						if(wflg[w]) warm[w][1] = new Pair(i,j);
						else {
							wflg[w] = true;
							warm[w][0] = new Pair(i,j);
						}
					}
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(bd[i][j]==0) {
						for(int k=0; k<4; k++) {
							sn = i; sm = j;
							solve(i,j,k,0);								
						}
					}
				}
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}
	static void solve(int n,int m,int k, int cnt) {
		for(;;) {
			int nn = n+d[0][k];
			int nm = m+d[1][k];
			if(!inner(nn,nm)) { //벽만나기
				ans = Math.max(ans, cnt*2+1);
				break;
			}
			else {
				if(bd[nn][nm]==-1 || (nn==sn && nm==sm)) { //탈출
					ans = Math.max(ans, cnt);
					break;
				}
				else if(bd[nn][nm]==0) {
					n = nn; m = nm; 
				}
				else if(bd[nn][nm]>=1 && bd[nn][nm]<=5) { // 벽돌만나기
					int bl = bd[nn][nm]-1;
					if(bl==4) {
						ans = Math.max(ans, cnt*2+1);
						break;
					}
					int nk = block[bl][k];
					n = nn; m = nm; k=nk; cnt+=1;
				}
				else if(bd[nn][nm]>=6 && bd[nn][nm]<=10) { //웜홀
					int w = bd[nn][nm]-6;
					Pair wa = warm[w][0];
					if(nn==wa.n && nm==wa.m) {
						n = warm[w][1].n;
						m = warm[w][1].m;
					}else {
						n = wa.n; m = wa.m;
					}
				}
			}
		}
	}
	static boolean inner(int n,int m) {
		return 0<=n && n<N && 0<=m && m<N;
	}
	static class Pair{
		int n,m;
		Pair(int n,int m){
			this.n=n; this.m=m;
		}
	}
}
