import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {

  private int N, ans;
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
        .findMinHeight()
        .printAnswer();
  }

  private void printAnswer() {
    System.out.println(ans);
  }

  private Solution findMinHeight() {
    int l = 0, r = 1000000001;
    while (l <= r) {
      int m = (l + r) / 2;
      if (canRide(m)) {
        ans = m;
        r = m - 1;
      } else {
        l = m + 1;
      }
    }
    return this;
  }

  private boolean canRide(int h) {
    boolean[][] visit = new boolean[N][N];
    int[][] dir = {{-1, 1, 0, 0}, {0, 0, -1, 1}};
    Queue<Pair> q = new LinkedList<>();
    visit[0][0] = true;
    q.add(new Pair(0, 0));
    while (!q.isEmpty()) {
      Pair now = q.poll();
      if (now.n == N - 1 && now.m == N - 1) {
        return true;
      }
      for (int k = 0; k < 4; k++) {
        int nn = now.n + dir[0][k];
        int nm = now.m + dir[1][k];
        if (inner(nn, nm) && notVisit(nn, nm, visit) && inHeightRange(now, nn, nm, h)) {
          visit[nn][nm] = true;
          q.add(new Pair(nn, nm));
        }
      }
    }
    return false;
  }

  private boolean inHeightRange(Pair now, int n, int m, int height) {
    return Math.abs(board[n][m] - board[now.n][now.m]) <= height;
  }

  private boolean notVisit(int n, int m, boolean[][] visit) {
    return !visit[n][m];
  }

  private boolean inner(int n, int m) {
    return 0 <= n && n < N && 0 <= m && m < N;
  }

  private Solution setInput() throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(input.readLine());
    board = new int[N][N];
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(input.readLine());
      for (int j = 0; j < N; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    return this;
  }
}

class Pair {

  public int n, m;

  public Pair(int n, int m) {
    this.n = n;
    this.m = m;
  }
}

public class BOJ22116_창영이와퇴근 {

  public static void main(String[] args) throws IOException {
    Solution.getInstance()
        .solution();
  }
}
