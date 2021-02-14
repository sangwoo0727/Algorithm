import java.util.*;

public class LEV1_두개뽑아서더하기 {
    private static Set<Integer> set;
    public int[] solution(int[] numbers) {
        set = new TreeSet<>((o1, o2) -> o1 - o2);
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (i==j) continue;
                set.add(numbers[i] + numbers[j]);
            }
        }
        return set.stream().mapToInt(Integer::intValue).toArray();
    }
}
