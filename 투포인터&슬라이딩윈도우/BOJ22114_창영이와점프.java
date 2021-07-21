import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {

  private int N, K;
  private int ans;
  private int[] dist;

  private static Solution solution;

  public static Solution getInstance() {
    if (solution == null) {
      solution = new Solution();
    }
    return solution;
  }

  public void solution() throws IOException {
    this.setInput()
        .calculateDist()
        .printAnswer();
  }

  private void printAnswer() {
    System.out.println(ans);
  }

  private Solution calculateDist() {
    int jump = 1;
    int jumpIdx = -1;
    for (int l = 0, r = 0; l < N - 1; l++) {
      if (jumpIdx < l) {
        jump = 1;
      }
      while (r < N - 1 && (jump > 0 || dist[r] <= K)) {
        if (dist[r] > K) {
          jumpIdx = r;
          jump--;
        }
        r++;
      }
      ans = Math.max(ans, r - l + 1);
    }
    return this;
  }

  private Solution setInput() throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(input.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    dist = new int[N];
    st = new StringTokenizer(input.readLine());
    for (int i = 0; i < N - 1; i++) {
      dist[i] = Integer.parseInt(st.nextToken());
    }
    return this;
  }
}

public class BOJ22114_창영이와점프 {

  public static void main(String[] args) throws IOException {
    Solution.getInstance()
        .solution();
  }
}
