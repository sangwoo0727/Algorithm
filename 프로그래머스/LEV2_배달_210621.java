import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


class Pair {

  int v, w;

  public Pair(int v, int w) {
    this.v = v;
    this.w = w;
  }
}

class Solution {

  private boolean[] visit;
  private int[] weight;
  private List<List<Pair>> adj;

  public int solution(int N, int[][] road, int K) {
    return this.setInput(N, road)
        .findVillage(K)
        .getVillageCount(N);
  }

  private int getVillageCount(int N) {
    int count = 0;
    for (int i = 1; i <= N; i++) {
      if (visit[i]) {
        count++;
      }
    }
    return count;
  }

  private Solution findVillage(int K) {
    Queue<Pair> q = new LinkedList<>();
    q.add(new Pair(1, 0));
    weight[1] = 0;
    visit[1] = true;
    while (!q.isEmpty()) {
      Pair now = q.poll();
      for (Pair next : adj.get(now.v)) {
        if (weight[now.v] + next.w <= K && (weight[next.v] == 0
            || weight[now.v] + next.w < weight[next.v])) {
          visit[next.v] = true;
          weight[next.v] = weight[now.v] + next.w;
          q.add(next);
        }
      }
    }
    return this;
  }

  private Solution setInput(int N, int[][] roads) {
    adj = new ArrayList<>();
    weight = new int[N + 1];
    visit = new boolean[N + 1];
    for (int i = 0; i <= N; i++) {
      adj.add(new ArrayList<>());
    }
    for (int[] road : roads) {
      int u = road[0];
      int v = road[1];
      int w = road[2];
      adj.get(u).add(new Pair(v, w));
      adj.get(v).add(new Pair(u, w));
    }
    return this;
  }


}

public class LEV2_배달_210621 {

}
