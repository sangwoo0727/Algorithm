import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
  private int N, K;
  private int[][] dp;
  private int[] caffeines;
  private static Solution solution;

  public static Solution getInstance() {
    if (solution == null) {
      solution = new Solution();
    }
    return solution;
  }

  public void solution() throws IOException {
    this.setInput()
        .calcuCoffieCount()
        .printAnswer();
  }

  private void printAnswer() {
    int answer = Integer.MAX_VALUE;
    for (int i = 1; i <= N; i++) {
      answer = Math.min(answer, dp[i][K]);
    }
    System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
  }

  private Solution calcuCoffieCount() {
    for (int i = 1; i <= N; i++) {
      dp[i][0] = 0;
      if (caffeines[i] <= K) {
        dp[i][caffeines[i]] = 1;
      }
      for (int j = 1; j <= K; j++) {
        if (dp[i - 1][j] != Integer.MAX_VALUE) {
          if (j + caffeines[i] <= K) {
            dp[i][j + caffeines[i]] = Math.min(dp[i][j + caffeines[i]], dp[i - 1][j] + 1);
          }
          dp[i][j] = Math.min(dp[i][j], dp[i - 1][j]);
        }
      }
    }
    return this;
  }
  private Solution setInput() throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(input.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    caffeines = new int[N + 1];
    st = new StringTokenizer(input.readLine());
    for (int i = 1; i <= N; i++) {
      caffeines[i] = Integer.parseInt(st.nextToken());
    }
    dp = new int[N + 1][K + 1];
    for (int i = 0; i <= N; i++) {
      for (int j = 0; j <= K; j++) {
        dp[i][j] = Integer.MAX_VALUE;
      }
    }
    return this;
  }
}
public class BOJ22115_창영이와커피 {

  public static void main(String[] args) throws IOException {
    Solution.getInstance()
        .solution();
  }
}
