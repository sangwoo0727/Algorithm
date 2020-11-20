import java.io.*;
import java.util.*;

public class BOJ11873_최대직사각형 {
    static int[][] matrix;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        while (true){
            int ans = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) {
                break;
            }
            matrix = new int[N][M];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    if (i == 0) {
                        matrix[i][j] = num;
                    } else {
                        matrix[i][j] = num == 1 ? matrix[i - 1][j] + 1 : num;
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                Deque<Integer> stack = new ArrayDeque<>();
                for (int j = 0; j < M; j++) {
                    while (!stack.isEmpty() && matrix[i][stack.peek()] > matrix[i][j]){
                        int idx = stack.poll();
                        int height = matrix[i][idx];
                        int width = stack.isEmpty() ? j : j - stack.peek() - 1;
                        ans = Math.max(ans, height * width);
                    }
                    stack.push(j);
                }
                while (!stack.isEmpty()){
                    int idx = stack.poll();
                    int height = matrix[i][idx];
                    int width = stack.isEmpty() ? M : M - stack.peek() - 1;
                    ans = Math.max(ans, height * width);
                }
            }
            output.append(ans).append("\n");
        }
        System.out.print(output);
    }
}
