import java.io.*;
import java.util.*;

public class LEV1_완주하지못한선수 {
    private static Map<String, Integer> map;
    public String solution(String[] participants, String[] completions) {
        map = new HashMap<>();
        for (String participant : participants) {
            map.put(participant, map.getOrDefault(participant, 0) + 1);
        }
        for (String completion : completions) {
            map.put(completion, map.get(completion) - 1);
        }
        String answer = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                answer = entry.getKey();
                break;
            }
        }
        return answer;
    }
}
