package homework;

import java.util.*;
import java.io.*;

public class Solution_d5_1247_최적경로_서울_06_강상우 {
	static BufferedReader br = null;
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	static ArrayList<Pair> v;
	static boolean[] visit;
	static int N;
	static int sx,sy,ex,ey;
	static int Min;
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			sb.append("#").append(t).append(" ");
			input();
			solve(sx,sy,0,0);
			sb.append(Min).append("\n");
		}
		System.out.println(sb);
	}
	static void solve(int n, int m, int cnt, int sum) {
		if(cnt == N) {
			int dist = Math.abs(n-ex)+Math.abs(m-ey);
			Min = Math.min(Min, sum+dist);
			return;
		}
		for(int i=0; i<v.size(); i++) {
			if(!visit[i]) {
				int nx = v.get(i).x;
				int ny = v.get(i).y;
				int dist = Math.abs(n-nx)+ Math.abs(m-ny);
				if(sum + dist <= Min) { 
					visit[i]=true;
					solve(nx,ny,cnt+1,sum+dist);					
					visit[i]=false;
				}
			}
		}
	}
	static void input() throws Exception {
		Min = Integer.MAX_VALUE;
		v = new ArrayList<>();
		N = Integer.parseInt(br.readLine());
		visit = new boolean[N];
		st = new StringTokenizer(br.readLine());
		sx = Integer.parseInt(st.nextToken());
		sy = Integer.parseInt(st.nextToken());
		ex = Integer.parseInt(st.nextToken());
		ey = Integer.parseInt(st.nextToken());
		for(int n=0; n<N; n++) {
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			v.add(new Pair(x,y));
		}
	}
	static class Pair{
		int x; int y;
		Pair(int x, int y){this.x=x; this.y=y;}
	}
}
