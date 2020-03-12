import java.util.*;
import java.io.*;


public class SWEA7701_염라대왕의이름정렬 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static TreeSet<String> ts;
	static int N;
	
    public static void main(String[] args) throws IOException {
    	int tc = Integer.parseInt(br.readLine());
    	for(int t=1; t<=tc; t++) {
    		sb.append("#").append(t).append("\n");
    		N = Integer.parseInt(br.readLine());
    		ts = new TreeSet<>(new Comparator<String>() {
				public int compare(String o1, String o2) {
					int t = o1.length()-o2.length();
					if(t==0) return o1.compareTo(o2);
					else return t;
				}
			});
    		for(int i=0; i<N; i++) {
    			ts.add(br.readLine());
    		}
    		while(!ts.isEmpty()) sb.append(ts.pollFirst()).append("\n");
    	}
    	System.out.println(sb);
    }
}