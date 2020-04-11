import java.io.*;
import java.util.*;

public class BOJ3613_Java_vs_cplusplus {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringBuilder sb = new StringBuilder();
		if(error(s)) {
			System.out.println("Error!");
			return;
		}else {
			if(s.contains("_")) {
				//c++ -> java
				for(int i=0; i<s.length(); i++) {
					if(s.charAt(i)=='_') {
						if(!(s.charAt(i+1)>='a' && s.charAt(i+1)<='z')) {
							System.out.println("Error!");
							return;
						}
						char c = (char) (s.charAt(++i)-32);
 						sb.append(c);
					}else {
						sb.append(s.charAt(i));
					}
				}
			}else {
				//java -> c++
				for(int i=0; i<s.length(); i++) {
					if(s.charAt(i)<'a') {
						char c = (char) (s.charAt(i)+32);
						sb.append('_').append(c);
					}else {
						sb.append(s.charAt(i));
					}
				}
			}
		}
		System.out.println(sb);
	}
	static boolean error(String s) {
		for(int i=0; i<s.length(); i++) {
			if(i==0) {
				if(!(s.charAt(i)>='a' && s.charAt(i)<='z'))
					return true;
			}
			else if(i==s.length()-1) {
				if(s.charAt(i)=='_')
					return true;
			}
			else {
				if(s.charAt(i)=='_' && s.charAt(i+1)=='_')
					return true;
			}
		}
		for(int i=0; i<s.length();i++) {
			if((s.charAt(i)>='a' && s.charAt(i)<='z')
				|| s.charAt(i)>='A' && s.charAt(i)<='Z'
				|| s.charAt(i)=='_') continue;
			else return true;
		}
		return false;
	}
}
