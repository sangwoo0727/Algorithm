import java.util.*;
import java.io.*;

public class Solution {
	static char[][] arr;
	public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("res/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc =1 ; tc<=T; tc++) {
        	arr = new char[5][15];
        	for(int i=0; i<5; i++) {
        		String s = br.readLine();
        		for(int j=0;j<s.length();j++) {
        			arr[i][j] = s.charAt(j);
        		}
        	}
        	System.out.print("#"+tc+" ");
        	for(int i=0;i<15;i++) {
        		for(int j=0;j<5;j++) {
        			if(arr[j][i] != 0) {
        				System.out.print(arr[j][i]);
        			}
        		}
        	}
        	System.out.println();
        }
        br.close();
    }
}
