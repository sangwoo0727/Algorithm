import java.io.*;
import java.util.*;

public class BOJ1874_스택수열 {
    static Deque<Integer> s = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(input.readLine());
        int d = 1;
        boolean flag = true;
        StringBuilder output = new StringBuilder();
        for (int n = 1; n <= N; n++) {
            int num = Integer.parseInt(input.readLine());
            if (d <= num) {
                while (d <= num) {
                    output.append("+").append("\n");
                    s.addLast(d++);
                }
                s.pollLast();
                output.append("-").append("\n");
            } else {
                if (num == s.pollLast()) {
                    output.append("-").append("\n");
                } else {
                    flag = false;
                    break;
                }
            }
        }
        System.out.println(flag ? output : "NO");
    }
}
