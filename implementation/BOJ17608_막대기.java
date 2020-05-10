import java.io.*;
import java.util.*;
public class BOJ17608_막대기 {
	static int n,ans,a;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		a = 0;
		for(int i=n-1; i>=0; i--) {
			if(arr[i]>a) {
				ans++;
				a = arr[i];
			}
		}
		System.out.println(ans);
	}
}
