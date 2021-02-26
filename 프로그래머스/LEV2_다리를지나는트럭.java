import java.util.LinkedList;
import java.util.Queue;

public class LEV2_다리를지나는트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        int sum = 0;
        for (int truck_weight : truck_weights) {
            while (true) {
                if (q.isEmpty()) {
                    q.add(truck_weight);
                    sum += truck_weight;
                    answer++;
                    break;
                } else if (q.size() < bridge_length) {
                    if (sum + truck_weight <= weight) {
                        q.add(truck_weight);
                        sum += truck_weight;
                        answer++;
                        break;
                    } else {
                        q.add(0);
                        answer++;
                    }
                } else {
                    int temp = q.poll();
                    sum -= temp;
                    if (sum + truck_weight <= weight) {
                        q.add(truck_weight);
                        sum += truck_weight;
                        answer++;
                        break;
                    } else {
                        q.add(0);
                        answer++;
                    }
                }
            }
        }
        return answer + bridge_length;
    }
}
