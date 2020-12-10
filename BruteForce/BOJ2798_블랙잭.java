import java.io.*;
import java.util.*;

public class BOJ2798_블랙잭 {
    static int N, M, output;
    static int[] input;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        input = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    int sum = input[i] + input[j] + input[k];
                    if (sum <= M && output <= sum) {
                        output = sum;
                    }
                }
            }
        }
        System.out.println(output);
    }
}
