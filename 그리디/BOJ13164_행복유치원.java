import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Solution {
  private int N, K;
  private int total;
  private PriorityQueue<Integer> pq;

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
    System.out.println(total);
  }

  private Solution calculate() {
    for (int i = 0; i < N - K; i++) {
      total += pq.poll();
    }
    return this;
  }

  private Solution setInput() throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(input.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    pq = new PriorityQueue<>();
    st = new StringTokenizer(input.readLine());
    int prev = Integer.parseInt(st.nextToken());
    for (int i = 1; i < N; i++) {
      int n = Integer.parseInt(st.nextToken());
      pq.add(n - prev);
      prev = n;
    }
    return this;
  }
}

public class BOJ13164_행복유치원 {

  public static void main(String[] args) throws IOException {
    Solution.getInstance()
        .process();
  }
}
