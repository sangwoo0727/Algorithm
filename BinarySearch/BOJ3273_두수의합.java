import java.io.*;
import java.util.*;

public class BOJ3273_두수의합 {
    private static int[] nums;
    private static int n, x;
    private static int ans;
    public static void main(String[] args) throws IOException {
        input();
        Arrays.sort(nums, 1, n + 1);
        for (int i = 1; i < n; i++) {
            binarySearch(i + 1, n, x - nums[i]);
        }
        System.out.println(ans);
    }

    private static int binarySearch(int l, int r, int target) {
        int result = l - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] <= target) {
                if (nums[m] == target) ans++;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return result;
    }
    private static void input() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(input.readLine());
        nums = new int[n + 1];
        StringTokenizer st = new StringTokenizer(input.readLine());
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        x = Integer.parseInt(input.readLine());
    }
}
