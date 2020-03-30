import java.io.*;
import java.util.*;

public class BOJ3088_화분부수기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static boolean[] check = new boolean[1000001];
	static int ans, N;
	
	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		int a=0,b=0,c=0;
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			if(!check[a] && !check[b] && !check[c]) 
				ans++;	
			check[a]=check[b]=check[c]=true;
		}
		System.out.print(ans);
	}
}
