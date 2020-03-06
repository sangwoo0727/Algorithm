
import java.io.*;
import java.util.*;

public class SWEA4796_의석이의우뚝선산 {
	static StringBuilder sb = new StringBuilder();
	static int[] a;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1; t<=tc; t++) {
			sb.append("#").append(t).append(" ");
			int n = sc.nextInt();
			a = new int[n];
			for(int i=0; i<n; i++) {
				a[i] = sc.nextInt();
			}
			int ans = 0;
			int l=0,r=0;
			for(int i=1; i<n; i++) {
				if(a[i-1]<a[i]) {
					if(r>0) {
						ans += l*r;
						l=r=0;
					}
					l++;
				}else {
					r++;
				}
			}
			ans += l*r;
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}
}
