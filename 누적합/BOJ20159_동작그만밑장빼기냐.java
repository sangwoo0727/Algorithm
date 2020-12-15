import java.io.*;
import java.util.*;

public class BOJ20159_동작그만밑장빼기냐 {
    static int N, output;
    static int[] input, psum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        input = new int[N];
        psum = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            input[i] = n;
            if (i == N - 1){
                psum[i] = i < 2 ? 0 : psum[i - 2];
                break;
            }
            if (i == 0 || i == 1) {
                psum[i] = n;
            } else {
                psum[i] = psum[i - 2] + n;
            }
        }
        for (int i = 0; i < N; i++) {
            int sum;
            if (i % 2 == 0) {
                if (i - 2 >= 0) {
                    sum = psum[i - 2] + input[N - 1] + (psum[N - 1] - psum[i - 1]);
                } else {
                    sum = input[N - 1] + psum[N - 1];
                }
            } else {
                if (i - 2 >= 0) {
                    sum = psum[i - 1] + (psum[N - 1] - psum[i - 2]);
                } else {
                    sum = psum[i - 1] + psum[N - 1];
                }
            }
            output = Math.max(output, sum);
        }
        System.out.println(output);
    }
}
