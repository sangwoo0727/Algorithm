import java.io.*;
import java.util.*;

public class BOJ14888_연산자끼워넣기_210526 {
    private static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    private static int N;
    private static int[] nums;
    private static int[] opers;
    public static void main(String[] args) throws IOException {
        input();
        recFunc(1, nums[0]);

        System.out.println(max);
        System.out.println(min);
    }

    private static int calc(int value, int oper, int next) {
        if (oper == 0) {
            value += next;
        } else if (oper == 1) {
            value -= next;
        } else if (oper == 2) {
            value *= next;
        } else {
            value /= next;
        }
        return value;
    }

    private static void recFunc(int k, int value) {
        if (k == N) {
            max = Math.max(max, value);
            min = Math.min(min, value);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (opers[i] >= 1) {
                opers[i]--;
                recFunc(k + 1, calc(value, i, nums[k]));
                opers[i]++;
            }
        }
    }
    private static void input() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(input.readLine());
        StringTokenizer st = new StringTokenizer(input.readLine());
        nums = new int[N];
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