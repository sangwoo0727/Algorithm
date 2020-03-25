import java.io.*;
import java.util.*;

public class BOJ10814_나이순정렬 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N;
	static Node[] ar;
	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		ar = new Node[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			String s = st.nextToken();
			ar[i] = new Node(i,a,s);
		}
		Arrays.sort(ar,(Node o1, Node o2)->{
			if(o1.age-o2.age==0) return o1.n-o2.n;
			return o1.age-o2.age;
		});
		for(Node a: ar) {
			sb.append(a.age).append(" ").append(a.name).append("\n");
		}
		System.out.println(sb);
	}
	static class Node{
		int n,age;
		String name;
		Node(int n, int age, String name){
			this.n=n; this.age=age;
			this.name=name;
		}
	}
}
