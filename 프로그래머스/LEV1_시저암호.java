public class LEV1_시저암호 {
    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();
        n %= 26;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                answer.append(" ");
            } else if (Character.isLowerCase(c)) {
                answer.append((char) ((c - 'a' + n) % 26 + 'a'));
            } else if (Character.isUpperCase(c)) {
                answer.append((char) ((c - 'A' + n) % 26 + 'A'));
            }
        }
        return answer.toString();
    }
}
