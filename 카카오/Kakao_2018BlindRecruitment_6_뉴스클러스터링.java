import java.util.*;

public class Kakao_2018BlindRecruitment_6_뉴스클러스터링 {
	static List<String> list1 = new ArrayList<>();
	static List<String> list2 = new ArrayList<>();
	public static int solution(String str1, String str2) {
		makeList(0,list1,str1);
		makeList(0,list2,str2);
		boolean[] visit = new boolean[list1.size()];
		boolean[] visit2 = new boolean[list2.size()];
		double uniset = 0;
		double inset = 0;
		for(int i=0; i<list1.size(); i++) {
			for(int j=0; j<list2.size(); j++) {
				if(!visit2[j] && list1.get(i).equals(list2.get(j))) {
					visit[i]=true;
					visit2[j]=true;
					inset++;
					uniset++;
					break;
				}
			}
		}
		for(int i=0; i<list1.size(); i++) {
			if(!visit[i]) uniset++;
		}
		for(int i=0; i<list2.size(); i++) {
			if(!visit2[i]) uniset++;
		}
		double div = 0;
		if(inset==0 && uniset==0) {
			div = 1;
		}else {
			div = (inset/uniset);
		}
		int answer = (int)(div*65536); 
		return answer;
	}
	static void makeList(int idx, List<String> list, String s) {
		for(;;) {
			if(idx==s.length()-1) break;
			char c = s.charAt(idx);
			char c2 = s.charAt(idx+1);
			if('A'<=c && c<='Z') c = (char) ('a'+(c-'A'));
			else if('a'>c || c>'z') {
				idx+=1;
				continue;
			}
			if('A'<=c2 && c2<='Z') c2 = (char) ('a'+(c2-'A'));
			else if('a'>c2 || c2>'z') {
				idx+=1;
				continue;
			}
			list.add(new String(c+""+c2));
			idx+=1;
		}
	}
}
