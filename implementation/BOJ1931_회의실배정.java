import java.io.*;
import java.util.*;

public class BOJ1931_회의실배정 {
	static ArrayList <Pair> v = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		while(N-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			v.add(new Pair(left, right));
		}
		Collections.sort(v);
		int k = -100;
		int cnt = 0;
		for(int i=0; i<v.size(); i++) {
			if(v.get(i).l >= k) {
				k = v.get(i).r;
				cnt++;
			}
		}
		System.out.println(cnt);
	}
	static class Pair implements Comparable<Pair>{
		int l,r;
		Pair(int l, int r){this.l=l; this.r=r;}
		@Override
		public int compareTo(Pair o) {
			int tmp = r-o.r;
			if(tmp==0) return l-o.l;
			else return tmp;
		}
	}
}
