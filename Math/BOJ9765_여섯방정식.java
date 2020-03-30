import java.io.*;
import java.util.*;

public class BOJ9765_여섯방정식 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static long[] cn = new long[6];
	static boolean[] pn = new boolean[20000001];
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		isPn();
		for(int i=0; i<6; i++) {
			cn[i] = Long.parseLong(st.nextToken());
		}
		for(int i=2; i<= Math.sqrt(cn[0]); i++) {
			if(pn[i]) continue;
			if(cn[0]%(long)i==0) {
				if(cn[0]/i <= 20000000) {
					int j = (int) (cn[0]/(long)i);
					if(cn[4]%(long)j==0 && cn[4]/(long)j <=20000000) {
						int k = (int) (cn[4]/(long)j);
						System.out.print(i+" "+j+" "+k);
						break;
					}
					if(cn[4]%(long)i==0 && cn[4]/(long)i <=20000000) {
						int k = (int) (cn[4]/(long)i);
						System.out.print(j+" "+i+" "+k);
						break;
					}
				}
			}
		}
		for(int i=2; i<= Math.sqrt(cn[5]); i++) {
			if(pn[i]) continue;
			if(cn[5]%(long)i==0) {
				if(cn[5]/(long)i <= 20000000) {
					int j = (int) (cn[5]/(long)i);
					if(cn[2]%(long)j==0 && cn[2]/(long)j <=20000000) {
						int k = (int) (cn[2]/(long)j);
						System.out.print(i+" "+j+" "+k);
						break;
					}
					if(cn[2]%(long)i==0 && cn[2]/(long)i <=20000000) {
						int k = (int) (cn[2]/(long)i);
						System.out.print(j+" "+i+" "+k);
						break;
					}
				}
			}
		}
	}
	static void isPn() {
		for(int i=2; i<=20000000; i++) {
			if(pn[i]==false) {
				for(int j=i+i; j<=20000000; j+=i) {
					pn[j]=true;
				}
			}
		}
	}
}
