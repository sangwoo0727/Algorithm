import java.io.*;
import java.util.*;

public class BOJ9020_골드바흐의추측 {
    static boolean[] digit = new boolean[10001];

    static {
        for (int i = 2; i < 10001; i++) {
            if (digit[i]) continue;
            for (int j = 2 * i; j < 10001; j += i) {
                digit[j] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        int tc = Integer.parseInt(input.readLine());
        for (int t = 0; t < tc; t++) {
            int num = Integer.parseInt(input.readLine());
            int a = 0;
            int b = 0;
            int dist = Integer.MAX_VALUE;
            for (int i = 2; i < num; i++) {
                if (!digit[i] && !digit[num - i]) {
                    if (Math.abs(i - (num - i)) < dist) {
                        dist = Math.abs(i - (num - i));
                        if (i - (num - i) < 0) {
                            a = i;
                            b = (num - i);
                        } else {
                            a = num - i;
                            b = i;
                        }
                    }
                }
            }
            output.append(a).append(" ").append(b).append("\n");
        }
        System.out.println(output);
    }
}
