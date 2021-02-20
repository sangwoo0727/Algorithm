import java.util.*;
import java.util.stream.Collectors;

public class LEV1_정수내림차순으로배치하기 {
    public long solution(long n) {
        List<Integer> list = Arrays.stream(String.valueOf(n).split(""))
                .map(Integer::parseInt)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        return Long.parseLong(list.stream()
                .map(String::valueOf)
                .collect(Collectors.joining()));
    }
}
