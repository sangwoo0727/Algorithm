import java.util.*;
import java.io.*;

class ans{
	int m, cnt;
	ans (int m,int cnt){
		this.m = m;
		this.cnt = cnt;
	}
}

public class Solution {
	static int[][] arr;
	static boolean[][] check;
	static int res;
	static int[] dc = {0,0,-1};
	static int[] dr = {1,-1,0};
	
	static void ckClear() {
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				check[i][j]=false;
			}
		}
	}
	
	static ans go(int n,int m,int cnt) {
		if(n==0) {
			return new ans(m,cnt);
		}
		else {
			int nn=0,mn=0;
			for(int k=0;k<3;k++) {
				nn = n+dc[k];
				mn = m+dr[k];
				if(nn<0 || nn>=100 || mn <0 || mn >=100)
					continue;
				else if(check[nn][mn] || arr[nn][mn]==0)
					continue;
				check[nn][mn]=true;
				break;
			}
			return go(nn,mn,cnt+1);
		}
	}
	
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/input.txt"));
    	int n = 0,m = 0, result = 0;
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	arr = new int[101][101];
    	check = new boolean[101][101];
    	for(int t=1; t<=10;t++) {
    		int tc = Integer.parseInt(br.readLine());
    		int Min = 1000000000;
    		for(int i=0;i<100;i++) {
    			StringTokenizer st = new StringTokenizer(br.readLine());
    			for(int j=0;j<100;j++) {
    				arr[i][j] = Integer.parseInt(st.nextToken());
    			}
    		}
    		for(int j=0;j<100;j++) {
    			if(arr[99][j]==1) {
    				ckClear();
    				ans res = go(99,j,0);
    				if(Min >= res.cnt) {
    					Min = res.cnt;
    					result = res.m;
    				}
    			}
    		}
    		System.out.println("#"+tc+" "+ result);
    	}
    }
     
}
