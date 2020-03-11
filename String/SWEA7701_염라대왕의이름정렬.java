import java.util.*;
import java.io.*;


public class SWEA7701_염라대왕의이름정렬 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static PriorityQueue<String> pq;
	static HashSet<String> set;
	static int N;
	
    public static void main(String[] args) throws IOException {
    	int tc = Integer.parseInt(br.readLine());
    	for(int t=1; t<=tc; t++) {
    		sb.append("#").append(t).append("\n");
    		pq = new PriorityQueue<>(new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					int t = o1.length()-o2.length();
					if(t==0) return o1.compareTo(o2);
					else return t;
				}
    		});
    		set = new HashSet<>();
    		N = Integer.parseInt(br.readLine());
    		while(N-->0) {
    			String s = br.readLine();
    			if(!set.contains(s)) {
    				set.add(s);
    				pq.offer(s);
    			}
    		}
    		while(!pq.isEmpty()) sb.append(pq.poll()).append("\n");
    	}
    	System.out.println(sb);
    }
}