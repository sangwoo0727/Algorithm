import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {

  private static Solution solution;

  public static Solution getInstance() {
    if (solution == null) {
      solution = new Solution();
    }
    return solution;
  }

  public void process() throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    Deque<Character> dq;
    StringBuilder output = new StringBuilder();
    while (true) {
      String line = input.readLine();
      if (".".equals(line)) {
        break;
      }
      dq = new ArrayDeque<>();
      boolean flag = false;
      for (char word : line.toCharArray()) {
        if (word == '[' || word == '(') {
          dq.addLast(word);
        } else if (word == ']' || word == ')') {
          if (dq.isEmpty()) {
            flag = true;
            break;
          }
          if (word == ']') {
            if (dq.peekLast() != '[') {
              flag = true;
              break;
            }
          } else {
            if (dq.peekLast() != '(') {
              flag = true;
              break;
            }
          }
          dq.pollLast();
        }
      }
      if (flag || !dq.isEmpty()) {
        output.append("no").append("\n");
      } else {
        output.append("yes").append("\n");
      }
    }
    System.out.println(output);
  }
}
public class BOJ4949_균형잡힌세상 {

  public static void main(String[] args) throws IOException {
    Solution.getInstance()
        .process();
  }
}
