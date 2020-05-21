public class Kakao_2018BlindRecruitment_5_프렌즈4블록 {
	static int[][] d = {{0,0,1,1},{0,1,0,1}};
	static boolean[][] visit;
	static char[][] bd;
	static int N,M;
	public int solution(int m, int n, String[] board) {
		N = m; M = n;
		bd = new char[N][M];
		for(int i=0; i<N; i++) {
			bd[i] = board[i].toCharArray();
		}
		int answer = 0;
		for(;;) {
			visit = new boolean[N][M];
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					boolean flg = false;
					char base = bd[i][j];
					if(base=='0') continue;
					for(int k=0; k<4; k++) {
						int nn = i+d[0][k];
						int nm = j+d[1][k];
						if(inner(nn,nm,base)) {
							if(k==3) {
								flg = true;
							}
						}else break;
					}
					if(flg) {
						for(int k=0; k<4; k++) {
							int nn = i+d[0][k];
							int nm = j+d[1][k];
							visit[nn][nm]=true;
						}
					}
				}
			}
			int cnt = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(visit[i][j]) cnt++;
				}
			}
			if(cnt==0) break;
			rebuild();
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(bd[i][j]=='0') answer++;
			}
		}
		return answer;
	}
	static void rebuild() {
		for(int j=0; j<M; j++) {
			for(int i=N-1; i>=0; i--) {
				if(visit[i][j]) {
					bd[i][j]='0';
					for(int k=i-1; k>=0; k--) {
						if(!visit[k][j]) {
							visit[k][j] = true;
							bd[i][j] = bd[k][j];
							bd[k][j] = '0';
							break;
						}
					}
				}
			}
		}
	}
	static boolean inner(int n,int m,char c) {
		return 0<=n && n<N && 0<=m && m<M && bd[n][m]==c;
	}
}
