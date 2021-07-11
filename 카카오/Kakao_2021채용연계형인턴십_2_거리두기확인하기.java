import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

  private char[][] board;
  private boolean[][] visit;

  public int[] solution(String[][] places) {
    List<Integer> answer = new ArrayList<>();
    for (String[] place : places) {
      board = new char[5][5];
      for (int i = 0; i < 5; i++) {
        board[i] = place[i].toCharArray();
      }
      boolean flag = false;
      label:
      for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
          if (board[i][j] == 'P') {
            visit = new boolean[5][5];
            if (isBreakRule(i, j)) {
              flag = true;
              break label;
            }
          }
        }
      }
      answer.add(flag ? 0 : 1);
    }
    return answer.stream().mapToInt(Integer::intValue).toArray();
  }

  private boolean isBreakRule(int x, int y) {
    Queue<Node> q = new LinkedList<>();
    visit[x][y] = true;
    q.add(new Node(x, y, 0, false));
    int[][] dir = {{-1, 1, 0, 0}, {0, 0, -1, 1}};
    while (!q.isEmpty()) {
      Node node = q.poll();
      if (node.dist == 2) {
        break;
      }
      for (int k = 0; k < 4; k++) {
        int nn = node.n + dir[0][k];
        int nm = node.m + dir[1][k];
        if (inner(nn, nm)) {
          visit[nn][nm] = true;
          if (board[nn][nm] == 'O') {
            q.add(new Node(nn, nm, node.dist + 1, node.isPartition));
          } else if (board[nn][nm] == 'X') {
            q.add(new Node(nn, nm, node.dist + 1, true));
          } else if (board[nn][nm] == 'P') {
            if (node.isPartition) {
              q.add(new Node(nn, nm, node.dist + 1, true));
            } else {
              return true;
            }
          }
        }
      }
    }
    return false;
  }

  private boolean inner(int n, int m) {
    return 0 <= n && n < 5 && 0 <= m && m < 5 && !visit[n][m];
  }
}

class Node {

  int n, m, dist;
  boolean isPartition;

  Node(int n, int m, int dist, boolean isPartition) {
    this.n = n;
    this.m = m;
    this.dist = dist;
    this.isPartition = isPartition;
  }
}

public class Kakao_2021채용연계형인턴십_2_거리두기확인하기 {
}
