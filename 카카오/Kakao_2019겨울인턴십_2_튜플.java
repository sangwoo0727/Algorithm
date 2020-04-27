import java.util.*;
public class Kakao_2019겨울인턴십_2_튜플 {
	static HashMap<Integer,Integer> map = new HashMap<>();
	public int[] solution(String s) {
		int[] answer = {};
		StringTokenizer st = new StringTokenizer(s,"{},");
		while(st.hasMoreTokens()) {
			int tmp = Integer.parseInt(st.nextToken());
			if(map.containsKey(tmp)) map.put(tmp, map.get(tmp)+1);
			else map.put(tmp, 1);
		}
		List<Integer> keyList = new ArrayList<>(map.keySet());
		Collections.sort(keyList,(o1, o2)->{
			return -map.get(o1).compareTo(map.get(o2));
		});
		answer = new int[map.size()];
		int idx=0;
		for(Integer key : keyList) {
			answer[idx++] = key;
		}
		return answer;
	}
}
