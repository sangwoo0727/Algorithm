import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
  private long max;
  private int N;
  private int[][] schedules;
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
        .calculate()
        .printAnswer();
  }

  private void printAnswer() {
    System.out.println(max);
  }

  private Solution calculate() {
    dp[1] = 0;
    for (int i = 1; i <= N + 1; i++) {
      max = Math.max(max, dp[i]);
      dp[i + schedules[0][i]] = Math.max(max + schedules[1][i], dp[i + schedules[0][i]]);
    }
    return this;
  }

  private Solution setInput() throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(input.readLine());
    schedules = new int[2][N + 100];
    dp = new long[N + 100];
    for (int i = 1; i <= N; i++) {
      StringTokenizer st = new StringTokenizer(input.readLine());
      int day = Integer.parseInt(st.nextToken());
      int profit = Integer.parseInt(st.nextToken());
      schedules[0][i] = day;
      schedules[1][i] = profit;
    }
    return this;
  }
}

public class BOJ15486_퇴사2 {

  public static void main(String[] args) throws IOException {
    Solution.getInstance()
        .process();
  }
}
