import java.io.*;
import java.util.*;

public class BOJ17103_골드바흐파티션 {
    private static boolean[] isDigit = new boolean[1000001];
    static {
        isDigit[0] = true;
        isDigit[1] = true;
        for (int i = 2; i <= 1000000; i++) {
            if (isDigit[i]) continue;
            for (int j = i + i; j <= 1000000; j += i) {
                isDigit[j] = true;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        int tc = Integer.parseInt(input.readLine());
        for (int t = 0; t < tc; t++) {
            int N = Integer.parseInt(input.readLine());
            int answer = 0;
            for (int i = 2; i <= N; i++) {
                if (i > N - i) break;
                if (!isDigit[i] && !isDigit[N - i]) {
                    answer++;
                }
            }
            output.append(answer).append("\n");
        }
        System.out.println(output);
    }
}
