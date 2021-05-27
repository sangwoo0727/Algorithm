import java.io.*;
import java.util.*;

public class BOJ15659_연산자끼워넣기3 {
    private static int N;
    private static int[] nums;
    private static int[] opers;
    private static int[] selected;
    private static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        input();
        recFunc(1);
        System.out.println(max);
        System.out.println(min);
    }
    private static int calcu() {
        List<Integer> numsList = new ArrayList<>();
        int prev = nums[0];
        for (int i = 1; i < N; i++) {
            if (selected[i] == 2 || selected[i] == 3) {
                if (selected[i] == 2) {
                    prev *= nums[i];
                } else {
                    prev /= nums[i];
                }
            } else {
                numsList.add(prev);
                prev = nums[i];
            }
        }
        if (numsList.size() == 0) {
            return prev;
        }
        numsList.add(prev);
        int idx = 1;
        int value = numsList.get(0);
        for (int i = 1; i < N; i++) {
            if (selected[i] == 0) {
                value += numsList.get(idx++);
            } else if (selected[i] == 1) {
                value -= numsList.get(idx++);
            }
        }
        return value;
    }
    private static void recFunc(int k) {
        if (k == N) {
            int value = calcu();
            max = Math.max(max, value);
            min = Math.min(min, value);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (opers[i] > 0) {
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
        nums = new int[N];
        selected = new int[N];
        StringTokenizer st = new StringTokenizer(input.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(input.readLine());
        opers = new int[4];
        for (int i = 0; i < 4; i++) {
            opers[i] = Integer.parseInt(st.nextToken());
        }
    }
}
