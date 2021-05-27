import java.io.*;
import java.util.*;

public class BOJ1182_부분수열의합 {
    private static int N, S;
    private static int[] nums;
    private static int ans;
    public static void main(String[] args) throws IOException {
        input();
        recFunc(1, 0);
        System.out.println(S == 0 ? ans - 1 : ans);
    }

    private static void recFunc(int k, int total) {
        if (k == N + 1) {
            if (total == S) {
                ans++;
            }
            return;
        }
        recFunc(k + 1, total);
        recFunc(k + 1, total + nums[k]);
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
