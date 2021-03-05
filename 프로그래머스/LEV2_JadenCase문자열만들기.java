public class LEV2_JadenCase문자열만들기 {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                answer.append(c);
                continue;
            }
            if (i == 0 || s.charAt(i - 1) == ' ') {
                if (c >= 'a' && c <= 'z') {
                    answer.append(Character.toUpperCase(c));
                } else {
                    answer.append(c);
                }
            } else {
                if (c >= 'A' && c <= 'Z') {
                    answer.append(Character.toLowerCase(c));
                } else {
                    answer.append(c);
                }
            }
        }
        return answer.toString();
    }
}
