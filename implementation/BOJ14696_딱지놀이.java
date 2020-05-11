import java.io.*;
import java.util.*;

public class BOJ14696_딱지놀이 {
	static int[] arr,arr2;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		while(n-->0) {
			arr = new int[4];
			arr2 = new int[4];
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			for(int i=0; i<a; i++) {
				arr[Integer.parseInt(st.nextToken())-1]++;
			}
			st = new StringTokenizer(br.readLine()," ");
			a = Integer.parseInt(st.nextToken());
			for(int i=0; i<a; i++) {
				arr2[Integer.parseInt(st.nextToken())-1]++;
			}
			boolean flg = true;
			for(int i=3; i>=0; i--) {
				if(arr[i] > arr2[i]) {
					flg = false;
					sb.append("A").append("\n");
					break;
				}else if(arr[i] < arr2[i]) {
					flg = false;
					sb.append("B").append("\n");
					break;
				}
			}
			if(flg) sb.append("D").append("\n");
		}
		System.out.println(sb);
	}
}
