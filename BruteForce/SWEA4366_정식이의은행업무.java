import java.io.*;
import java.util.*;
public class SWEA4366_정식이의은행업무 {
	static int[] arr2;
	static int[] arr3;
	static long sum2,sum3;
	static long ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			sb.append("#").append(t).append(" ");
			sum2 = sum3 = 0;
			String s2 = br.readLine();
			String s3 = br.readLine();
			arr2 = new int[s2.length()];
			arr3 = new int[s3.length()];
			for(int i=0; i<arr2.length; i++) {
				int n = s2.charAt(s2.length()-1-i)-'0';
				arr2[i] = n; 
				sum2+= Math.pow(2, i)*n;
			}
			for(int i=0; i<arr3.length; i++) {
				int n = s3.charAt(s3.length()-1-i)-'0';
				arr3[i] = n;
				sum3+= Math.pow(3, i)*n;
			}
			loop: for(int i=0; i<arr2.length; i++) {
				long tmp2 = sum2;
				if(arr2[i]==0) tmp2 += Math.pow(2, i)*1;
				else tmp2 -= Math.pow(2, i)*1;
				for(int j=0; j<arr3.length; j++) {
					long tmp3 = sum3;
					if(arr3[j]==0) {
						tmp3 += Math.pow(3, j)*1;
						if(tmp2==tmp3) {
							ans = tmp2;
							break loop;
						}
						tmp3 =sum3;
						tmp3 += Math.pow(3, j)*2;
						if(tmp2==tmp3) {
							ans = tmp2;
							break loop;
						}
					}else if(arr3[j]==1) {
						tmp3 = sum3;
						tmp3 -= Math.pow(3, j);
						if(tmp2==tmp3) {
							ans = tmp2;
							break loop;
						}
						tmp3 += Math.pow(3, j)*2;
						if(tmp2==tmp3) {
							ans = tmp2;
							break loop;
						}
					}else{
						tmp3 = sum3;
						tmp3 -= Math.pow(3, j)*2;
						if(tmp2==tmp3) {
							ans = tmp2;
							break loop;
						}
						tmp3 += Math.pow(3, j)*1;
						if(tmp2==tmp3) {
							ans = tmp2;
							break loop;
						}
					}
				}
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}
}
