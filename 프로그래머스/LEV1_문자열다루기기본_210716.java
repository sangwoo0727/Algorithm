class Solution {
  public boolean solution(String s) {
    if (s.length() == 4 || s.length() == 6) {
      for (char c : s.toCharArray()) {
        if (!Character.isDigit(c)) {
          return false;
        }
      }
      return true;
    }
    return false;
  }
}

public class LEV1_문자열다루기기본_210716 {

}
