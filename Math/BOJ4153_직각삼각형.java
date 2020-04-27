import java.io.*;
import java.util.*;
public class BOJ4153_직각삼각형 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		while(true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(a==0 || b==0 || c==0) break;
			int max = Math.max(a, Math.max(b, c));
			if(max==a) {
				if(Math.pow(a, 2) == Math.pow(b,2)+Math.pow(c, 2)) sb.append("right").append("\n");
				else sb.append("wrong").append("\n");
			}else if(max==b) {
				if(Math.pow(b, 2) == Math.pow(a,2)+Math.pow(c, 2)) sb.append("right").append("\n");
				else sb.append("wrong").append("\n");
			}else {
				if(Math.pow(c, 2) == Math.pow(b,2)+Math.pow(a, 2)) sb.append("right").append("\n");
				else sb.append("wrong").append("\n");
			}
		}
		System.out.println(sb);
	}
}
