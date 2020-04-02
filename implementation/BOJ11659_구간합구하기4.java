import java.io.*;
import java.util.*;

public class BOJ11659_구간합구하기4 {
	static int[] arr;
	static int N,M;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int n = Integer.parseInt(st.nextToken());
			if(i==0) arr[i] = n;
			else arr[i] = arr[i-1]+n;
		}
		int a=0,b=0;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			int sum = 0;
			if(a==1) sum = arr[b-1];
			else {
				sum = arr[b-1]-arr[a-2];
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}
