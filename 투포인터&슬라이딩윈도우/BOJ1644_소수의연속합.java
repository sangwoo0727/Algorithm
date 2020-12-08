import java.io.*;

public class BOJ1644_소수의연속합 {
    static boolean[] isDigit;
    static int[] digitList;
    static int N, output;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        if (N == 1) {
            System.out.println(output);
            return;
        }
        isDigit = new boolean[N + 1];
        digitList = new int[N + 1];
        for (int i = 2; i <= N; i++) {
            for (int j = i + i; j <= N; j += i) {
                isDigit[j] = true;
            }
        }
        int idx = 0;
        for (int i = 2; i <= N; i++) {
            if (!isDigit[i]) digitList[idx++] = i;
        }
        int left = 0, right = 0;
        int sum = digitList[0];
        while (left <= right && right < idx) {
            if (sum < N) {
                sum += digitList[++right];
            } else if (sum > N) {
                sum -= digitList[left++];
            } else {
                output++;
                sum += digitList[++right];
                sum -= digitList[left++];
            }
        }
        System.out.println(output);
    }
}
