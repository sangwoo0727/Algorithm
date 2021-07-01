import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge {

  int weight, to;

  Edge(int weight, int to) {
    this.weight = weight;
    this.to = to;
  }

}

class Pair {

  int v, d;

  Pair(int v, int d) {
    this.v = v;
    this.d = d;
  }

}

class Solution {

  private int N, M;
  private int targetStart, targetEnd;
  private int[] dist;
  private List<List<Edge>> adj;

  private static Solution solution;

  public static Solution getInstance() {
    if (solution == null) {
      solution = new Solution();
    }
    return solution;
  }

  public void process() throws IOException {
    this.setInput()
        .calculateShortestDist()
        .printAnswer();

  }

  private void printAnswer() {
    System.out.println(dist[targetEnd]);
  }

  private Solution calculateShortestDist() {
    PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> o1.d - o2.d);
    dist[targetStart] = 0;
    pq.add(new Pair(targetStart, dist[targetStart]));
    while (!pq.isEmpty()) {
      Pair now = pq.poll();
      if (dist[now.v] < now.d) continue;

      for (Edge next : adj.get(now.v)) {
        if (now.d + next.weight < dist[next.to]) {
          dist[next.to] = now.d + next.weight;
          pq.add(new Pair(next.to, dist[next.to]));
        }
      }
    }
    return this;
  }

  private Solution setInput() throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(input.readLine());
    M = Integer.parseInt(input.readLine());
    adj = new ArrayList<>();
    dist = new int[N + 1];
    for (int i = 0; i <= N; i++) {
      dist[i] = Integer.MAX_VALUE;
      adj.add(new ArrayList<>());
    }
    for (int m = 1; m <= M; m++) {
      StringTokenizer st = new StringTokenizer(input.readLine());
      int start = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      int weight = Integer.parseInt(st.nextToken());
      adj.get(start).add(new Edge(weight, to));
    }
    StringTokenizer st = new StringTokenizer(input.readLine());
    targetStart = Integer.parseInt(st.nextToken());
    targetEnd = Integer.parseInt(st.nextToken());

    return this;
  }
}

public class BOJ1916_최소비용구하기_210701 {

  public static void main(String[] args) throws IOException {
    Solution.getInstance()
        .process();
  }
}
