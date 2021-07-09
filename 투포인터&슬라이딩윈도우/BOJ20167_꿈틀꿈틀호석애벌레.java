import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Pair {

  int left;
  int satisfy;

  public Pair(int left, int satisfy) {
    this.left = left;
    this.satisfy = satisfy;
  }
}

class Solution {

  private int N, K;
  private int[] dp;
  private int[] nums;
  private Pair[] satisfies;
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
      if (satisfies[r] != null) {
        dp[r] = Math.max(dp[r], dp[satisfies[r].left - 1] + satisfies[r].satisfy);
      }
    }
    return this;
  }

  private Solution preprocess() {
    int sum = 0;
    for (int l = 1, r = 0; l <= N; l++) {
      while (r + 1 <= N && sum < K) {
        sum += nums[++r];
      }
      if (sum >= K) {
        if (satisfies[r] == null || satisfies[r].satisfy <= sum - K) {
          satisfies[r] = new Pair(l, sum - K);
        }
      }
      sum -= nums[l];
    }
    return this;
  }

  private Solution setInput() throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(input.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    nums = new int[N + 1];
    satisfies = new Pair[N + 1];
    dp = new int[N + 1];
    st = new StringTokenizer(input.readLine());
    for (int i = 1; i <= N; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
    }
    return this;
  }
}

public class BOJ20167_꿈틀꿈틀호석애벌레 {

  public static void main(String[] args) throws IOException {
    Solution.getInstance()
        .process();
  }
}
