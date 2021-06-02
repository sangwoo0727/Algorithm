import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1253_좋다 {
    private static int N, ans;
    private static int[] nums;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(ans);
    }
    private static void solve() {
        Arrays.sort(nums, 1, N + 1);
        for (int n = 1; n <= N; n++) {
            int candi = nums[n];
            int l = 1, r = N;
            while (l < r) {
                if (l == n) {
                    l++; continue;
                }
                if (r == n) {
                    r--; continue;
                }
                int sum = nums[l] + nums[r];
                if (candi < sum) r--;
                else if (candi > sum) l++;
                else {
                    ans++; break;
                }
            }
        }
    }
    private static void input() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(input.readLine());
        StringTokenizer st = new StringTokenizer(input.readLine());
        nums = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
    }
}
