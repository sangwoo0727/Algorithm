import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Solution {

  private int N, E;
  private long path1, path2;
  private int vertex1, vertex2;
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
    long answer = Math.min(path1, path2);
    if (answer >= Integer.MAX_VALUE) {
      System.out.println(-1);
    } else {
      System.out.println(answer);
    }
  }

  private Solution calculate() {
    dijkstra(1);
    if (vertex1 == 1 && vertex2 == N) {
      path1 += dist[N];
      path2 += dist[N];
      return this;
    }
    path1 += dist[vertex1];
    path2 += dist[vertex2];

    dijkstra(vertex1);
    path1 += dist[vertex2];
    path2 += dist[N];
    dijkstra(vertex2);
    path1 += dist[N];
    path2 += dist[vertex1];
    return this;
  }

  private void dijkstra(int start) {
    dist = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      dist[i] = Integer.MAX_VALUE;
    }

    PriorityQueue<Info> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
    pq.add(new Info(start, 0));
    while (!pq.isEmpty()) {
      Info info = pq.poll();
      if (info.weight > dist[info.now]) {
        continue;
      }
      for (Edge edge : adj.get(info.now)) {
        if (dist[edge.vertex] > info.weight + edge.weight) {
          dist[edge.vertex] = info.weight + edge.weight;
          pq.add(new Info(edge.vertex, dist[edge.vertex]));
        }
      }
    }
  }
  private Solution setInput() throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(input.readLine());
    N = Integer.parseInt(st.nextToken());
    E = Integer.parseInt(st.nextToken());
    adj = new ArrayList<>();
    for (int i = 0; i <= N; i++) {
      adj.add(new ArrayList<>());
    }
    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(input.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      adj.get(a).add(new Edge(b, c));
      adj.get(b).add(new Edge(a, c));
    }
    st = new StringTokenizer(input.readLine());
    vertex1 = Integer.parseInt(st.nextToken());
    vertex2 = Integer.parseInt(st.nextToken());

    return this;
  }
}

class Info {
  int now, weight;

  Info(int now, int weight) {
    this.now = now;
    this.weight = weight;
  }

}
class Edge {
  int vertex, weight;

  Edge(int vertex, int weight) {
    this.vertex = vertex;
    this.weight = weight;
  }
}
public class BOJ1504_특정한최단경로 {

  public static void main(String[] args) throws IOException {
    Solution.getInstance()
        .process();
  }
}
