import java.io.*;

public class BOJ11687_팩토리얼0의개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(input.readLine());
        int l = 0, r = Integer.MAX_VALUE;
        int ans = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            int cnt = 0;
            for (int i = 5; i <= mid; i *= 5) {
                cnt += mid / i;
            }
            if (cnt >= m) {
                r = mid - 1;
                if (cnt == m) ans = mid;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(ans);
    }
}
