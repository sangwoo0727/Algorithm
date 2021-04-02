import java.util.*;

public class LEV3_여행경로 {
    private static Map<String, List<Pair>> map = new HashMap<>();
    private static String[] ans;
    public static String[] solution(String[][] tickets) {
        ans = new String[tickets.length + 1];
        for (String[] ticket : tickets) {
            List<Pair> list = map.getOrDefault(ticket[0], new ArrayList<>());
            list.add(new Pair(ticket[1], false));
            map.put(ticket[0], list);
        }
        for (String key : map.keySet()) {
            List<Pair> list = map.get(key);
            list.sort((o1, o2) -> o1.city.compareTo(o2.city));
            map.put(key, list);
        }
        dfs("ICN", 0, ans.length);
        return ans;
    }
    private static boolean dfs(String from, int idx, int size) {
        ans[idx] = from;
        if (idx == size - 1) {
            return true;
        }
        List<Pair> list = map.getOrDefault(from, new ArrayList<>());
        for (int i = 0; i < list.size(); i++) {
            String to = list.get(i).city;
            if(list.get(i).visit) continue;
            list.set(i, new Pair(to, true));
            if (dfs(to, idx + 1, size)) {
                return true;
            }
            list.set(i, new Pair(to, false));
        }
        return false;
    }
    private static class Pair{
        String city;
        boolean visit;
        Pair(String city, boolean visit) {
            this.city = city;
            this.visit = visit;
        }
    }
}
