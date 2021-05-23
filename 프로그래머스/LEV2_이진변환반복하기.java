import java.util.stream.Collectors;

public class LEV2_이진변환반복하기 {
    public static int[] solution(String s) {
        int cnt = 0;
        int deleteZero = 0;
        while (!"1".equals(s)) {
            cnt++;
            String next = s.chars().filter(c -> c != '0')
                    .mapToObj(c -> (char) c)
                    .map(Object::toString)
                    .collect(Collectors.joining());
            deleteZero += s.length() - next.length();
            int digit = next.length();
            s = Integer.toBinaryString(digit);
        }
        return new int[] {cnt, deleteZero};
    }

    public static void main(String[] args) {
        solution("110010101001");
    }
}
