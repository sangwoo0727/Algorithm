import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Kakao_2020인턴십_3_보석쇼핑_210604 {
    private static HashMap<String, Integer> map = new HashMap<>();
    private static Set<String> allKinds = new HashSet<>();
    public static int[] solution(String[] gems) {
        int[] answer = new int[2];
        allKinds.addAll(Arrays.asList(gems));
        int len = gems.length + 1;
        for (int l = 0, r = -1; l < gems.length; l++) {
            while (r + 1 < gems.length && map.size() < allKinds.size()) {
                r++;
                map.put(gems[r], map.getOrDefault(gems[r], 0) + 1);
            }
            if (map.size() == allKinds.size()) {
                if (len > r - l + 1) {
                    len = r - l + 1;
                    answer[0] = l + 1;
                    answer[1] = r + 1;
                }
            }

            if (map.get(gems[l]) == 1) {
                map.remove(gems[l]);
            } else {
                map.put(gems[l], map.get(gems[l]) - 1);
            }
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }

    public static void main(String[] args) {
        solution(new String[] {"ZZZ", "YYY", "NNNN", "YYY", "BBB"});
    }
}
