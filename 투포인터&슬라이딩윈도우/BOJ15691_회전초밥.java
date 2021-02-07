import java.io.*;
import java.util.*;

public class BOJ15691_회전초밥 {
    private static int N, d, k, c, ans;
    private static int[] sushi;
    private static HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        input();
        for (int i = 0; i < k; i++) {
            if (map.containsKey(sushi[i])) {
                map.put(sushi[i], map.get(sushi[i]) + 1);
            } else {
                map.put(sushi[i], 1);
            }
        }
        int l = 0, r = k - 1;
        while (true) {
            int nl = l + 1;
            int nr = r == N - 1 ? 0 : r + 1;
            if (nl == N) break;
            if (map.get(sushi[l]) == 1) {
                map.remove(sushi[l]);
            } else {
                map.put(sushi[l], map.get(sushi[l]) - 1);
            }
            if (map.containsKey(sushi[nr])) {
                map.put(sushi[nr], map.get(sushi[nr]) + 1);
            } else {
                map.put(sushi[nr], 1);
            }
            l = nl; r = nr;
            ans = Math.max(ans,
                    map.containsKey(c) ? map.size() : (map.size() + 1));
        }
        System.out.println(ans);
    }
    private static void input() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        sushi = new int[N];
        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(input.readLine());
        }
    }
}
