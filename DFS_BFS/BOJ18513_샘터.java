import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {

  private Map<Integer, Boolean> isUsed;
  private int N, K;
  private long total;
  private static int[] d = {-1, 1};
  private Queue<Pair> q = new LinkedList<>();
  private static Solution solution;

  public static Solution getInstance() {
    if (solution == null) {
      solution = new Solution();
    }
    return solution;
  }

  public void process() throws IOException {
    this.setInput()
        .calcu()
        .printAnswer();
  }

  private void printAnswer() {
    System.out.println(total);
  }

  private Solution calcu() {
    int cnt = 0;
    while (!q.isEmpty()) {
      Pair now = q.poll();
      total += now.dist;
      for (int i = 0; i < 2; i++) {
        int nn = now.now + d[i];
        if (!isUsed.containsKey(nn) && cnt < K) {
          isUsed.put(nn, true);
          q.add(new Pair(nn, now.dist + 1));
          cnt++;
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
    isUsed = new HashMap<>();
    st = new StringTokenizer(input.readLine());
    for (int i = 0; i < N; i++) {
      int n = Integer.parseInt(st.nextToken());
      q.add(new Pair(n, 0));
      isUsed.put(n, true);
    }
    return this;
  }
}

class Pair {

  int now, dist;

  Pair(int now, int dist) {
    this.now = now;
    this.dist = dist;
  }

}

public class BOJ18513_샘터 {

  public static void main(String[] args) throws IOException {
    Solution.getInstance()
        .process();
  }
}
