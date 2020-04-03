import java.io.*;
import java.util.*;

public class BOJ1406_에디터 {
	static char p,m;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		String s = br.readLine();
		List<Character> list = new LinkedList<>(); 
		ListIterator<Character> it = list.listIterator(list.size());
		for(int i=0; i<s.length(); i++) {
			it.add(s.charAt(i));
		}
		int m = Integer.parseInt(br.readLine());
		
		while(m-->0) {
			st = new StringTokenizer(br.readLine());
			p = st.nextToken().charAt(0);
			if(p=='L') {
				if(it.hasPrevious()) {
					it.previous();
				}
			}else if(p=='D') {
				if(it.hasNext()) {
					it.next();
				}
			}else if(p=='B') {
				if(it.hasPrevious()) {
					it.previous();
					it.remove();
				}
			}else {
				char c = st.nextToken().charAt(0);
				it.add(c);
			}
		}
		for(char c:list) {
			sb.append(c);
		}
		System.out.println(sb);
	}
}
