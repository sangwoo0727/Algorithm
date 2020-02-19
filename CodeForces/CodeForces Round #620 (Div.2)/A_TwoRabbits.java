import java.io.*;
import java.util.*;
 
import java.io.*;
import java.util.*;
 
public class A_TwoRabbits {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		while(tc-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append((y-x)%(a+b) == 0 ? (y-x)/(a+b) : -1).append("\n");
		}
		System.out.println(sb);
	}
}