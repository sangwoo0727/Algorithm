import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

  private int ans;
  private int S;
  private boolean[][] visit;
  private static Solution solution;

  public static Solution getInstance() {
    if (solution == null) {
      solution = new Solution();
    }
    return solution;
  }

  private Solution() {
  }

  public void solve() throws IOException {
    this.setInput()
        .calculate()
        .print();
  }

  private Solution calculate() {
    Queue<Node> q = new LinkedList<>();
    q.add(new Node(1, 0, 0));
    visit[1][0] = true;
    while (!q.isEmpty()) {
      Node now = q.poll();

      if (now.num == S) {
        ans = now.time;
        break;
      }
      if (0 < now.num && now.num <= 2000) {
        if (!visit[now.num][now.num]) {
          visit[now.num][now.num] = true;
          q.add(new Node(now.num, now.time + 1, now.num));
        }
        if (!visit[now.num - 1][now.clip]) {
          visit[now.num - 1][now.num] = true;
          q.add(new Node(now.num - 1, now.time + 1, now.clip));
        }
      }
      if (0 < now.clip && now.num + now.clip <= 2000) {
        if (!visit[now.num + now.clip][now.clip]) {
          visit[now.num + now.clip][now.clip] = true;
          q.add(new Node(now.num + now.clip, now.time + 1, now.clip));
        }
      }
    }
    return this;
  }

  private void print() {
    System.out.println(ans);
  }

  private Solution setInput() throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    S = Integer.parseInt(input.readLine());
    visit = new boolean[2001][2001];
    return this;
  }
}

class Node {
  int num;
  int time;
  int clip;

  public Node(int num, int time, int clip) {
    this.num = num;
    this.time = time;
    this.clip = clip;
  }
}

public class BOJ14226_이모티콘 {

  public static void main(String[] args) throws IOException {
    Solution.getInstance()
        .solve();
  }
}
