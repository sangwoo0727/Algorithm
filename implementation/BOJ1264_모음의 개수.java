import java.util.*;
import java.io.*;

public class Solution {
	
	public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("res/sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String[] s = br.readLine().split("");
			if(s[0].equals("#"))
				break;
			int cnt = 0;
			for(int i=0;i<s.length;i++) {
				if(s[i].equals("a")||s[i].equals("e")||s[i].equals("i")||s[i].equals("o")||s[i].equals("u")) {
					cnt++;
				}
				else if(s[i].equals("A")||s[i].equals("E")||s[i].equals("I")||s[i].equals("O")||s[i].equals("U")) {
					cnt++;
				}
			}
			System.out.println(cnt);
		}
    }
}
