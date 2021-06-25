import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {

  private int N;
  private String answer;
  private static final int[] candidates = {1, 2, 3};
  private static Solution solution;

  public static Solution getInstance() {
    if (solution == null) {
      solution = new Solution();
    }
    return solution;
  }

  public void process() throws IOException {
    this.setInput()
        .recFunc(0, "")
        .printAnswer();
  }

  private void printAnswer() {
    System.out.println(answer);
  }

  private Solution recFunc(int k, String now) {
    if (k == N) {
      answer = now;
      return this;
    }

    for (int i = 0; i < 3; i++) {
      if (canUseCandidate(now + candidates[i])) {
        recFunc(k + 1, now + candidates[i]);
        if (answer != null) {
          break;
        }
      }
    }
    return this;
  }

  private boolean canUseCandidate(String checkString) {
    for (int i = checkString.length() - 1; i >= 0; i--) {
      String part1 = checkString.substring(i);
      int size = part1.length();
      if (i - size < 0) {
        break;
      }
      String part2 = checkString.substring(i - size, i);
      if (part1.equals(part2)) {
        return false;
      }
    }
    return true;
  }

  private Solution setInput() throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(input.readLine());
    return this;
  }
}

public class BOJ2661_좋은수열 {

  public static void main(String[] args) throws IOException {
    Solution.getInstance()
        .process();
  }
}
