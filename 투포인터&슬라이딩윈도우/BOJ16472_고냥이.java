import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ16472_고냥이 {
    private static int N;
    private static char[] strs;
    private static int ans;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(ans);
    }
    private static void solve() {
        Map<Character, Integer> map = new HashMap<>();
        for (int l = 0, r = -1; l < strs.length; l++) {
            while (r + 1 < strs.length && map.size() <= N) {
                r++;
                map.put(strs[r], map.getOrDefault(strs[r], 0) + 1);
                if (map.size() <= N) {
                    ans = Math.max(ans, r - l + 1);
                }
            }
            if (map.get(strs[l]) == 1) {
                map.remove(strs[l]);
            } else {
                map.put(strs[l], map.get(strs[l]) - 1);
            }
        }
    }
    private static void input() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(input.readLine());
        strs = input.readLine().toCharArray();
    }
}
