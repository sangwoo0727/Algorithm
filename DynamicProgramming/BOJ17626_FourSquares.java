import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {

  private int[] dp;
  private int N;
  private static Solution solution;

  public static Solution getInstance() {
    if (solution == null) {
      solution = new Solution();
    }
    return solution;
  }

  public void process() throws IOException {
    this.setInput()
        .programming()
        .getAnswer();
  }

  private void getAnswer() {
    System.out.println(dp[N]);
  }

  private Solution programming() {
    dp = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      int m = (int) Math.floor(Math.sqrt(i));
      dp[i] = Integer.MAX_VALUE;
      for (int k = m; k >= 1; k--) {
        dp[i] = Math.min(dp[i], dp[(int) (i - Math.pow(k, 2))] + 1);
      }
    }
    return this;
  }

  private Solution setInput() throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(input.readLine());
    return this;
  }
}

public class BOJ17626_FourSquares {

  public static void main(String[] args) throws IOException {
    Solution.getInstance()
        .process();
  }
}
