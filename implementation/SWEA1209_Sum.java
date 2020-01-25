import java.util.*;
import java.io.*;

public class Solution {
	static int[][] arr;
	static int Max;
	
	public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int tc=1;tc<=10;tc++) {
        	input(br);
        	solve(tc);
        }
    }
	
	static void input(BufferedReader br) throws Exception{
		arr = new int[101][101];
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<100;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<100;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	static void solve(int tc) {
		Max = Integer.MIN_VALUE;
		int crossSum = 0;
		int crossSum2 = 0;
		int len = 99;
		for(int i=0;i<100;i++) {
			int sum = 0 , sum2= 0;
			for(int j=0; j<100; j++) {
				sum += arr[i][j];
				sum2 += arr[j][i];
			}
			sum = (sum >= sum2) ? sum : sum2;
			Max = (Max >= sum) ? Max : sum;
			crossSum += arr[i][i];
			crossSum2 += arr[i][len--];
		}
		crossSum = (crossSum >= crossSum2) ? crossSum : crossSum2;
		Max = (Max >= crossSum) ? Max : crossSum;
		System.out.println("#"+tc+ " "+ Max);
	}
     
}
