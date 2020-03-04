
import java.io.*;
import java.util.*;

public class C_Kuroni_and_Impossible_Calculation {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n,m;
	static int[] a;
	static long ans = 1;
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		a = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		if(n>m) {
			System.out.println("0");
		}
		else {
			for(int i=0; i<n-1; i++) {
				for(int j=i+1; j<n; j++) {
					ans = (ans * Math.abs(a[i]-a[j]))%m;
				}
			}
			System.out.println(ans);
		}
	}
}
