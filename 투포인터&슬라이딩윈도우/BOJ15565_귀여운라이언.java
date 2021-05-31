import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15565_귀여운라이언 {
    private static int N, K, ans = Integer.MAX_VALUE;
    private static int[] dolls;
    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }
    private static void solve() {
        int ryan = 0;
        for (int l = 1, r = 0; l <= N; l++) {
            while (r + 1 <= N && ryan < K) {
                r++;
                if (dolls[r] == 1) {
                    ryan++;
                }
            }
            if (ryan >= K) {
                ans = Math.min(ans, r - l + 1);
            }
            if (dolls[l] == 1) ryan--;
        }
    }
    private static void input() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dolls = new int[N + 1];
        st = new StringTokenizer(input.readLine());
        for (int i = 1; i <= N; i++) {
            dolls[i] = Integer.parseInt(st.nextToken());
        }
    }
}
