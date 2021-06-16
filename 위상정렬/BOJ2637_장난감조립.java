import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Solve {

  private int N, M;
  private int[][] blocks;
  private int[] indegree;

  private List<List<Node>> adj;

  private static Solve solve;

  public static Solve getInstance() {
    if (solve == null) {
      solve = new Solve();
    }
    return solve;
  }

  public void process() throws IOException {
    this.setInput()
        .buildRobot()
        .printAnswer();
  }

  private void printAnswer() {
    StringBuilder output = new StringBuilder();
    for (int i = 1; i <= N; i++) {
      if (blocks[N][i] != 0) {
        output.append(i).append(" ").append(blocks[N][i]).append("\n");
      }
    }
    System.out.println(output);
  }

  private Solve buildRobot() {
    Queue<Integer> q = new LinkedList<>();
    for (int i = 1; i <= N; i++) {
      if (indegree[i] == 0) {
        blocks[i][i] = 1;
        q.add(i);
      }
    }
    while (!q.isEmpty()) {
      int now = q.poll();
      for (Node nn : adj.get(now)) {
        for (int i = 1; i <= N; i++) {
          blocks[nn.n][i] += blocks[now][i] * nn.w;
        }
        indegree[nn.n]--;
        if (indegree[nn.n] == 0) {
          q.add(nn.n);
        }
      }
    }
    return this;
  }

  private Solve setInput() throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(input.readLine());
    M = Integer.parseInt(input.readLine());
    adj = new ArrayList<>();
    indegree = new int[N + 1];
    blocks = new int[N + 1][N + 1];
    for (int i = 0; i <= N; i++) {
      adj.add(new ArrayList<>());
    }
    for (int i = 0; i < M; i++) {
      StringTokenizer st = new StringTokenizer(input.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());
      adj.get(y).add(new Node(x, k));
      indegree[x]++;
    }
    return this;
  }
}

class Node {

  int n, w;

  public Node(int n, int w) {
    this.n = n;
    this.w = w;
  }
}

public class BOJ2637_장난감조립 {

  public static void main(String[] args) throws IOException {
    Solve.getInstance()
        .process();
  }
}
