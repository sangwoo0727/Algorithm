import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ13702_이상한술집 {
    private static int N, K;
    private static int[] drinks;
    private static long ans;

    public static void main(String[] args) throws IOException {
        input();
        binarySearch(1, Integer.MAX_VALUE);
        System.out.println(ans);
    }

    private static boolean checkDrink(long m) {
        long count = 0;
        for (int i = 0; i < N; i++) {
            count += drinks[i] / m;
        }
        return count >= K;
    }
    private static void binarySearch(long l, long r) {
        while (l <= r) {
            long m = (l + r) / 2;
            if (checkDrink(m)) {
                ans = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
    }
    private static void input() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        drinks = new int[N];
        for (int i = 0; i < N; i++) {
            drinks[i] = Integer.parseInt(input.readLine());
        }
    }
}
