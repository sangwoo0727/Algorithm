import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Pair {

  public int n, w;

  Pair(int n, int w) {
    this.n = n;
    this.w = w;
  }
}

class Solution {

  private Pair max;
  private int N;
  private boolean[] visit;
  private List<List<Pair>> adj;
  private static Solution solution;

  public static Solution getInstance() {
    if (solution == null) {
      solution = new Solution();
    }
    return solution;
  }

  public void process() throws IOException {
    this.setInput()
        .searchTree()
        .printAnswer();
  }

  private void printAnswer() {
    System.out.println(max.w);
  }

  private Solution searchTree() {
    max = new Pair(1, 0);
    dfs(1, 0);
    visit = new boolean[N + 1];
    int startNode = max.n;
    max = new Pair(startNode, 0);
    dfs(startNode, 0);
    return this;
  }

  private void dfs(int now, int weight) {
    visit[now] = true;
    for (Pair pair : adj.get(now)) {
      if (!visit[pair.n]) {
        updateMax(pair.n, weight + pair.w);
        dfs(pair.n, weight + pair.w);
      }
    }
  }

  private void updateMax(int n, int w) {
    if (max.w <= w) {
      max.n = n;
      max.w = w;
    }
  }

  private Solution setInput() throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(input.readLine());
    visit = new boolean[N + 1];
    adj = new ArrayList<>();
    for (int i = 0; i <= N; i++) {
      adj.add(new ArrayList<>());
    }

    for (int i = 0; i < N - 1; i++) {
      StringTokenizer st = new StringTokenizer(input.readLine());
      int p = Integer.parseInt(st.nextToken());
      int s = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());
      adj.get(p).add(new Pair(s, w));
      adj.get(s).add(new Pair(p, w));
    }

    return this;
  }
}

public class BOJ1967_트리의지름 {

  public static void main(String[] args) throws IOException {
    Solution.getInstance()
        .process();
  }
}
