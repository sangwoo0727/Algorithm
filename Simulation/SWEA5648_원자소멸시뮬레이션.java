import java.io.*;
import java.util.*;

public class SWEA5648_원자소멸시뮬레이션 {
	static int N, ans;
	static Node[] list;
	static int[][] bd = new int[4001][4001];
	static int[][] dir = {{1,-1,0,0},{0,0,-1,1}};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			sb.append("#").append(t).append(" ");
			N = Integer.parseInt(br.readLine());
			list = new Node[N];
			ans = 0;
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				int m = (Integer.parseInt(st.nextToken())+1000)*2;
				int n = (Integer.parseInt(st.nextToken())+1000)*2;
				int d = Integer.parseInt(st.nextToken());
				int k = Integer.parseInt(st.nextToken());
				list[i] = new Node(n,m,k,d,false);
				bd[n][m] = 0;
			}
			for(int time=0; time<=4000; time++) {
				boolean tflg = false;
				for(int i=0; i<N; i++) {
					Node node = list[i];
					bd[node.n][node.m] = 0;
				}
				for(int i=0; i<N; i++) {
					Node node = list[i];
					if(node.flg) continue;
					tflg = true;
					int nn = node.n+dir[0][node.d];
					int nm = node.m+dir[1][node.d];
					if(!inner(nn,nm)) {
						list[i].flg=true;
						continue;
					}
					if(bd[nn][nm]>0) {
						int pidx = bd[nn][nm];
						if(!list[pidx-1].flg) {
							ans += list[pidx-1].k;
							list[pidx-1].flg=true;
						}
						ans += node.k;
						list[i].flg=true;
					}else {
						bd[nn][nm] = i+1;
						list[i].n = nn;
						list[i].m = nm;
					}
				}
				if(!tflg) break;
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}
	static boolean inner(int n,int m) {
		return 0<=n && n<=4000 && 0<=m && m<=4000;
	}
	static class Node{
		int n,m,k,d;
		boolean flg;
		Node(int n,int m,int k, int d,boolean flg){
			this.n=n; this.m=m;
			this.k=k; this.d=d;
			this.flg=flg;
		}
	}
}
