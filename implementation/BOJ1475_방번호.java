import java.io.*;

public class BOJ1475_방번호 {
    static int[] digit = new int[10];
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(input.readLine());
        getCount(N);
        int tmp = (digit[6] + digit[9]) / 2 + (digit[6] + digit[9]) % 2;
        digit[6] = digit[9] = tmp;
        int ans = 0;
        for (int i = 0; i < 10; i++) {
            ans = Math.max(ans, digit[i]);
        }
        System.out.println(ans);
    }

    static void getCount(int n) {
        if (n == 0) {
            digit[n]++;
            return;
        }
        while (n > 0) {
            digit[n % 10]++;
            n /= 10;
        }
    }
}
