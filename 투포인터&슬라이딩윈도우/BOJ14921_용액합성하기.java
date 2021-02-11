import java.io.*;
import java.util.*;

public class BOJ14921_용액합성하기 {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        input();
        int l = 0, r = N - 1;
        int ans = Integer.MAX_VALUE;
        while (l < r) {
            int sum = arr[l] + arr[r];
            if (Math.abs(ans) >= Math.abs(sum)) {
                ans = sum;
            }
            if (sum < 0) l++;
            else r--;
        }
        System.out.println(ans);
    }
    static void input() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(input.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(input.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}
