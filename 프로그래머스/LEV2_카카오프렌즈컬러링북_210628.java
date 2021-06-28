import java.util.*;

class Solution {

  private boolean[][] visit;
  private final int[][] dir = {{-1, 1, 0, 0}, {0, 0, -1, 1}};

  public int[] solution(int m, int n, int[][] picture) {
    int numberOfArea = 0;
    int maxSizeOfOneArea = 0;
    visit = new boolean[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (picture[i][j] != 0 && !visit[i][j]) {
          maxSizeOfOneArea = bfs(i, j, maxSizeOfOneArea, m, n, picture);
          numberOfArea++;
        }
      }
    }
    int[] answer = new int[2];
    answer[0] = numberOfArea;
    answer[1] = maxSizeOfOneArea;
    return answer;
  }

  private int bfs(int sn, int sm, int maxSize, int N, int M, int[][] picture) {
    int size = 0;
    Queue<Pair> q = new LinkedList<>();
    q.add(new Pair(sn, sm));
    visit[sn][sm] = true;
    size++;
    while (!q.isEmpty()) {
      Pair now = q.poll();
      for (int k = 0; k < 4; k++) {
        int nn = now.n + dir[0][k];
        int nm = now.m + dir[1][k];
        if (inner(N, M, nn, nm) && picture[now.n][now.m] == picture[nn][nm]) {
          visit[nn][nm] = true;
          size++;
          q.add(new Pair(nn, nm));
        }
      }
    }
    maxSize = Math.max(maxSize, size);
    return maxSize;
  }

  private boolean inner(int N, int M, int n, int m) {
    return 0 <= n && n < N && 0 <= m && m < M && !visit[n][m];
  }
}

class Pair {

  int n, m;

  public Pair(int n, int m) {
    this.n = n;
    this.m = m;
  }
}

public class LEV2_카카오프렌즈컬러링북_210628 {

  public static void main(String[] args) {

  }
}
