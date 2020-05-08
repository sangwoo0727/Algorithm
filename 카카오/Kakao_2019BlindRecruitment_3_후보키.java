import java.util.*;

public class Kakao_2019BlindRecruitment_3_후보키 {
	static HashSet<Integer> set = new HashSet<>();
	static List<Integer> list = new ArrayList<>();
	static HashSet<String> sset;
	static int N,M;
	public int solution(String[][] relation) {
		N = relation.length;
		M = relation[0].length;
		for(int i=1; i<(1<<M); i++) {
			list.add(i);
		}
		Collections.sort(list, (Integer o1, Integer o2)->{
			int cnt = 0, cnt2 = 0;
			for(int i=0; i<M; i++) {
				if((o1 &(1<<i))>0) cnt++;
				if((o2 &(1<<i))>0) cnt2++;
			}
			if(cnt==cnt2) return o1.compareTo(o2);
			else return cnt-cnt2;
		});
		for(int bit: list) {
			boolean flg = false;
			for(int n:set) {
				int tmp = n|bit;
				int cnt=0, cnt2=0;
				for(int i=0; i<M; i++) {
					if((bit &(1<<i))>0) cnt++;
					if((tmp &(1<<i))>0) cnt2++;
				}
				if(cnt==cnt2) flg = true;
			}
			if(flg) continue;
			sset = new HashSet<>();
			for(int i=0; i<N; i++) {
				StringBuilder sb = new StringBuilder();
				for(int j=0; j<M; j++) {
					if((bit&(1<<j))>0) {
						sb.append(relation[i][j]).append(" ");
					}
				}
				sset.add(sb.toString());
			}
			if(sset.size()==N) {
				set.add(bit);
			}
		}
		return set.size();
	}
}
