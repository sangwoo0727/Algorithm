import java.io.*;
import java.util.*;
 
public class BOJ1448_삼각형만들기 {	
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		int sum=0;
		for(int i=n-1; i>=2; i--) {
			if(arr[i] < arr[i-1]+arr[i-2]){
				sum = arr[i]+arr[i-1]+arr[i-2];
				break;
			}
		}
		if(sum>0) System.out.println(sum);
		else System.out.println("-1");
	}
}