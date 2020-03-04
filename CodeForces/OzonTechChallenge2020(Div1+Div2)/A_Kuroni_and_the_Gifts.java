
import java.io.*;
import java.util.*;
 
public class A_Kuroni_and_the_Gifts {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int[] a;
	static int[] b;
	
	public static void main(String[] args) throws Exception {
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			int n = Integer.parseInt(br.readLine());
			a = new int[n];
			b = new int[n];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				b[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(a);
			Arrays.sort(b);
			for(int i=0; i<n; i++) {
				sb.append(a[i]).append(" ");	
			}
			sb.append("\n");
			for(int i=0; i<n; i++) {
				sb.append(b[i]).append(" ");	
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
