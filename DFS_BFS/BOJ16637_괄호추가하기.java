import java.util.*;
import java.io.*;

public class Solution {
	static int N;
	static ArrayList<Character> op = new ArrayList<>();
	static ArrayList<Integer> na = new ArrayList<>();
	static long ans = Integer.MIN_VALUE;
	
	static long cal(long n1, long n2, char op) {
		if(op=='+') {
			return n1+n2;
		}
		else if(op=='-') {
			return n1-n2;
		}
		else {
			return n1*n2;
		}
	}
	
	static void go(long result, int idx) {
		if(idx >= op.size()) {
			if(ans < result) {
				ans = result;
			}
			return;
		}
		long tmp = cal(result,na.get(idx+1),op.get(idx));
		go(tmp,idx+1);
		if(idx+1 < op.size()) {
			long tmp2 = cal(na.get(idx+1), na.get(idx+2), op.get(idx+1));
			go(cal(result,tmp2,op.get(idx)),idx+2);
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		char[] c = br.readLine().toCharArray();
		for(int i=0; i<N; i++) {
			if(c[i]=='+' || c[i]=='-' || c[i]=='*') {
				op.add(c[i]);
			}
			else {
				na.add(c[i]-'0');
			}
		}
		go(na.get(0),0);
		System.out.println(ans);
	}
}