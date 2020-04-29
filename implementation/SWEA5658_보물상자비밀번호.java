import java.io.*;
import java.util.*;
public class SWEA5658_보물상자비밀번호 {
	static TreeSet<Integer> set;
	static int N,K;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			sb.append("#").append(t).append(" ");
			set = new TreeSet<>();
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			StringBuilder s = new StringBuilder(br.readLine());
			for(int rot=0; rot<N/4; rot++) {
				int len = N/4;
				int idx = 0;
				StringBuilder div = new StringBuilder();
				for(int i=0; i<s.length(); i++) {
					idx++;
					div.append(s.charAt(i));
					if(idx==len) {
						int n = Integer.parseInt(div.toString(),16);
						set.add(n);
						idx=0;
						div = new StringBuilder();
					}
				}
				char c = s.charAt(s.length()-1);
				s.setLength(s.length()-1);
				s.insert(0, c);
			}
			int cnt = 0;
			for(int a:set) {
				cnt++;
				if(cnt==set.size()-K+1) {
					sb.append(a).append("\n");
					break;
				}
			}
		}
		System.out.println(sb);
	}
}
