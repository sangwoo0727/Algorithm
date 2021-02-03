import java.io.*;
import java.util.*;

public class BOJ1744_수묶기 {
    static int[] seq;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(input.readLine());
        seq = new int[N];
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(input.readLine());
        }
        Arrays.sort(seq);
        int sum = 0;
        for (int i = 0; i < N; i++) {
            if (seq[i] >= 0) break;
            if (i + 1 < N && seq[i + 1] <= 0) {
                sum += seq[i] * seq[i + 1];
                i += 1;
            } else {
                sum += seq[i];
            }
        }
        for (int i = N - 1; i >= 0; i--) {
            if (seq[i] <= 0) break;
            if (i - 1 >= 0 && seq[i - 1] > 0 && seq[i - 1] != 1) {
                sum += seq[i] * seq[i - 1];
                i -= 1;
            } else {
                sum += seq[i];
            }
        }
        System.out.println(sum);
    }
}
