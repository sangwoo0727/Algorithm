import java.io.*;
import java.util.*;

public class BOJ14888_210526 {
    private static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    private static int N;
    private static int[] nums;
    private static int[] opers;
    private static int[] selected;
    public static void main(String[] args) throws IOException {
        input();
        recFunc(1);

        System.out.println(max);
        System.out.println(min);
    }

    private static int calc() {
        int total = nums[0];
        for (int i = 1; i < N; i++) {
            if (selected[i] == 0) {
                total += nums[i];
            } else if (selected[i] == 1) {
                total -= nums[i];
            } else if (selected[i] == 2) {
                total *= nums[i];
            } else {
                if (total < 0) {
                    total = (Math.abs(total) / nums[i]) * -1;
                } else {
                    total /= nums[i];
                }
            }
        }
        return total;
    }

    private static void recFunc(int k) {
        if (k == N) {
            int total = calc();
            max = Math.max(max, total);
            min = Math.min(min, total);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (opers[i] >= 1) {
                opers[i]--;
                selected[k] = i;
                recFunc(k + 1);
                opers[i]++;
            }
        }
    }
    private static void input() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(input.readLine());
        StringTokenizer st = new StringTokenizer(input.readLine());
        nums = new int[N];
        selected = new int[N];
        opers = new int[4];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(input.readLine());
        for (int i = 0; i < 4; i++) {
            int n = Integer.parseInt(st.nextToken());
            opers[i] = n;
        }
    }
}
