import java.util.*;
public class Kakao_2019BlindRecruitment_1_오픈채팅방 {
	static HashMap<String,String> map = new HashMap<>();
	public String[] solution(String[] record) {
		String[] answer = new String[record.length];
		int n = 0;
		for(String s: record) {
			StringTokenizer st = new StringTokenizer(s);
			String kind = st.nextToken();
			String key = st.nextToken();
			String val = null;
			if(kind.equals("Enter")) {
				val = st.nextToken();
				map.put(key, val);
			}else if(kind.equals("Change")) {
				val = st.nextToken();
				map.put(key, val);
				continue;
			}
			n++;
		}
		answer = new String[n];
		int idx = 0;
		for(String s: record) {
			StringTokenizer st = new StringTokenizer(s);
			String kind = st.nextToken();
			String key = st.nextToken();
			if(kind.equals("Enter")) {
				st.nextToken();
				answer[idx++] = map.get(key)+"님이 들어왔습니다.";
			}else if(kind.equals("Leave")){
				answer[idx++] = map.get(key)+"님이 나갔습니다.";
			}
		}
		return answer;
	}
}
