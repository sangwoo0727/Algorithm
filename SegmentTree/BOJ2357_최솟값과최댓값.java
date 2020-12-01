import java.io.*;
import java.util.*;

public class BOJ2357_최솟값과최댓값 {
	static int[] mitree,mxtree;
	static int[] input;
	static int N,M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		mitree = new int[N*4];
		mxtree = new int[N*4];
		input = new int[N+1];
		for(int i=1; i<=N; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		miinit(1,N,1);
		mxinit(1,N,1);
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			sb.append(mifind(1,left,right,1,N)).append(" ");
			sb.append(mxfind(1,left,right,1,N)).append("\n");
		}
		System.out.println(sb);
	}
	static int mifind(int node, int left, int right, int start, int end) {
		if(end<left || right<start) {
			return Integer.MAX_VALUE;
		}
		if(left<=start && end<=right) {
			return mitree[node];
		}
		int mid = (start+end) >> 1;
		return Math.min(mifind(node*2,left,right,start,mid), mifind(node*2+1,left,right,mid+1,end));
	}
	static int mxfind(int node, int left, int right, int start, int end) {
		if(end<left || right<start) {
			return Integer.MIN_VALUE;
		}
		if(left<=start && end<=right) {
			return mxtree[node];
		}
		int mid = (start+end)>>1;
		return Math.max(mxfind(node*2,left,right,start,mid), mxfind(node*2+1,left,right,mid+1,end));
	}
	static int miinit(int start, int end, int node) {
		if(start==end) {
			return mitree[node] = input[start];
		}
		int mid = (start+end)/2;
		return mitree[node] = Math.min(miinit(start,mid,node*2), miinit(mid+1,end,node*2+1));
	}
	static int mxinit(int start, int end, int node) {
		if(start==end) {
			return mxtree[node] = input[start];
		}
		int mid = (start+end)/2;
		return mxtree[node] = Math.max(mxinit(start,mid,node*2), mxinit(mid+1,end,node*2+1));
	}
}
