public class LEV1_문자열다루기기본 {
    public boolean solution(String s) {
        return (s.length() == 4 || s.length() == 6) &&
                s.chars().filter(p -> '0' <= p && p <= '9').count() == s.length();
    }
}
