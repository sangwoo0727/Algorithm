import java.io.*;
import java.util.*;

public class BOJ17298_오큰수 {
    static int N;
    static int[] ans;
    static Deque<Pair> stack = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(input.readLine());
        ans = new int[N];
        StringTokenizer st = new StringTokenizer(input.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty() && stack.peekLast().n < n) {
                Pair top = stack.pollLast();
                ans[top.idx] = n;
            }
            stack.addLast(new Pair(n, i));
        }
        while (!stack.isEmpty()) {
            Pair top = stack.pollLast();
            ans[top.idx] = -1;
        }
        StringBuilder output = new StringBuilder();
        for (int num : ans) {
            output.append(num).append(" ");
        }
        System.out.println(output);
    }
    private static class Pair{
        int n, idx;
        Pair(int n, int idx) {
            this.n = n;
            this.idx = idx;
        }
    }
}
