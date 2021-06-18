import java.util.PriorityQueue;

class Solution {

  private PriorityQueue<Integer> pq;

  public int lastStoneWeight(int[] stones) {
    return this.addDataIntoStructure(stones)
        .playGame()
        .getAnswer();
  }

  private int getAnswer() {
    if (this.pq.size() == 0) {
      return 0;
    }
    return pq.poll();
  }

  private Solution playGame() {
    while (pq.size() > 1) {
      int n = pq.poll();
      int m = pq.poll();
      if (n > m) {
        n -= m;
        pq.add(n);
      } else if (n < m) {
        m -= n;
        pq.add(m);
      }
    }
    return this;
  }

  private Solution addDataIntoStructure(int[] datas) {
    pq = new PriorityQueue<>((o1, o2) -> -(o1 - o2));
    for (int data : datas) {
      pq.add(data);
    }
    return this;
  }
}

public class LeetCode_1046_LastStoneWeight {

  public static void main(String[] args) {

  }
}
