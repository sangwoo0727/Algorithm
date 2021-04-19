import java.io.*;
import java.util.*;

public class BOJ2110_공유기설치 {
    private static int N, C;
    private static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input.readLine());
        }
        Arrays.sort(arr);
        int ans = 0;
        int l = 1;
        int r = arr[N - 1] - arr[0];
        while (l <= r) {
            int m = (l + r) / 2;
            int cnt = 1;
            int prev = arr[0];
            for (int i = 1; i < N; i++) {
                if (arr[i] - prev >= m) {
                    cnt++;
                    prev = arr[i];
                }
            }
            if (cnt < C) {
                r = m - 1;
            } else {
                ans = m;
                l = m + 1;
            }
        }
        System.out.println(ans);
    }
}
