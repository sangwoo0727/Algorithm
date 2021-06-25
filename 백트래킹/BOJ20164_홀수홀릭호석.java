import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {

  private int min = Integer.MAX_VALUE;
  private int max = 0;

  private static String N;
  private static Solution solution;

  public static Solution getInstance() {
    if (solution == null) {
      solution = new Solution();
    }
    return solution;
  }

  public void process() throws IOException {
    this.setInput()
        .dfs(N, 0)
        .printAnswer();
  }

  private void printAnswer() {
    System.out.println(min + " " + max);
  }

  private Solution dfs(String n, int count) {
    if (n.length() == 1) {
      count += findOdd(n);
      min = Math.min(min, count);
      max = Math.max(max, count);
      return this;
    }
    count += findOdd(n);
    if (n.length() == 2) {
      String newN = makeNewStringFromTwoLength(n);
      dfs(newN, count);
    } else {
      for (int i = 0; i <= n.length() - 3; i++) {
        for (int j = i + 1; j <= n.length() - 2; j++) {
          String new1 = n.substring(0, i + 1);
          String new2 = n.substring(i + 1, j + 1);
          String new3 = n.substring(j + 1, n.length());

          String newN = Integer
              .toString(Integer.parseInt(new1) + Integer.parseInt(new2) + Integer.parseInt(new3));
          dfs(newN, count);
        }
      }
    }
    return this;
  }

  private String makeNewStringFromTwoLength(String n) {
    return Integer
        .toString(Integer.parseInt(n.substring(0, 1)) + Integer.parseInt(n.substring(1, 2)));
  }

  private int findOdd(String n) {
    int count = 0;
    for (char c : n.toCharArray()) {
      if (Character.isDigit(c) && (c - '0') % 2 == 1) {
        count++;
      }
    }
    return count;
  }

  private Solution setInput() throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    N = input.readLine();

    return this;
  }
}

public class BOJ20164_홀수홀릭호석 {

  public static void main(String[] args) throws IOException {
    Solution.getInstance()
        .process();
  }
}
