import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {

  private int N, S, M;
  private int[] volumes;
  private boolean[][] dp;
  private static Solution solution;

  public static Solution getInstance() {
    if (solution == null) {
      solution = new Solution();
    }
    return solution;
  }

  public void process() throws IOException {
    this.setInput()
        .processing()
        .printAnswer();
  }

  private void printAnswer() {
    int answer = -1;
    for (int m = M; m >= 0; m--) {
      if (dp[N][m]) {
        answer = m;
        break;
      }
    }
    System.out.println(answer);
  }

  private Solution processing() {
    dp[0][S] = true;
    for (int n = 1; n <= N; n++) {
      for (int m = 0; m <= M; m++) {
        if (!dp[n - 1][m]) {
          continue;
        }
        if (m + volumes[n] <= M) {
          dp[n][m + volumes[n]] = true;
        }
        if (m - volumes[n] >= 0) {
          dp[n][m - volumes[n]] = true;
        }
      }
    }
    return this;
  }

  private Solution setInput() throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(input.readLine());
    N = Integer.parseInt(st.nextToken());
    S = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    dp = new boolean[N + 1][M + 1];
    volumes = new int[N + 1];
    st = new StringTokenizer(input.readLine());
    for (int i = 1; i <= N; i++) {
      volumes[i] = Integer.parseInt(st.nextToken());
    }
    return this;
  }
}

public class BOJ1495_기타리스트 {

  public static void main(String[] args) throws IOException {
    Solution.getInstance()
        .process();
  }
}
