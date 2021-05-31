import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1806_부분합_210531 {
    private static int N, S, ans = Integer.MAX_VALUE;
    private static int[] nums;
    public static void main(String[] args) throws IOException {
        input();
        findShortestLen();
        System.out.println(ans == Integer.MAX_VALUE ? 0 : ans);
    }

    private static void findShortestLen() {
        int r = 0, sum = 0;
        for (int l = 1; l <= N; l++) {
            sum -= nums[l - 1];
            while (r + 1 <= N && sum < S) {
                r++;
                sum += nums[r];
            }
            if (sum >= S) {
                ans = Math.min(ans, r - l + 1);
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        nums = new int[N + 1];
        st = new StringTokenizer(input.readLine());
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
    }
}
