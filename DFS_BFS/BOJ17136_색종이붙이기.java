import java.util.*;
import java.io.*;

public class Solution {
	static int[][] bd = new int[11][11];
	static int[] paper = {0,5,5,5,5,5};
	static int ans = Integer.MAX_VALUE;
	static int cnt = 0;
	
	static void solve(int n, int m, int cnt) {
		if(m==10) { //가로가 끝에 도달하면 다음줄로 변
			solve(n+1,0,cnt);
			return;
		}
		if(n==10) { //세로가 끝에 가면, 더이상 볼곳이 없으므로 개수 세기.
			if(ans > cnt) ans = cnt;
			return;
		}
		if(bd[n][m]==0) {
			solve(n,m+1,cnt);
			return;
		}
		
		label:for(int k=5; k>=1; k--) {
			if(paper[k]==0 || n+k > 10 || m+k >10)
				continue;
			for(int i=n; i<n+k; i++) {
				for(int j=m; j<m+k; j++) {
					if(bd[i][j]==0)
						continue label;
				}
			}
			//색종이 덮는 곳을 잠시 0으로 만들
			for(int i=n; i<n+k; i++) {
				for(int j=m; j<m+k; j++) {
					bd[i][j]=0;
				}
			}
			paper[k]-=1;
			solve(n, m+k, cnt+1);
			paper[k]+=1; 
			//재귀가 끝나고나서 bd를 다시 1로 만들기.
			for(int i=n; i<n+k; i++) {
				for(int j=m; j<m+k; j++) {
					bd[i][j]=1;
				}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int n=0, m=0;
		for(int i=0; i<10; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<10; j++) {
				bd[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		solve(0,0,0);
		if(ans == Integer.MAX_VALUE) {
			System.out.println("-1");
		}else {
			System.out.println(ans);
		}
	}
}