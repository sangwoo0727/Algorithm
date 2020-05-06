import java.util.*;

public class Kakao_2018BlindRecruitment_1_다트게임 {
	public int solution(String s) {
		int answer = 0;
		Deque<Integer> sum = new ArrayDeque<>(); 
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(c=='S' || c=='D' || c=='T') {
				int n = Integer.parseInt(sb.toString());
				sb = new StringBuilder();
				if(c=='D') n = (int) Math.pow(n, 2);
				if(c=='T') n = (int) Math.pow(n, 3);
				sum.addLast(n);
			}else if(c=='*' || c=='#') {
				if(c=='*') {
					int n = sum.pollLast();
					if(!sum.isEmpty()) {
						int n2 = sum.pollLast();
						sum.addLast(n2*2);
					}
					sum.addLast(n*2);
				}else {
					int n = sum.pollLast();
					sum.addLast(n*-1);
				}
			}else {
				sb.append(c);				
			}
		}
		for(;!sum.isEmpty();) {
			answer += sum.pollLast();
		}
		return answer;
	}
}
