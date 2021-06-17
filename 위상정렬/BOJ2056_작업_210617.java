import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Solve {

  private int N;
  private int[] time;
  private int[] weight;
  private int[] indegree;
  private List<List<Integer>> adj;
  private static Solve solve;

  public static Solve getInstance() {
    if (solve == null) {
      solve = new Solve();
    }
    return solve;
  }

  public void process() throws IOException {
    this.setInput()
        .doTask()
        .printAnswer();
  }

  private void printAnswer() {
    int answer = 0;
    for (int w : weight) {
      answer = Math.max(answer, w);
    }
    System.out.println(answer);
  }

  private Solve doTask() {
    Queue<Integer> q = new LinkedList<>();
    for (int i = 1; i <= N; i++) {
      if (indegree[i] == 0) {
        q.add(i);
      }
    }

    while (!q.isEmpty()) {
      int now = q.poll();
      weight[now] += time[now];
      for (int nn : adj.get(now)) {
        indegree[nn]--;
        weight[nn] = Math.max(weight[nn], weight[now]);
        if (indegree[nn] == 0) {
          q.add(nn);
        }
      }
    }
    return this;
  }

  private Solve setInput() throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(input.readLine());
    time = new int[N + 1];
    weight = new int[N + 1];
    indegree = new int[N + 1];
    adj = new ArrayList<>();
    for (int i = 0; i <= N; i++) {
      adj.add(new ArrayList<>());
    }
    for (int i = 1; i <= N; i++) {
      StringTokenizer st = new StringTokenizer(input.readLine());
      int w = Integer.parseInt(st.nextToken());
      time[i] = w;
      int m = Integer.parseInt(st.nextToken());
      for (int k = 0; k < m; k++) {
        int nn = Integer.parseInt(st.nextToken());
        adj.get(nn).add(i);
        indegree[i]++;
      }
    }
    return this;
  }
}

public class BOJ2056_작업_210617 {

  public static void main(String[] args) throws IOException {
    Solve.getInstance().process();
  }

}
