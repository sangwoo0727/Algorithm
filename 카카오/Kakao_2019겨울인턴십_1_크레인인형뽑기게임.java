import java.util.*;

public class Kakao_2019겨울인턴십_1_크레인인형뽑기게임 {
	static Deque<Integer> st = new ArrayDeque<>();
	public int solution(int[][] bd,int[] moves) {
		int ans = 0;
		for(int m=0; m<moves.length; m++) {
			int j = moves[m]-1;
			for(int i=0; i<bd.length; i++) {
				if(bd[i][j]!=0) {
					if(st.isEmpty() || st.peekLast()!=bd[i][j]) {
						st.offerLast(bd[i][j]);
					}else {
						st.pollLast();
						ans+=2;
					}
					bd[i][j]=0;
					break;
				}
			}
		}
		return ans;
	}
}
