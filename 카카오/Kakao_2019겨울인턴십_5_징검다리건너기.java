public class Kakao_2019겨울인턴십_5_징검다리건너기 {
	public int solution(int[] stones, int k) {
		int ans = 0;
		int l = 1;
		int r = 200000000;
		while(l<=r) {
			int m = (l+r)/2;
			int cnt=0,tmp=0;
			for(int i=0; i<stones.length; i++) {
				if(stones[i]>m) {
					tmp = Math.max(tmp, cnt);
					cnt = 0;
				}else {
					cnt++;
				}
			}
			tmp = Math.max(tmp, cnt);
			if(tmp<k) {
				l = m+1;
			}else {
				ans = m;
				r = m-1;
			}
		}
		return ans;
	}
}
