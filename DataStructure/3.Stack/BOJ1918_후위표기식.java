
import java.util.*;
import java.io.*;

public class Solution{
	static char[] ca;
	
	static void in2Post(StringBuilder sb) {
		Stack <Character> s = new Stack<>();
		for(char c: ca) {
			if('A'<=c && c<='Z') {
				sb.append(c);
			}
			else if(c==')') {
				char ch = '\u0000';
				while((ch=s.pop())!='(') {
					sb.append(ch);
				}
			}
			else {
				while(icp(c) <= isp(s)){
					sb.append(s.pop());
				}
				s.push(c);
			}
		}
		while(!s.empty()) {
			sb.append(s.pop());
		}
	}
	
	static int isp(Stack<Character> s) {
		char c = s.empty()? ' ' : s.peek();
		if(c=='*' || c=='/') return 2;
		if(c=='+'|| c=='-') return 1;
		else return 0;
	}
	static int icp(char c) {
		if(c=='*' || c=='/') return 2;
		if(c=='+' || c=='-') return 1;
		if(c=='(') return 3;
		else return 0;
	}
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ca = br.readLine().toCharArray();
		in2Post(sb);
		System.out.println(sb.toString());
	}
}