import java.util.*;

public class LEV2_주식가격 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Deque<Pair> dq = new ArrayDeque<>();
        int time = 0;
        for (int i = 0; i < prices.length; i++) {
            while (!dq.isEmpty()) {
                if (prices[i] < prices[dq.peekLast().index]) {
                    Pair pair = dq.pollLast();
                    answer[pair.index] = time - pair.time;
                }else {
                    break;
                }
            }
            dq.add(new Pair(i, time++));
        }
        time = prices.length - 1;
        while (!dq.isEmpty()) {
            Pair pair = dq.pollLast();
            answer[pair.index] = time - pair.time;
        }
        return answer;
    }
    static class Pair{
        int index;
        int time;
        Pair(int index, int time) {
            this.index = index;
            this.time = time;
        }
    }
}
