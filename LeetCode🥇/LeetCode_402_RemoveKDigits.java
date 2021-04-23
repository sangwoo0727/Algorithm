import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LeetCode_402_RemoveKDigits {
    public static String removeKdigits(String num, int k) {
        Deque<Character> dq = new ArrayDeque<>();
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            while (k > 0 && dq.size() > 0 && dq.peekLast() > c) {
                dq.pollLast();
                k--;
            }
            dq.addLast(c);
        }
        while (k-- > 0) {
            dq.pollLast();
        }
        StringBuilder output = new StringBuilder();
        boolean flag = false;
        while (dq.size() > 0) {
            if (!flag && dq.peekFirst() == '0') {
                dq.pollFirst();
            } else {
                output.append(dq.pollFirst());
                flag = true;
            }
        }
        return output.length() == 0 ? "0" : output.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeKdigits("112", 1));

    }
}
