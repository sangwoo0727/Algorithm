import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {

  private int N;
  private long[] dp;
  private static Solution solution;

  public static Solution getInstance() {
    if (solution == null) {
      solution = new Solution();
    }
    return solution;
  }

  public void process() throws IOException {
    this.setInput()
        .solveThisProblem()
        .getAnswer();
  }

  private void getAnswer() {
    System.out.println(dp[N]);
  }

  private Solution solveThisProblem() {
    for (int i = 0; i <= N; i++) {
      if (i == 0) {
        dp[i] = 1;
        continue;
      }
      for (int j = 0; j < i; j++) {
        dp[i] += (dp[j] * dp[i - j - 1]);
      }
    }
    return this;
  }

  private Solution setInput() throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(input.readLine());
    dp = new long[N + 1];
    return this;
  }
}

public class BOJ13699_점화식 {

  public static void main(String[] args) throws IOException {
    Solution.getInstance()
        .process();
  }
}
