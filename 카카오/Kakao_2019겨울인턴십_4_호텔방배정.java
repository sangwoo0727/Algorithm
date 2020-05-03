import java.util.*;

public class Kakao_2019겨울인턴십_4_호텔방배정 {
	static HashMap<Long, Long> map = new HashMap<>();
	public static long[] solution(long k, long[] room_number) {
		long[] answer = new long[room_number.length];
        for(int i=0; i<room_number.length; i++) {
        	long n = room_number[i];
        	answer[i] = find(n);
        	merge(answer[i],answer[i]+1);
        }
        return answer;
    }
	static long find(long n) {
		if(!map.containsKey(n) || map.get(n)==n) {
			map.put(n, n);
			return n;			
		}else {
			map.put(n, find(map.get(n)));
			return map.get(n);
		}
	}
	static void merge(long n, long m) {
		n = find(n);
		m = find(m);
		if(n<m) map.put(n, m);
		else map.put(m, n);
	}
}
