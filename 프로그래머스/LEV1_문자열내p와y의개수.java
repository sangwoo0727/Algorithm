public class LEV1_문자열내p와y의개수 {
    boolean solution(String s) {
        s = s.toLowerCase();
        return s.chars().filter(c -> c == 'p').count() ==
                s.chars().filter(c -> c == 'y').count();
    }
}
