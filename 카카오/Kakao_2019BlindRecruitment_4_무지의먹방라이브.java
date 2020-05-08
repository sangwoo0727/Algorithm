import java.util.*;
public class Kakao_2019BlindRecruitment_4_무지의먹방라이브 {
	static List<Pair> arr = new ArrayList<>();
	public int solution(int[] food_times, long k) {
		int answer = -1;
		for(int i=0; i<food_times.length; i++) {
			arr.add(new Pair(food_times[i],i));
		}
		Collections.sort(arr,(Pair p1, Pair p2)->{
			return Integer.compare(p1.n,p2.n);
		});
		long t = 0;
		for(int i=0; i<arr.size(); i++) {
			long tmp = (long)(arr.get(i).n - t) * (long)(arr.size()-i);
			if(tmp>k) {
				k %= (arr.size()-i);
				List<Integer> list = new ArrayList<>();
				for(int j=i; j<arr.size(); j++) {
					list.add(arr.get(j).m);
				}
				Collections.sort(list);
				answer = list.get((int)k)+1;
				break;
			}
			k -= tmp;
			t = arr.get(i).n;
		}
		return answer;
	}
	static class Pair{
		int n,m;
		Pair(int n, int m){this.n=n; this.m=m;}
	}
}
