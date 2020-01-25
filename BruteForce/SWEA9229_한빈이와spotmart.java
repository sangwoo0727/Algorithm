import java.util.*;
import java.io.*;

public class Solution {
	static int[] arr;
	static int N,M;

	public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T;tc++) {
        	input(br);
        	solve(tc);
        }
    }
	static void input(BufferedReader br) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for(int n=0;n<N;n++) {
			arr[n]= Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
	}
	static void solve(int tc) {
		int Max = Integer.MIN_VALUE;
		for(int i=0;i < N-1;i++) {
			int sum = arr[i];
			for(int j=i+1;j < N ;j++) {
				if(sum+arr[j]>M) {
					break;
				}
				if(sum+arr[j] >= Max) {
					Max = sum+arr[j];
				}
			}
		}
		if(Max == Integer.MIN_VALUE) {
			System.out.println("#"+tc+" -1");
		}
		else {
			System.out.println("#"+tc+" "+Max);	
		}
		
	}
}
