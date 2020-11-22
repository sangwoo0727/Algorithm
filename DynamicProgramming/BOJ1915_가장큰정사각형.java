import java.io.*;
import java.util.*;

public class BOJ1915_가장큰정사각형 {
    static int N,M, output;
    static int[][] histo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        histo = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                int num = str.charAt(j)-'0';
                if (i == 0) {
                    histo[i][j] = num;
                } else {
                    histo[i][j] = num == 1 ? histo[i - 1][j] += 1 : 0;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            Deque<Integer> stack = new ArrayDeque<>();
            for (int j = 0; j < M; j++) {
                while (!stack.isEmpty() && histo[i][stack.peek()] > histo[i][j]) {
                    int idx = stack.poll();
                    int width = stack.isEmpty()? j : j - stack.peek() - 1;
                    int height = histo[i][idx];
                    if (width == height) output = Math.max(output, width * height);
                }
                stack.push(j);
            }
            while (!stack.isEmpty()) {
                int idx = stack.poll();
                int height = histo[i][idx];
                int width = stack.isEmpty() ? M : M - stack.peek() - 1;
                if (width == height) output = Math.max(output, width * height);
            }
        }
        System.out.println(output);
    }
}
