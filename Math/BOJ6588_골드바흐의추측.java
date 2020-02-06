import java.io.*;
import java.util.*;

public class BOJ6588_골드바흐의추측 {
	static boolean[] bd = new boolean[1000001];
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
				if(bd[i]) continue;
				if(!bd[N-i]) {
					flg = true;
					sb.append(N+" = ").append(i).append(" + ").append(N-i).append("\n");
					break;
				}
			}
			if(flg == false) sb.append("Goldbach's conjecture is wrong\n");
		}
		System.out.println(sb);
		
	}
	static void pp() {
		for(int i=2; i<=1000000; i++) {
			if(bd[i]==true) continue;
			for(int j=2; j*i<=1000000; j++) {
				bd[i*j]=true;
			}
		}
	}
}