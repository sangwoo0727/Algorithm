import java.io.*;
import java.util.*;

public class BOJ1062_가르침 {
	static List<Character> alp = new ArrayList<>();
	static boolean[] ck = new boolean[26];
	static boolean[] input;
	static StringBuilder[] sb;
	static int N,K;
	static int Max = Integer.MIN_VALUE;
	static int size;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		sb = new StringBuilder[N];
		input = new boolean[26];
		for(int i=0; i<N; i++) {
			sb[i] = new StringBuilder(br.readLine());
			sb[i].delete(sb[i].length()-4, sb[i].length());
			sb[i].delete(0, 4);
			for(int j=0; j<sb[i].length(); j++) {
				char c = sb[i].charAt(j);
				if(c=='a'||c=='n'||c=='t'||c=='i'||c=='c') {
					continue;					
				}
				if(!ck[c-'a']) {
					alp.add(c);
					ck[c-'a']=true;
				}
			}
		}
		if(K<5) {
			System.out.println("0");
			return;
		}
		K-=5;
		size = alp.size();
		if(size<K) {
			for(int i=0; i<alp.size(); i++) {
				input[alp.get(i)-'a']=true;
			}
			solve();
		}else comb(0,0);			
		System.out.println(Max);
	}
	
	static void comb(int r, int idx) {
		if(r==K) {
			solve();
			return;
		}
		if(idx>=size) return;
		input[alp.get(idx)-'a'] = true;
		comb(r+1,idx+1);
		input[alp.get(idx)-'a'] = false;
		comb(r,idx+1);
	}
	
	static void solve() {
		int ans = 0;
		for(int i=0; i<sb.length; i++) {
			int num = 0;
			if(sb[i].length()==0) {
				ans++;
				continue;
			}
			for(int k=0; k<sb[i].length(); k++) {
				char c = sb[i].charAt(k);
				if(c=='a' || c=='n' || c=='t' || c=='i' || c=='c') {
					num++;
				}
				else if(input[c-'a']) num++;
			}	
			if(num == sb[i].length()) {
				ans++;
			}
		}
		Max = Math.max(Max, ans);
	}
}
