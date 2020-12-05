import java.io.*;
import java.util.*;

public class BOJ2467_용액 {
    static int N, specialVal;
    static int output1, output2;
    static int[] input;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        input = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        int left = 0;
        int right = N - 1;
        output1 = input[left];
        output2 = input[right];
        specialVal = Math.abs(input[left] + input[right]);
        while (left < right) {
            int currentVal = input[left] + input[right];
            if (Math.abs(currentVal) < specialVal) {
                output1 = input[left];
                output2 = input[right];
                specialVal = Math.abs(currentVal);
            }
            if (currentVal < 0) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println(output1 + " " + output2);
    }
}
