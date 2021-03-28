public class Kakao_2020BlindRecruitment_1_문자열압축_2회 {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        for (int size = 1; size <= s.length(); size++) {
            StringBuilder updatedString = new StringBuilder();
            String prev = s.substring(0, size);
            int cnt = 1;
            for (int index = size; index <= s.length(); index += size) {
                if (index + size > s.length()) {
                    String last = s.substring(index, s.length());
                    updatedString.append(last);
                    break;
                }
                String now = s.substring(index, index + size);
                if (prev.equals(now)) {
                    cnt++;
                    continue;
                }
                updatedString.append(cnt == 1 ?
                        prev :
                        cnt + prev);
                prev = now;
                cnt = 1;
            }
            updatedString.append(cnt == 1 ?
                    prev :
                    cnt + prev);
            answer = Math.min(answer, updatedString.length());
        }
        return answer;
    }
}
