import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge {

  int weight, to;

  public Edge(int weight, int to) {
    this.weight = weight;
    this.to = to;
  }
}

class Info {

  int dist, node;

  public Info(int dist, int node) {
    this.dist = dist;
    this.node = node;
  }
}

class Solution {
  private int resultWithFriend, result;
  private int V, E, P;
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
        .calculate()
        .printAnswer();

  }
  private void printAnswer() {
    if (resultWithFriend == result) {
      System.out.println("SAVE HIM");
    } else {
      System.out.println("GOOD BYE");
    }
  }
  private Solution calculate() {
    dijkstra(1);
    result = dist[V];
    resultWithFriend = dist[P];
    dijkstra(P);
    resultWithFriend += dist[V];
    return this;
  }
  private void dijkstra(int start) {
    PriorityQueue<Info> pq = new PriorityQueue<>((o1, o2) -> o1.dist - o2.dist);
    dist = new int[V + 1];
    for (int i = 1; i <= V; i++) {
      dist[i] = Integer.MAX_VALUE;
    }
    dist[start] = 0;
    pq.add(new Info(0, start));

    while (!pq.isEmpty()) {
      Info now = pq.poll();
      if (now.dist > dist[now.node]) {
        continue;
      }
      for (Edge next : adj.get(now.node)) {
        if (now.dist + next.weight >= dist[next.to]) {
          continue;
        }
        dist[next.to] = now.dist + next.weight;
        pq.add(new Info(dist[next.to], next.to));
      }
    }
  }

  private Solution setInput() throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(input.readLine());
    V = Integer.parseInt(st.nextToken());
    E = Integer.parseInt(st.nextToken());
    P = Integer.parseInt(st.nextToken());
    adj = new ArrayList<>();
    for (int i = 0; i <= V; i++) {
      adj.add(new ArrayList<>());
    }
    for (int e = 1; e <= E; e++) {
      st = new StringTokenizer(input.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());
      adj.get(a).add(new Edge(w, b));
      adj.get(b).add(new Edge(w, a));
    }
    return this;
  }
}

public class BOJ18223_민준이와마산그리고건우 {

  public static void main(String[] args) throws IOException {
    Solution.getInstance()
        .process();
  }

}
