import java.io.*;
import java.util.*;

public class BOJ2217_로프 {
    static int N;
    static int[] lope;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(input.readLine());
        lope = new int[N];
        for (int i = 0; i < N; i++) {
            lope[i] = Integer.parseInt(input.readLine());
        }
        Arrays.sort(lope);
        int value = 0;
        for (int i = 0; i < N; i++) {
            value = Math.max(value, lope[i] * (N - i));
        }
        System.out.println(value);
    }
}
