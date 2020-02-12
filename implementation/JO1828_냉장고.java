package homework;

import java.io.*;
import java.util.*;

public class JO1828_냉장고 {
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	static ArrayList<Pair> l = new ArrayList<>();
	static int cnt=0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
			l.add(new Pair(a,b));
		}
		Collections.sort(l);
		for(int n=0; n<N; n++) {
			int p = l.get(n).x;
			if(pq.isEmpty()) {
				pq.add(l.get(n).y);
			}else {
				if(p <= pq.peek()) {
					pq.add(l.get(n).y);
				}else {
					while(!pq.isEmpty())
						pq.poll();
					cnt++;
					pq.add(l.get(n).y);
				}
			}
			
		}
		boolean flg=false;
		while(!pq.isEmpty()) {
			flg = true;
			pq.poll();
		}
		if(flg) cnt++;
		System.out.println(cnt);
	}
	
	static class Pair implements Comparable<Pair>{
		int x,y;
		Pair(int x, int y){this.x=x; this.y=y;}
		@Override
		public int compareTo(Pair o) {
			return x-o.x;
		}
	}
}
