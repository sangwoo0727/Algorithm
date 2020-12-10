import java.io.*;

public class BOJ2231_분해합 {
    static int N, output;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            if (i + getDivideSum(i) == N) {
                output = i;
                break;
            }
        }
        System.out.println(output);
    }
    static int getDivideSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10);
            n /= 10;
        }
        return sum;
    }
}
