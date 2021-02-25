public class LEV1_핸드폰번호가리기 {
    public String solution(String phone_number) {
        StringBuilder answer = new StringBuilder();
        for (int i = phone_number.length() - 1; i >= 0; i--) {
            if (i >= phone_number.length() - 4) {
                answer.append(phone_number.charAt(i));
            } else {
                answer.append("*");
            }
        }
        return answer.reverse().toString();
    }
}
