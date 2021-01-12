import java.io.*;
import java.util.*;

public class BOJ20551_Sort마스터배지훈의후계자 {
    static int[] arr;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input.readLine());
        }
        Arrays.sort(arr);
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(input.readLine());
            int idx = lowerBound(0, N, target);
            output.append(idx == N ? -1 : idx).append("\n");
        }
        System.out.println(output);
    }

    static int lowerBound(int l, int r, int target) {
        int ans = N;
        while (l < r) {
            int m = (l + r) / 2;
            if (arr[m] >= target) {
                r = m;
                if (target == arr[m]) {
                    ans = r;
                }
            } else {
                l = m + 1;
            }
        }
        return ans;
    }
}
