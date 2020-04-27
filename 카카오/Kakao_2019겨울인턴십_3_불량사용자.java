import java.util.*;

public class Kakao_2019겨울인턴십_3_불량사용자 {
	static Set<Integer> set = new HashSet<>();
	static int R;
	public int solution(String[] user_id, String[] banned_id) {
		R = banned_id.length;
		permu(0,0,user_id,banned_id);
		return set.size();
	}
	static void permu(int r,int bit, String[] uid, String[] bid) {
		if(r==R) {
			set.add(bit);
			return;
		}
		for(int i=0; i<uid.length; i++) {
			if(((bit>>i)&1)==0) {
				boolean flg = true;
				String us = uid[i];
				String bs = bid[r];
				if(us.length() == bs.length()) {
					for(int j=0; j<us.length(); j++) {
						if(us.charAt(j) == bs.charAt(j) || bs.charAt(j)=='*') {
							continue;
						}else flg = false;
					}
				}else flg = false;
				if(flg) {
					permu(r+1,(bit|(1<<i)),uid,bid);
				}
			}
		}
	}
}
