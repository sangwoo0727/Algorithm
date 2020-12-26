import java.io.*;
import java.util.StringTokenizer;


public class BOJ20003_거스름돈이싫어요 {
    static int N;
    static long[][] arr;
    static long output1, output2 = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(input.readLine());
        arr = new long[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            long gcd = getGcd(arr[i][0], arr[i][1]);
            output2 = getLcm(output2, arr[i][1] / gcd);
            if (i == 0) {
                output1 = arr[i][0] / gcd;
            } else {
                output1 = getGcd(output1, arr[i][0] / gcd);
            }
        }
        System.out.println(output1 + " " + output2);
    }

    static long getLcm(long a, long b) {
        return a * b / getGcd(a, b);
    }
    static long getGcd(long a, long b) {
        while (b != 0) {
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
