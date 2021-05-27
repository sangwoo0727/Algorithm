import java.awt.desktop.PreferencesEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15658_연산자끼워넣기2 {
    private static int N;
    private static int[] nums;
    private static int[] opers;
    private static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        input();
        recFunc(1, nums[0]);
        System.out.println(max);
        System.out.println(min);
    }

    private static int calcu(int prev, int op, int idx) {
        if (op == 0) {
            return prev + nums[idx];
        } else if (op == 1) {
            return prev - nums[idx];
        } else if (op == 2) {
            return prev * nums[idx];
        } else {
            return prev / nums[idx];
        }
    }
    private static void recFunc(int k, int total) {
        if (k == N) {
            max = Math.max(max, total);
            min = Math.min(min, total);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (opers[i] > 0) {
                opers[i]--;
                int nextTotal = calcu(total, i, k);
                recFunc(k + 1, nextTotal);
                opers[i]++;
            }
        }
    }
    private static void input() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(input.readLine());
        StringTokenizer st = new StringTokenizer(input.readLine());
        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        opers = new int[4];
        st = new StringTokenizer(input.readLine());
        for (int i = 0; i < 4; i++) {
            opers[i] = Integer.parseInt(st.nextToken());
        }
    }
}
