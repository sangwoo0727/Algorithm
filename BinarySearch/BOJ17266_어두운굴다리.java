import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17266_어두운굴다리 {
    private static int N, M, ans;
    private static int[] light;
    public static void main(String[] args) throws IOException {
        input();
        binarySearch(1, N);
        System.out.println(ans);
    }

    private static boolean canWalk(int height) {
        int last = 0;
        for (int i = 0; i < M; i++) {
            if (light[i] - height <= last) {
                last = light[i] + height;
            } else {
                return false;
            }
        }
        return last >= N;
    }
    private static void binarySearch(int l, int r) {
        while (l <= r) {
            int m = (l + r) / 2;
            if (canWalk(m)) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
    }
    private static void input() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(input.readLine());
        M = Integer.parseInt(input.readLine());
        light = new int[M];
        StringTokenizer st = new StringTokenizer(input.readLine());
        for (int i = 0; i < M; i++) {
            light[i] = Integer.parseInt(st.nextToken());
        }
    }
}
