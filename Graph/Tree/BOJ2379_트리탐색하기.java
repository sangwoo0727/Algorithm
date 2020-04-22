import java.io.*;
import java.util.*;
public class BOJ2379_트리탐색하기 {
	static Deque<Integer> st;
	static List<Integer> list1;
	static List<Integer> list2;
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			st = new LinkedList<>();
			String s1 = br.readLine();
			String s2 = br.readLine();
			list1 = new ArrayList<>();
			for(int i=0; i<s1.length(); i++) {
				char c = s1.charAt(i);
				if(c=='0') st.add(i);
				else list1.add(i-st.pollLast());
			}
			st = new LinkedList<>();
			list2 = new ArrayList<>();
			for(int i=0; i<s2.length(); i++) {
				char c = s2.charAt(i);
				if(c=='0') st.add(i);
				else list2.add(i-st.pollLast());
			}
			Collections.sort(list1);
			Collections.sort(list2);
			if(list1.equals(list2)) {
				sb.append(1).append("\n");
			}else sb.append(0).append("\n");
		}
		System.out.println(sb);
	}
}
