import java.io.*;
import java.util.*;

public class BOJ6198_옥상정원꾸미기 {
    static int N;
    static int[] buildings;
    static long answer = 0;
    public static void main(String[] args) throws IOException {
        input();
        Deque<Pair> st = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            if (st.isEmpty()) {
                st.addLast(new Pair(buildings[i], i));
                continue;
            }
            while (!st.isEmpty()) {
                if (st.peekLast().n > buildings[i]) {
                    break;
                } else {
                    answer += i - st.pollLast().idx - 1;
                }
            }
            st.addLast(new Pair(buildings[i], i));
        }
        while (!st.isEmpty()) {
            answer += N - st.pollLast().idx - 1;
        }
        System.out.println(answer);
    }
    private static void input() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(input.readLine());
        buildings = new int[N];
        for (int i = 0; i < N; i++) {
            buildings[i] = Integer.parseInt(input.readLine());
        }
    }
    static private class Pair{
        int n, idx;
        Pair(int n, int idx) {
            this.n = n;
            this.idx = idx;
        }
    }
}
