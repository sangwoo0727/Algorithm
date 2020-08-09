public class Kakao_2020BlindRecruitment_1_문자열압축 {
    public int solution(String s){
        int ans = s.length();
        for(int i=1; i<s.length(); i++){
            StringBuilder sb = new StringBuilder();
            String str = "";
            int num = 0;
            for(int j=0; j<s.length(); j+=i){
                if(j+i > s.length()){
                    sb.append(s, j, s.length());
                    break;
                }
                String stmp = s.substring(j,j+i);
                if(num == 0) {
                    sb.append(str);
                    num++;
                    str = stmp;
                    continue;
                }
                if(str.equals(stmp)) num++;
                else {
                    sb.append(num==1? str : num+str);
                    num = 1;
                    str = stmp;
                }
            }
            sb.append(num==1? str : num+str);
            ans = Math.min(ans,sb.length());
        }
        return ans;
    }
}
