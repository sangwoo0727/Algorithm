import java.util.*;

public class Kakao_2020인턴십_3_보석쇼핑 {
    private static Set<String> set = new HashSet<>();
    private static Map<String, Integer> map;
    public int[] solution(String[] gems) {
        int[] answer = {};
        set.addAll(Arrays.asList(gems));
        int l = 1, r = gems.length;
        while (l <= r) {
            int m = (l + r) / 2;
            map = new HashMap<>();
            int left = 0, right = m - 1;
            boolean flag = false;
            while (right < gems.length) {
                if (left == 0) {
                    for (int i = left; i <= right; i++) {
                        map.put(gems[i], map.getOrDefault(gems[i], 0) + 1);
                    }
                } else {
                    if (map.get(gems[left - 1]) == 1) {
                        map.remove(gems[left - 1]);
                    } else {
                        map.put(gems[left - 1], map.get(gems[left - 1]) - 1);
                    }
                    map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);
                }
                if (map.size() == set.size()) {
                    answer = new int[]{left + 1, right + 1};
                    flag = true;
                    break;
                }
                left++; right++;
            }
            if (flag) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return answer;
    }
}
