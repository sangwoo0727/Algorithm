import java.io.*;
import java.util.*;

public class BOJ1253_좋다 {
    private static int[] nums;
    private static boolean[] visit;
    private static int N;
    public static void main(String[] args) throws IOException {
        input();
        Arrays.sort(nums);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i==j) continue;
                int lIdx = lowerBound(0, N, nums[i] - nums[j]);
                int uIdx = upperBound(0, N, nums[i] - nums[j]);
                if (lIdx == uIdx) continue;
                if (uIdx - lIdx <= 2) {
                    if (uIdx - lIdx == 2) {
                        if (lIdx <= i && i < uIdx && lIdx <= j && j < uIdx) continue;
                    } else {
                        if ((lIdx <= i && i < uIdx) || (lIdx <= j && j < uIdx)) continue;
                    }
                }
                visit[i] = true;
            }
        }
        int ans = 0;
        for (boolean flag : visit) {
            if (flag) ans++;
        }
        System.out.println(ans);
    }

    private static int lowerBound(int l, int r, int k) {
        while (l < r) {
            int m = (l + r) / 2;
            if (nums[m] < k) l = m + 1;
            else r = m;
        }
        return r;
    }

    private static int upperBound(int l, int r, int k) {
        while (l < r) {
            int m = (l + r) / 2;
            if (nums[m] <= k) l = m + 1;
            else r = m;
        }
        return r;
    }
    private static void input() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(input.readLine());
        nums = new int[N];
        visit = new boolean[N];
        StringTokenizer st = new StringTokenizer(input.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
    }
}
