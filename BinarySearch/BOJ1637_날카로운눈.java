import java.io.*;
import java.util.*;


public class BOJ1637_날카로운눈 {
    static int[][] arr;
    static int N;
    static long ans = Long.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(input.readLine());
        arr = new int[N][3];
        for (int n = 0; n < N; n++) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            for (int i = 0; i < 3; i++) {
                arr[n][i] = Integer.parseInt(st.nextToken());
            }
        }
        long l = 0, r = Integer.MAX_VALUE;
        int cnt = 0;
        while (l <= r) {
            long mid = (l + r) / 2;
            cnt = getCnt(mid);
            if (cnt % 2 == 0) { //짝수
                l = mid + 1;
            } else {
                r = mid-1;
                ans = mid;
            }
        }
        if (ans == Long.MAX_VALUE) System.out.println("NOTHING");
        else{
            cnt = getCnt(ans);
            int cnt2 = getCnt(ans - 1);
            System.out.println(ans + " " + (cnt - cnt2));
        }
    }

    static int getCnt(long n) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            int a = arr[i][0];
            int c = arr[i][1];
            int b = arr[i][2];
            if (n >= a) {
                cnt += (Math.min(c, n) - a) / b + 1;
            }
        }
        return cnt;
    }
}
