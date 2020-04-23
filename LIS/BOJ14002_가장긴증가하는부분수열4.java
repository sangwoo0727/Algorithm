import java.io.*;
import java.util.*;

public class BOJ14002_가장긴증가하는부분수열4 {
	static int N;
	static int[] arr;
	static int[] path;
	static int[] lis;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		path = new int[N];
		lis = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int idx = 0;
		int cnt = 1;
		for(int i=0; i<N; i++) {
			lis[i]=1;
			path[i]=-1;
			for(int j=0; j<i; j++) {
				if(arr[i]>arr[j] && lis[i]<lis[j]+1) {
					lis[i] = lis[j]+1;
					path[i] = j;
					if(cnt<lis[i]) {
						cnt = lis[i];
						idx = i;
					}
				}
			}
		}
		
		sb.append(cnt).append("\n");
		print(idx,path[idx]);
		System.out.println(sb);
	}
	static void print(int n, int m) {
		if(m!=-1) print(m,path[m]);
		sb.append(arr[n]).append(" ");
	}
}
