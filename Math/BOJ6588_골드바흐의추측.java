import java.io.*;
import java.util.*;

public class BOJ6588_골드바흐의추측 {
	static int[] bd = new int[1000001];
	static int N;
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		pp();
		while(true) {
			N = Integer.parseInt(br.readLine());
			boolean flg = false;
			if(N==0) break;
			for(int i=3; i<N; i++) {
				if(bd[i]==0) continue;
				if(bd[N-bd[i]]!=0) {
					flg = true;
					sb.append(N+" = "+bd[i]+" + "+bd[N-bd[i]]+"\n");
					break;
				}
			}
			if(flg == false) sb.append("Goldbach's conjecture is wrong\n");
		}
		System.out.println(sb);
		
	}
	static void pp() {
		int n=1;
		for(int i=1; i<=1000000; i++) {
			bd[i] = n++;
		}
		for(int i=2; i<=1000000; i++) {
			if(bd[i]==0) continue;
			for(int j=2; j*i<=1000000; j++) {
				bd[i*j]=0;
			}
		}
	}
}