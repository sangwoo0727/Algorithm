import java.io.*;
import java.util.*;

public class BOJ11441_합구하기 {
    private static int[] arr;
    private static int[] prefixSum;
    private static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        N = Integer.parseInt(input.readLine());
        arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(input.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        prefixSum = new int[N + 2];
        for (int i = 1; i <= N; i++){
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }
        int M = Integer.parseInt(input.readLine());
        for (int i = 0; i < M; i++){
            st = new StringTokenizer(input.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            output.append(prefixSum[right] - prefixSum[left - 1]).append("\n");
        }
        System.out.println(output);
    }
}
