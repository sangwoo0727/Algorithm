import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

class Solution {

  private int N, M, R;
  private int[][] board;
  private int total;
  private boolean[][] visit;
  private BufferedReader input;
  private Map<Character, int[]> dir = Map.of(
      'E', new int[]{0, 1},
      'W', new int[]{0, -1},
      'S', new int[]{1, 0},
      'N', new int[]{-1, 0}
  );

  private static Solution solution;

  public static Solution getInstance() {
    if (solution == null) {
      solution = new Solution();
    }
    return solution;
  }

  public void process() throws IOException {
    this.setInput()
        .game()
        .printAnswer();
  }

  private void printAnswer() {
    StringBuilder output = new StringBuilder();
    output.append(total).append("\n");
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        output.append(visit[i][j] ? "F" : "S").append(" ");
      }
      output.append("\n");
    }
    System.out.println(output);
  }

  private Solution game() throws IOException {
    for (int r = 1; r <= R; r++) {
      attack();
      defense();
    }
    return this;
  }

  private void defense() throws IOException {
    StringTokenizer st = new StringTokenizer(input.readLine());
    int n = Integer.parseInt(st.nextToken()) - 1;
    int m = Integer.parseInt(st.nextToken()) - 1;
    visit[n][m] = false;
  }

  private void attack() throws IOException {
    StringTokenizer st = new StringTokenizer(input.readLine());
    int n = Integer.parseInt(st.nextToken()) - 1;
    int m = Integer.parseInt(st.nextToken()) - 1;
    char d = st.nextToken().charAt(0);
    int cnt = board[n][m];
    for (int k = 0; k < N; k++) {
      int nn = n + dir.get(d)[0] * k;
      int nm = m + dir.get(d)[1] * k;
      if (cnt == 0) {
        break;
      }
      if (!inner(nn, nm) || visit[nn][nm]) {
        cnt--;
        continue;
      }
      cnt = Math.max(cnt, board[nn][nm]);
      if (cnt > 0) {
        total++;
        visit[nn][nm] = true;
        cnt--;
      }
    }
  }

  private boolean inner(int n, int m) {
    return 0 <= n && n < N && 0 <= m && m < M;
  }

  private Solution setInput() throws IOException {
    input = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(input.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    R = Integer.parseInt(st.nextToken());
    board = new int[N][M];
    visit = new boolean[N][M];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(input.readLine());
      for (int j = 0; j < M; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    return this;
  }
}

public class BOJ20165_인내의도미노장호석 {

  public static void main(String[] args) throws IOException {
    Solution.getInstance()
        .process();
  }
}
