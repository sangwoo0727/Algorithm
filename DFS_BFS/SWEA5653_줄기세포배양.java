import java.io.*;
import java.util.*;


public class SWEA5653_줄기세포배양 {
	static int N,M,K;
	static Queue<Node> q;
	static int[][] bd;
	static boolean[][] visit;
	static int[][] d = {{0,0,-1,1},{1,-1,0,0}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			sb.append("#").append(t).append(" ");
			q = new LinkedList<Node>();
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			int p = (K>>1)+1;
			bd = new int[N+p*2][M+p*2];
			visit = new boolean[N+p*2][M+p*2];
			for(int i=p; i<N+p; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=p; j<M+p; j++) {
					bd[i][j] = Integer.parseInt(st.nextToken());
					if(bd[i][j]!=0) {
						q.offer(new Node(i,j,0,bd[i][j],false));
					}
				}
			}
			sb.append(bfs()).append("\n");
		}
		System.out.println(sb);
	}
	static int bfs() {
		for(int t=0; t<K; t++) {
			HashMap<String,Integer> map = new HashMap<>();
			int size = q.size();
			for(int i=0; i<size; i++) {
				int n = q.peek().n;
				int m = q.peek().m;
				int l = q.peek().l;
				int life = q.peek().life;
				boolean act = q.poll().act;
				visit[n][m]=true;
				if(act) {
					if(l==life) {
						for(int k=0; k<4; k++) {
							int nn = n+d[0][k];
							int nm = m+d[1][k];
							if(visit[nn][nm]) continue;
							String tmp = nn+" "+nm;
							if(!map.containsKey(tmp)){
								map.put(tmp, life);
							}else if(map.get(tmp)<life) {
								map.put(tmp,life);
							}
						}						
					}
					if(l-1!=0) q.offer(new Node(n,m,l-1,life,act)); 
				}else {
					if(l+1!=life) q.offer(new Node(n,m,l+1,life,act));
					else q.offer(new Node(n,m,l+1,life,!act));
				}
			}
			for(String s: map.keySet()) {
				StringTokenizer stmp = new StringTokenizer(s);
				int n = Integer.parseInt(stmp.nextToken());
				int m = Integer.parseInt(stmp.nextToken());
				bd[n][m] = map.get(s);
				visit[n][m]=true;
				q.offer(new Node(n,m,0,bd[n][m],false));
			}
		}
		return q.size();
	}
	static class Node{
		int n,m,l,life;
		boolean act;
		Node(int n,int m, int l, int life, boolean act){
			this.n=n; this.m=m;
			this.l=l; this.life=life;
			this.act=act;
		}
	}
}