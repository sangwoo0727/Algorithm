public class LEV2_가장큰정사각형찾기 {

  private int N, M;

  public int solution(int[][] board) {
    return this.setValue(board)
        .solve(board);
  }

  private LEV2_가장큰정사각형찾기 setValue(int[][] board) {
    this.N = board.length;
    this.M = board[0].length;
    return this;
  }

  private int solve(int[][] board) {
    int answer = 0;
    for (int i = 0; i < N; i++) {
      if (board[i][0] == 1) {
        answer = 1;
      }
    }
    for (int j = 0; j < M; j++) {
      if (board[0][j] == 1) {
        answer = 1;
      }
    }
    for (int i = 1; i < N; i++) {
      for (int j = 1; j < M; j++) {
        board[i][j] = Math.min(board[i - 1][j - 1], Math.min(board[i - 1][j], board[i][j - 1])) + 1;
        answer = Math.max(answer, board[i][j]);
      }
    }
    return answer * answer;
  }
}
