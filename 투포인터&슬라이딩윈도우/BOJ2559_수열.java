import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2559_수열 {
    private static int N, K;
    private static int[] nums;
    private static int ans = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(ans);
    }
    private static void solve() {
        int l = 1, r = l + K - 1;
        int sum = 0;
        for (int i = l; i <= r; i++) {
            sum += nums[i];
        }
        while (r < N) {
            ans = Math.max(ans, sum);
            sum -= nums[l];
            l++;
            r++;
            sum += nums[r];
        }
        ans = Math.max(ans, sum);
    }
    private static void input() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        nums = new int[N + 1];
        st = new StringTokenizer(input.readLine());
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
    }
}
