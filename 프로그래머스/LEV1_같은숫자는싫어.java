import java.util.*;

public class LEV1_같은숫자는싫어 {
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();
        int prev = -1;
        for (int now : arr) {
            if (prev != now) {
                prev = now;
                list.add(now);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
