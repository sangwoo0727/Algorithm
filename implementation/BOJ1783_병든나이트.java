import java.io.*;
import java.util.*;
 
public class BOJ1783_병든나이트 {	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int ans = 0;
		if(n==1) ans = 1;
		else {
			if(n==2) {
				if(m<=2) ans = 1;
				else {
					if(m>=3 && m<5) ans = 2;
					else if(m>=5 && m<7) ans = 3;
					else ans = 4;
				}
			}
			else {//n 이 3보다 클
				if(m<2) ans = 1;
				else if(m==2) ans = 2;
				else if(m==3) ans = 3;
				else if(m>=4 && m<=6) ans = 4;
				else {
					ans = 5;
					ans += m-7; 
				}
			}
		}
		System.out.println(ans);
	}
	
}