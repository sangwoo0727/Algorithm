import java.io.*;
import java.util.*;

public class JUNGOL1681_해밀턴순환회로 {
	static int[][] bd;
	static boolean[] visit;
	static int N, ans=Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		bd = new int[N][N];
		visit = new boolean[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				bd[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int j=0; j<N; j++) {
			if(bd[0][j]!=0) {
				visit[j]=true;
				comb(1,j,bd[0][j]);
				visit[j]=false;
			}
		}
		System.out.println(ans);
	}
	static void comb(int r,int idx, int sum) {
		System.out.println(sum);
		if(r==N) {
			ans = Math.min(ans, sum);
			for(int i=0; i<N; i++) {
				System.out.println(visit[i]);
			}
			return;
		}
		if(r==N-1) {
				if(bd[idx][0]!=0 && sum+bd[idx][0]<ans) {
					comb(r+1,0,sum+bd[idx][0]);
				}
			
		}
		for(int i=1; i<N; i++) {
			if(!visit[i] && bd[idx][i]!=0 && sum+bd[idx][i]<ans) {
				visit[i]= true;
				comb(r+1,i,sum+bd[idx][i]);
				visit[i]=false;
			}
		}
	}
}
