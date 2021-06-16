import java.util.ArrayDeque;
import java.util.Deque;

public class LEV2_괄호회전하기 {

  public int solution(String s) {
    int answer = process(s);
    return answer;
  }

  private int process(String s) {
    if (checkInvalidLength(s.length())) {
      return 0;
    }
    int count = 0;
    StringBuilder sb = new StringBuilder(s);
    for (int i = 0; i < s.length(); i++) {
      sb.append(sb.charAt(0));
      sb.deleteCharAt(0);
      if (isValidString(sb.toString())) {
        count++;
      }
    }
    return count;
  }

  private boolean isValidString(String s) {
    Deque<Character> stack = new ArrayDeque<>();
    for (char c : s.toCharArray()) {
      if (isLeftParenthesis(c)) {
        stack.addLast(c);
        continue;
      }
      if (checkIsInvalidParenthesis(stack, c)) {
        return false;
      }
    }
    return true;
  }

  private boolean checkIsInvalidParenthesis(Deque<Character> stack, char c) {
    if (stack.isEmpty()) {
      return true;
    }
    return !isMatch(stack.pollLast(), c);
  }

  private boolean isMatch(char top, char c) {
    if (top == '[' && c == ']') {
      return true;
    }
    if (top == '{' && c == '}') {
      return true;
    }
    if (top == '(' && c == ')') {
      return true;
    }
    return false;
  }

  private boolean isLeftParenthesis(char c) {
    return c == '{' || c == '[' || c == '(';
  }

  private boolean checkInvalidLength(int length) {
    return length % 2 == 1;
  }
}
