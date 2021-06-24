import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {
  private int N, K, S;
  private StringBuilder output = new StringBuilder();
  private BufferedReader bufferedReader;
  private int[] indegree;
  private List<List<Integer>> adj;
  private boolean[][] isBefore;
  private static Solution solution;

  public static Solution getInstance() {
    if (solution == null) {
      solution = new Solution();
    }
    return solution;
  }

  public void process() throws IOException {
    this.setInput()
        .preprocess()
        .getQuery()
        .printAnswer();
  }

  private void addNewPrevious(int before, int now) {
    isBefore[now][before] = true;
    for (int i = 1; i <= N; i++) {
      isBefore[now][i] = isBefore[now][i] || isBefore[before][i];
    }
  }
  private Solution preprocess() {
    Queue<Integer> q = new LinkedList<>();
    for (int i = 1; i <= N; i++) {
      if (indegree[i] == 0) {
        q.add(i);
      }
    }

    while (!q.isEmpty()) {
      int now = q.poll();
      for (int nn : adj.get(now)) {
        indegree[nn]--;
        addNewPrevious(now, nn);
        if (indegree[nn] == 0) {
          q.add(nn);
        }
      }
    }
    return this;
  }

  private Solution getQuery() throws IOException {
    S = Integer.parseInt(bufferedReader.readLine());
    for (int s = 0; s < S; s++) {
      StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
      int before = Integer.parseInt(st.nextToken());
      int after = Integer.parseInt(st.nextToken());

      if (isBefore[before][after]) {
        output.append(1).append("\n");
      } else if (isBefore[after][before]) {
        output.append(-1).append("\n");
      } else {
        output.append(0).append("\n");
      }
    }
    return this;
  }

  private void printAnswer() {
    System.out.println(output);
  }

  private Solution setInput() throws IOException {
    bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    indegree = new int[N + 1];
    isBefore = new boolean[N + 1][N + 1];
    adj = new ArrayList<>();
    for (int i = 0; i <= N; i++) {
      adj.add(new ArrayList<>());
    }
    for (int k = 0; k < K; k++) {
      st = new StringTokenizer(bufferedReader.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      adj.get(a).add(b);
      indegree[b]++;
    }
    return this;
  }
}
public class BOJ1613_역사 {

  public static void main(String[] args) throws IOException {
    Solution.getInstance()
        .process();
  }
}
