import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;

class Solution {

  private BufferedReader input;
  private final StringBuilder output = new StringBuilder();
  private static Solution solution;
  private int[] strahler;
  private int[] indegree;
  private List<TreeMap<Integer, Integer>> indegreeCnt;
  private List<List<Integer>> adj;
  private int K, M, P;

  public static Solution getInstance() {
    if (solution == null) {
      solution = new Solution();
    }
    return solution;
  }

  public void process() throws IOException {
    input = new BufferedReader(new InputStreamReader(System.in));
    int tc = Integer.parseInt(input.readLine());
    for (int t = 1; t <= tc; t++) {
      this.setInput()
          .simulFlow()
          .writeAnswer();
    }
    System.out.println(output);
  }

  private void writeAnswer() {
    int max = 0;
    for (int i = 1; i <= M; i++) {
      max = Math.max(max, strahler[i]);
    }
    output.append(K).append(" ").append(max).append("\n");
  }

  private Solution simulFlow() {
    Queue<Integer> q = new LinkedList<>();
    for (int i = 1; i <= M; i++) {
      if (indegree[i] == 0) {
        strahler[i] = 1;
        q.add(i);
      }
    }
    while (!q.isEmpty()) {
      int now = q.poll();
      for (int next : adj.get(now)) {
        indegree[next]--;
        indegreeCnt.get(next)
            .put(strahler[now], indegreeCnt.get(next).getOrDefault(strahler[now], 0) + 1);
        if (indegree[next] == 0) {
          int nextStrahler = indegreeCnt.get(next).get(indegreeCnt.get(next).firstKey()) == 1 ?
              indegreeCnt.get(next).firstKey() :
              indegreeCnt.get(next).firstKey() + 1;
          strahler[next] = nextStrahler;
          q.add(next);
        }
      }
    }
    return this;
  }

  private Solution setInput() throws IOException {
    StringTokenizer st = new StringTokenizer(input.readLine());
    K = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    P = Integer.parseInt(st.nextToken());
    indegree = new int[M + 1];
    strahler = new int[M + 1];
    indegreeCnt = new ArrayList<>();
    adj = new ArrayList<>();
    for (int i = 0; i <= M; i++) {
      indegreeCnt.add(new TreeMap<>((o1, o2) -> -(o1 - o2)));
      adj.add(new ArrayList<>());
    }
    for (int i = 1; i <= P; i++) {
      st = new StringTokenizer(input.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      adj.get(a).add(b);
      indegree[b]++;
    }
    return this;
  }
}

public class BOJ9470_Strahler순서 {

  public static void main(String[] args) throws IOException {
    Solution.getInstance()
        .process();
  }
}
