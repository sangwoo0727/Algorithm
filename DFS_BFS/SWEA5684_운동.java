import java.util.*;
import java.io.*;

public class SWEA5684_운동 {
	static StringBuilder sb = new StringBuilder();
	static List<Node>[] v;
	static boolean[] ck;
	static int N,M;
	static int Min;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1; t<=tc; t++) {
			sb.append("#").append(t).append(" ");
			N = sc.nextInt();
			M = sc.nextInt();
			v = new ArrayList[N+1];
			Min = Integer.MAX_VALUE;
			for(int i=1; i<=N; i++){
				v[i] = new ArrayList<>();
            }
			for(int i=1; i<=M; i++) {
				int s = sc.nextInt();
				int e = sc.nextInt();
				int c = sc.nextInt();
				v[s].add(new Node(e,c));
			}
			for(int i=1; i<=N; i++) {
				ck = new boolean[N+1];
				dfs(i,i,0);
			}
			if(Min == Integer.MAX_VALUE) Min = -1;
			sb.append(Min).append("\n");
		}
		System.out.println(sb);
	}
	static void dfs(int start, int end, int sum) {
		if(start==end && ck[end]) {
			Min = Math.min(Min, sum);
			return;
		}
		System.out.println(start);
		if(ck[start]) return;
		ck[start]=true;
		for(int k=0; k<v[start].size(); k++) {
			int m = v[start].get(k).m;
			int c = v[start].get(k).c;
			if(sum+c < Min) {
				dfs(m,end,sum+c);
			}
		}
	}
	static class Node{
		int m,c;
		Node(int m, int c){
			this.m=m; this.c=c;
		}
	}
}