import java.io.*;
import java.util.*;

public class BOJ2812_크게만들기 {
    static Deque<Integer> dq = new ArrayDeque<>();
    static int N, K;
    static String value;
    public static void main(String[] args) throws IOException {
        input();
        for (int i = 0; i < value.length(); i++) {
            int num = value.charAt(i) - '0';
            while (K > 0 && !dq.isEmpty()) {
                int top = dq.getLast();
                if (top < num) {
                    dq.pollLast();
                    K--;
                } else {
                    break;
                }
            }
            dq.addLast(num);
        }
        while (K-- > 0) {
            dq.pollLast();
        }
        StringBuilder output = new StringBuilder();
        while (!dq.isEmpty()) {
            output.append(dq.pollFirst());
        }
        System.out.println(output);
    }
    static void input() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        value = input.readLine();
    }
}
