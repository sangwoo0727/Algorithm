import java.util.LinkedList;
import java.util.Queue;

public class LEV2_게임맵최단거리 {

  private int N, M;
  private int[][] dist;
  private final int[][] dir = {{-1, 1, 0, 0}, {0, 0, 1, -1}};

  public int solution(int[][] maps) {
    return this.init(maps)
        .process(maps)
        .getAnswer();
  }

  private int getAnswer() {
    return dist[N - 1][M - 1] == 0 ? -1 : dist[N - 1][M - 1];
  }

  private LEV2_게임맵최단거리 process(int[][] maps) {
    Queue<Node> q = new LinkedList<>();
    q.add(new Node(0, 0, 1));
    dist[0][0] = 1;
    while (!q.isEmpty()) {
      Node now = q.poll();
      for (int k = 0; k < 4; k++) {
        int nn = now.n + dir[0][k];
        int nm = now.m + dir[1][k];
        if (!inner(nn, nm, maps)) {
          continue;
        }
        if (dist[nn][nm] == 0 || dist[nn][nm] > now.d + 1) {
          dist[nn][nm] = now.d + 1;
          q.add(new Node(nn, nm, now.d + 1));
        }
      }
    }
    return this;
  }

  private boolean inner(int n, int m, int[][] maps) {
    return 0 <= n && n < N && 0 <= m && m < M && maps[n][m] == 1;
  }

  private LEV2_게임맵최단거리 init(int[][] maps) {
    this.N = maps.length;
    this.M = maps[0].length;
    dist = new int[N][M];
    return this;
  }
}

class Node {

  int n, m, d;

  Node(int n, int m, int d) {
    this.n = n;
    this.m = m;
    this.d = d;
  }
}
