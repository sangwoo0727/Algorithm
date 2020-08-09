public class Kakao_2018BlindRecruitment_1_비밀지도 {
    public String[] solution(int n, int[] arr1, int[] arr2){
        String[] answer = new String[n];
        for(int i=0; i<n; i++){
            int bit = arr1[i] | arr2[i];
            StringBuilder sb = new StringBuilder();
            for(int d = n-1; d >=0; d--) {
                if ((bit & (1 << d)) >= 1) sb.append("#");
                else sb.append(" ");
            }
            answer[i] = sb.toString();
        }
        return answer;
    }
}
