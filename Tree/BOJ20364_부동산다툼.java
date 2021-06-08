import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ20364_부동산다툼 {
    private static int N, Q;
    private static boolean[] visit;
    private static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        solve();
    }

    private static void findLand(int wish, int cur, int min) {
        if (cur == 1) {
            if (min == Integer.MAX_VALUE) {
                visit[wish] = true;
                output.append("0").append("\n");
            } else {
                output.append(min).append("\n");
            }
            return;
        }
        if (visit[cur]) {
            min = Math.min(min, cur);
        }
        findLand(wish, cur / 2, min);
    }
    private static void solve() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        visit = new boolean[N + 1];
        for (int i = 1; i <= Q; i++) {
            int wish = Integer.parseInt(input.readLine());
            findLand(wish, wish, Integer.MAX_VALUE);
        }
        System.out.println(output);
    }
}
