import java.io.*;
import java.util.*;

public class BOJ2012_등수매기기 {
    static int[] predict;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(input.readLine());
        predict = new int[N];
        long rank = 1;
        long ans = 0;
        for (int i = 0; i < N; i++) {
            predict[i] = Integer.parseInt(input.readLine());
        }
        Arrays.sort(predict);
        for (int i = 0; i < N; i++) {
            if (rank != predict[i]) {
                ans += Math.abs(rank - predict[i]);
            }
            rank++;
        }
        System.out.println(ans);
    }
}
