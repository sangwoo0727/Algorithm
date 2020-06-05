package algo2;

import java.io.*;
import java.util.*;

public class BOJ17140_이차원배열과연산{
	static HashMap<Integer,Integer> map;
	static PriorityQueue<Pair> pq;
	static int[][] bd = new int[100][100];
	static int r,c,k;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken())-1;
		c = Integer.parseInt(st.nextToken())-1;
		k = Integer.parseInt(st.nextToken());
		for(int i=0; i<3; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				bd[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int t = 0;
		for(;;) {
			if(t>100) break;
			if(bd[r][c]==k) break;
			t++;
			int maxn = 0, maxm = 0;
			for(int i=0; i<100; i++) {
				for(int j=0; j<100; j++) {
					if(bd[i][j]!=0) {
						maxn = Math.max(maxn, i);
						maxm = Math.max(maxm, j);
					}
				}
			}
			if(maxn>=maxm) {
				for(int i=0; i<100; i++) {
					map = new HashMap<>();
					pq = new PriorityQueue<>();
					for(int j=0; j<100; j++) {
						if(bd[i][j]==0) continue;
						if(map.containsKey(bd[i][j])) map.put(bd[i][j], map.get(bd[i][j])+1);
						else map.put(bd[i][j], 1);
					}
					for(int k: map.keySet()) {
						pq.add(new Pair(k,map.get(k)));
					}
					int j=0;
					while(!pq.isEmpty()) {
						int n = pq.peek().n;
						int cnt = pq.poll().cnt;
						if(j>=100) break;
						bd[i][j++] = n;
						if(j>=100) break;
						bd[i][j++] = cnt;
					}
					for(int n=j; n<100; n++) {
						bd[i][n] = 0;
					}
				}
			}
			else {
				for(int j=0; j<100; j++) {
					map = new HashMap<>();
					pq = new PriorityQueue<>();
					for(int i=0; i<100; i++) {
						if(bd[i][j]==0) continue;
						if(map.containsKey(bd[i][j])) map.put(bd[i][j], map.get(bd[i][j])+1);
						else map.put(bd[i][j], 1);
					}
					for(int k: map.keySet()) {
						pq.add(new Pair(k,map.get(k)));
					}
					int i=0;
					while(!pq.isEmpty()) {
						int n = pq.peek().n;
						int cnt = pq.poll().cnt;
						if(i>=100) break;
						bd[i++][j] = n;
						if(i>=100) break;
						bd[i++][j] = cnt;
					}
					for(int n=i; n<100; n++) {
						bd[n][j] = 0;
					}
				}
			}
		}
		System.out.println(t>100? -1 : t);
	}
	static class Pair implements Comparable<Pair>{
		int n, cnt;
		Pair(int n,int cnt){
			this.n=n; this.cnt=cnt;
		}
		@Override
		public int compareTo(Pair o) {
			if(this.cnt==o.cnt) return this.n-o.n;
			return this.cnt-o.cnt;
		}
	}
}