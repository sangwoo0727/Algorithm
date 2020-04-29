import java.util.*;
import java.io.*;
public class SWEA4050_재관이의대량할인 {
	static int N;
	static PriorityQueue<Integer> pq;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			sb.append("#").append(t).append(" ");
			N = Integer.parseInt(br.readLine());
			pq = new PriorityQueue<>();
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				pq.offer(-Integer.parseInt(st.nextToken()));
			}
			long result = 0;
			int cnt = 0;
			while(!pq.isEmpty()) {
				cnt++;
				int n = -pq.poll();
				if(cnt%3==0) {
					cnt = 0;
					continue;
				}
				result+= n;
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
}
