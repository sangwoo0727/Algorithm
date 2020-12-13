import java.io.*;
import java.util.*;

public class BOJ2470_두용액 {
    static int N, ans = Integer.MAX_VALUE;
    static int[] input;
    static int[] output;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        input = new int[N];
        output = new int[2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);
        int left = 0, right = N-1;
        while (left < right) {
            int temp = input[left] + input[right];
            if (Math.abs(temp) < ans) {
                output[0] = input[left];
                output[1] = input[right];
                ans = Math.abs(temp);
            }
            if (temp < 0) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println(output[0] + " " + output[1]);
    }
}
