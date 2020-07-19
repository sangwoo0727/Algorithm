package algo2;

import java.io.*;
import java.util.*;

public class BOJ10816_숫자카드2 {
	static int N,M;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int key = Integer.parseInt(st.nextToken());
			
			int lIdx = lower_bound(0,N,key);
			int uIdx = upper_bound(0,N,key);
			System.out.println(lIdx+" "+uIdx);
			sb.append(uIdx-lIdx).append(" ");
		}
		System.out.println(sb);
	}
	static int lower_bound(int l, int r, int key) {
		int m = 0;
		while(l<r) {
			m = (l+r)/2;
			if(arr[m]<key) l = m+1;
			else r = m;
		}
		return r;
	}
	static int upper_bound(int l,int r, int key) {
		int m = 0;
		while(l<r) {
			m = (l+r)/2;
			if(arr[m]<=key) l = m+1;
			else r = m;
		}
		return r;
	}
}
