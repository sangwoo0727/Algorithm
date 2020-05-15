
public class Kakao_2018BlindRecruitment_3_비밀지도 {
	public String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[arr1.length];
		for(int i=0; i<arr1.length; i++) {
			int bit = arr1[i]|arr2[i];
			StringBuilder sb = new StringBuilder();
			for(int b=arr1.length-1; b>=0; b--) {
				if((bit&(1<<b))>=1) sb.append("#");
				else sb.append(" ");
			}
			answer[i] = sb.toString();
		}
		return answer;
	}
}
