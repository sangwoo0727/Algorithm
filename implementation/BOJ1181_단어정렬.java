
import java.io.*;
import java.util.*;

public class BOJ1181_단어정렬 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static PriorityQueue<Sent> pq = new PriorityQueue<>(); 
	static HashSet<String> set = new HashSet<>();
	
	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			if(set.contains(s)) continue;
			pq.add(new Sent(s.length(),s));
			set.add(s);
		}
		while(!pq.isEmpty()) sb.append(pq.poll().s).append("\n");
		System.out.println(sb);
	}
	static class Sent implements Comparable<Sent>{
		int len;
		String s;
		Sent(int len,String s){
			this.len=len;
			this.s=s;
		}
		@Override
		public int compareTo(Sent s1) {
			int t = this.len-s1.len;
			if(t==0) return this.s.compareTo(s1.s);
			else return t;
		}
	}
}
