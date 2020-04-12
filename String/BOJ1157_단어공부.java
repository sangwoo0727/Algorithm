import java.io.*;
import java.util.*;

public class BOJ1157_단어공부 {
	static HashMap<Character, Integer> map = new HashMap<>();
	static PriorityQueue<Node> pq = new PriorityQueue<>(
			(Node o1, Node o2)->{
				return -Integer.compare(o1.cnt,o2.cnt);
			}
	);
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(c > 'Z') {
				c = (char)(c-32);
			}
			if(map.containsKey(c)) {
				map.put(c, map.get(c)+1);
			}else {
				map.put(c, 1);
			}
		}
		for(char c:map.keySet()) {
			pq.offer(new Node(c,map.get(c)));
		}
		char c = pq.peek().c;
		int cnt = pq.poll().cnt;
		if(!pq.isEmpty() && cnt==pq.poll().cnt) {
			System.out.println("?");
		}else {
			System.out.println(c);
		}
		
	}
	static class Node{
		char c;
		int cnt;
		Node(char c, int cnt){
			this.c=c;
			this.cnt=cnt;
		}
	}
}
