import java.util.*;

public class LEV1_x만큼간격이있는n개의숫자 {
    public long[] solution(int x, int n) {
        List<Long> answer = new ArrayList<>();
        long num = x;
        for (int i = 0; i < n; i++) {
            answer.add(num);
            num += x;
        }
        return answer.stream().mapToLong(Long::longValue).toArray();
    }
}
