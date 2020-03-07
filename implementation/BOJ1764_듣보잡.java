
import java.io.*;
import java.util.*;

public class BOJ1764_듣보잡 {
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static HashSet<String> set = new HashSet<>();
	static PriorityQueue<String> pq = new PriorityQueue<String>(new Comparator<String>() {
		@Override
		public int compare(String o1, String o2) {
			return o1.compareTo(o2);
		}
	});
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		for(int i=0; i<n; i++) {
			set.add(br.readLine());
		}
		for(int i=0; i<m; i++) {
			String s = br.readLine();
			if(set.contains(s)) {
				pq.offer(s);
			}
		}
		System.out.println(pq.size());
		while(!pq.isEmpty()) sb.append(pq.poll()).append("\n");
		System.out.println(sb);
	}
}
