
import java.io.*;
import java.util.*;

public class SWEA1952_수영장 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	static int[] arr = new int[12];
	static int[] cost = new int[4];
	static int Min = Integer.MAX_VALUE;
	
	
	public static void main(String[] args) throws Exception {
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			Min = Integer.MAX_VALUE;
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<4; i++) {
				cost[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<12; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			comb(0,0);
			Min = Math.min(Min, cost[3]);
			sb.append(Min).append("\n");
		}
		System.out.println(sb);
	}
	public static void comb(int idx,int sum) {
		if(idx>=12) {
			Min = Math.min(Min, sum);
			return;
		}
		for(int i=0; i<3; i++) {
			if(i==0) {
				if(idx<10) {
					if(arr[idx]==0 && arr[idx+1]==0 && arr[idx+2]==0) {
						comb(idx+3,sum);
					}else {
						if(sum+cost[2] <= Min) {
							comb(idx+3, sum+cost[2]);			
						}
					}
				}
				else if(idx==10) {
					if(arr[idx]==0 && arr[idx+1]==0) comb(idx+2, sum);
					else {
						if(sum+cost[2] <=Min) {
							comb(idx+2,sum+cost[2]);	
						}
					}
					
				}else if(idx==11){
					if(arr[idx]==0) comb(idx+1, sum);
					else {
						if(sum+cost[2] <= Min) {
							comb(idx+1, sum+cost[2]);	
						}
					}
				}
			}else if(i==1) {
				if(arr[idx]==0) comb(idx+1, sum);
				else {
					if(sum+cost[1]<=Min) {
						comb(idx+1,sum+cost[1]);
					}
				}
			}else {
				if(arr[idx]==0) comb(idx+1, sum);
				else {
					if(sum+cost[0]*arr[idx] <=Min) {
						comb(idx+1, sum+ cost[0]*arr[idx]);
					}
				}
			}
		}
	}
}
