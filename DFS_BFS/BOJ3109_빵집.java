import java.io.*;
import java.util.*;

public class BOJ3109_빵집 {
	static int R,C;
	static boolean[][] check;
	static char[][] bd;
	static int[] dr = {-1,0,1};
	static int[] dc = {1,1,1};
	static int ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		bd = new char[R][C];
		check = new boolean[R][C];
		for(int r=0; r<R; r++) {
			String s = br.readLine();
			for(int c=0; c<C; c++) {
				bd[r][c] = s.charAt(c);
			}
		}
		for(int r=0; r<R; r++) {
			if(dfs(r,0)) ans++;
		}
		System.out.println(ans);
	}
	static boolean dfs(int r, int c) {
		check[r][c] = true;
		if(c==C-1) return true;
		else {
			for(int k=0; k<3; k++) {
				int nr = r+dr[k];
				int nc = c+dc[k];
				boolean flg = false;
				if(inner(nr,nc)) {
					check[nr][nc]=true;
					flg = dfs(nr,nc);
				}
				if(flg) return true;
				else continue;
			}
			return false;
		}
	}
	static boolean inner(int r, int c) {
		return 0<=r && r<R && 0<=c && c<C && !check[r][c] && bd[r][c]=='.';
	}
}