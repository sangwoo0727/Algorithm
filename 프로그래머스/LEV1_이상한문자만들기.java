import java.util.*;

public class LEV1_이상한문자만들기 {
    public String solution(String s) {
        int idx = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                idx = 0;
            } else {
                chars[i] = idx++ % 2 == 0 ?
                        Character.toUpperCase(chars[i]) :
                        Character.toLowerCase(chars[i]);
            }
        }
        return String.valueOf(chars);
    }
}
