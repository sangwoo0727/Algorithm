import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Pair {

  int left;
  long satisfy;

  Pair(int left, long satisfy) {
    this.left = left;
    this.satisfy = satisfy;
  }
}

class Solution {

  private int N, K;
  private long[] dp;
  private Pair[] pairs;
  private int[] eats;
  private static Solution solution;

  public static Solution getInstance() {
    if (solution == null) {
      solution = new Solution();
    }
    return solution;
  }

  public void process() throws IOException {
    this.setInput()
        .preprocess()
        .calcu()
        .printAnswer();
  }

  private void printAnswer() {
    System.out.println(dp[N]);
  }

  private Solution calcu() {
    for (int r = 1; r <= N; r++) {
      dp[r] = dp[r - 1];
      if (pairs[r] == null) {
        continue;
      }
      dp[r] = Math.max(dp[r], dp[pairs[r].left - 1] + pairs[r].satisfy);
    }
    return this;
  }

  private Solution preprocess() {
    long sum = 0;
    for (int l = 1, r = 0; l <= N; l++) {
      while (r + 1 <= N && sum < K) {
        sum += eats[++r];
      }
      if (sum >= K) {
        if (pairs[r] != null && pairs[r].satisfy <= sum - K) {
          pairs[r] = new Pair(l, sum - K);
        } else if (pairs[r] == null) {
          pairs[r] = new Pair(l, sum - K);
        }
      }
      sum -= eats[l];
    }
    return this;
  }

  private Solution setInput() throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(input.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    eats = new int[N + 1];
    pairs = new Pair[N + 1];
    dp = new long[N + 1];
    st = new StringTokenizer(input.readLine());
    for (int i = 1; i <= N; i++) {
      eats[i] = Integer.parseInt(st.nextToken());
    }
    return this;
  }
}

public class BOJ20181_꿈틀꿈틀호석애벌레 {

  public static void main(String[] args) throws IOException {
    Solution.getInstance()
        .process();
  }
}
