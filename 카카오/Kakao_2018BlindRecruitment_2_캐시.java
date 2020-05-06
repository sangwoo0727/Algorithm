import java.util.*;
public class Kakao_2018BlindRecruitment_2_캐시 {
	static HashMap<String,Integer> map = new HashMap<>(); 
	public int solution(int cacheSize, String[] cities) {
		int answer = 0;
		int time = 0;
		if(cacheSize==0) {
			answer = 5*cities.length;
			return answer;
		}
		for(String s: cities) {
			s = s.toLowerCase();
			if(!map.containsKey(s)) {
				if(map.size()==cacheSize) {
					List<String> keyList = new ArrayList<>(map.keySet());
					Collections.sort(keyList, (String s1, String s2)->{
						return map.get(s1).compareTo(map.get(s2));
					});
					map.remove(keyList.get(0));
				}
				map.put(s, time++);
				answer +=5;
			}else {
				answer += 1;
				map.put(s, time++);
			}
		}
		return answer;
	}
}
