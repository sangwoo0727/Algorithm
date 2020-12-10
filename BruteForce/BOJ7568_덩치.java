import java.io.*;
import java.util.*;

public class BOJ7568_덩치 {
    static int N;
    static int[][] input;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        input = new int[2][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            input[0][i] = Integer.parseInt(st.nextToken());
            input[1][i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            int cnt = 1;
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                if (input[0][i] < input[0][j] && input[1][i] < input[1][j]) {
                    cnt++;
                }
            }
            output.append(cnt).append(" ");
        }
        System.out.println(output);
    }
}
