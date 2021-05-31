import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2470_두용액_210531 {
    private static int N, total = Integer.MAX_VALUE;
    private static int[] ans;
    private static int[] nums;
    public static void main(String[] args) throws IOException {
        input();
        Arrays.sort(nums, 1, N + 1);
        solve();
        System.out.println(ans[0] + " " + ans[1]);
    }
    private static void solve() {
        int l = 1, r = N;
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (total > Math.abs(sum)) {
                ans = new int[]{nums[l], nums[r]};
                total = Math.abs(sum);
            }
            if (sum < 0) {
                l++;
            } else {
                r--;
            }
        }
    }
    private static void input() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(input.readLine());
        nums = new int[N + 1];
        StringTokenizer st = new StringTokenizer(input.readLine());
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
    }
}
