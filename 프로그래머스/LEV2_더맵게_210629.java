import java.util.PriorityQueue;

class Solution {

  public int solution(int[] scoville, int K) {
    int answer = 0;
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int sco : scoville) {
      pq.add(sco);
    }
    while (pq.size() >= 2 && pq.peek() < K) {
      int first = pq.poll();
      int second = pq.poll();

      int newValue = first + (2 * second);
      answer++;
      pq.add(newValue);
    }
    if (!pq.isEmpty() && pq.peek() < K) {
      answer = -1;
    }
    return answer;
  }
}

public class LEV2_더맵게_210629 {

  public static void main(String[] args) {

  }
}
