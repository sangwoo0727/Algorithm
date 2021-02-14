import java.io.*;
import java.util.*;

public class BOJ4948_베르트랑공준 {
    static boolean[] digit = new boolean[250000];
    static {
        Arrays.fill(digit, true);
        for (int i = 2; i < 250000; i++) {
            if (!digit[i]) continue;
            for (int j = i + i; j < 250000; j += i) {
                digit[j] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        while (true) {
            int n = Integer.parseInt(input.readLine());
            int cnt = 0;
            if (n == 0) break;
            for (int i = n + 1; i <= 2 * n; i++) {
                if (digit[i]) cnt++;
            }
            output.append(cnt).append("\n");
        }
        System.out.println(output);
    }
}
