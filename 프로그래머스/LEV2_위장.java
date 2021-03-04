import java.util.*;

public class LEV2_위장 {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        for (String[] clothe : clothes) {
            String kind = clothe[1];
            map.put(kind, map.getOrDefault(kind, 0) + 1);
        }
        for (int count : map.values()) {
            answer *= (count + 1);
        }
        return answer - 1;
    }
}
