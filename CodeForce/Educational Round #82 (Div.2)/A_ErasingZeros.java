import java.io.*;
import java.util.*;
 
public class A_ErasingZeros {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			String s = br.readLine();
			boolean flg = false;
			int sum = 0, tmp = 0;
			for(int i=0; i<s.length(); i++) {
				char c = s.charAt(i);
				if(!flg) {
					if(c=='1') flg=true;
				}else {
					if(c=='0') {
						tmp++;
					}else {
						sum+= tmp;
						tmp = 0;
					}
				}
			}
			System.out.println(sum);
		}
	}
}