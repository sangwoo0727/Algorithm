import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {

  private int N, M;
  private int[][] board;
  private static Solution solution;

  public static Solution getInstance() {
    if (solution == null) {
      solution = new Solution();
    }
    return solution;
  }

  public void solution() throws IOException {
    this.setInput()
        .findWall();
  }

  private void findWall() {
    int[] dist = new int[N * M + 1];
    int[][] dir = {{-1, 1, 0, 0}, {0, 0, -1, 1}};
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        dist[M * i + j + 1] = Integer.MAX_VALUE;
      }
    }
    Queue<Node> q = new LinkedList<>();
    q.add(new Node(0, 0, 0));
    dist[1] = 0;
    while (!q.isEmpty()) {
      Node now = q.poll();
      if (now.weight > dist[M * now.n + now.m + 1]) {
        continue;
      }
      for (int k = 0; k < 4; k++) {
        int nn = now.n + dir[0][k];
        int nm = now.m + dir[1][k];
        if (inner(nn, nm)) {
          if (board[nn][nm] == 0) {
            if (now.weight < dist[M * nn + nm + 1]) {
              dist[M * nn + nm + 1] = now.weight;
              q.add(new Node(nn, nm, now.weight));
            }
          } else {
            if (now.weight + 1 < dist[M * nn + nm + 1]) {
              dist[M * nn + nm + 1] = now.weight + 1;
              q.add(new Node(nn, nm, now.weight + 1));
            }
          }
        }
      }
    }
    System.out.println(dist[M * (N - 1) + (M - 1) + 1]);
  }

  private boolean inner(int n, int m) {
    return 0 <= n && n < N && 0 <= m && m < M;
  }

  private Solution setInput() throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(input.readLine());
    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    board = new int[N][M];
    for (int i = 0; i < N; i++) {
      String line = input.readLine();
      for (int j = 0; j < line.length(); j++) {
        board[i][j] = line.charAt(j) - '0';
      }
    }
    return this;
  }
}

class Node {

  int n, m, weight;

  Node(int n, int m, int weight) {
    this.n = n;
    this.m = m;
    this.weight = weight;
  }
}

public class BOJ1261_알고스팟 {

  public static void main(String[] args) throws IOException {
    Solution.getInstance()
        .solution();
  }
}
