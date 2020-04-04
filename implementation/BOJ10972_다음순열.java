import java.io.*;
import java.util.*;

public class BOJ10972_다음순열 {
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		if(next_permutation(arr)) {
			for(int a:arr) {
				System.out.print(a+" ");
			}
		}else {
			System.out.println("-1");
		}
	}
	static boolean next_permutation(int[] arr) {
		int i = N-1;
		while(i>0 && arr[i-1]>arr[i])
			i--;
		if(i==0) return false;
		int j = N-1;
		while(arr[i-1]>=arr[j])
			j--;
		
		int tmp = arr[i-1];
		arr[i-1] = arr[j];
		arr[j] = tmp;
		
		int k = N-1;
		while(i<k) {
			tmp = arr[i];
			arr[i] = arr[k];
			arr[k]=tmp;
			i++; k--;
		}
		return true;
	}
}
