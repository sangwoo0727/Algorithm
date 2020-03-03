
import java.io.*;
import java.util.*;

public class SWEA1907_모래성쌓기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int H,W;
	static char[][] bd;
	static int ans = 0;
	static int dc[] = {0,-1,-1,-1,0,1,1,1};
	static int dr[] = {-1,-1,0,1,1,1,0,-1};
	
	public static void main(String[] args) throws Exception{
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			ans = 0;
			bd = new char[H][W];
			for(int h=0; h<H; h++) {
				bd[h] = br.readLine().toCharArray();
			}
			bfs();
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}
	static void bfs() {
		Queue<Node> q = new LinkedList<>();
		for(int h=0; h<H; h++) {
			for(int w=0; w<W; w++) {
				if(bd[h][w]=='.') {
					q.offer(new Node(h,w));
				}
			}
		}
		int lev = -1;
		while(!q.isEmpty()) {
			lev++;
			int size = q.size();
			for(int s=0; s<size; s++) {
				int n = q.peek().h;
				int m = q.poll().w;
				for(int k=0; k<8; k++) {
					int nn = n+dc[k];
					int nm = m+dr[k];
					if(inner(nn,nm)) {
						bd[nn][nm] -= 1;	
						if(bd[nn][nm]=='0') {
							q.offer(new Node(nn,nm));
						}
					}
				}
			}	
		}
		if(lev == -1) lev = 0;
		ans = lev;
	}
	static boolean inner(int n, int m) {
		return n>=0 && n<H && m>=0 && m<W && bd[n][m]!='.';
	}
	static class Node {
		int h,w;
		public Node(int h, int w) {
			this.h = h; this.w = w;
		}
	}
}
