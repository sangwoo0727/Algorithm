import java.io.*;
import java.util.*;

public class BOJ9466_텀프로젝트 {
    static int N;
    static int[] edge;
    static int[] visit;
    static int cnt, p;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        int tc = Integer.parseInt(input.readLine());
        for (int t = 1; t <= tc; t++) {
            N = Integer.parseInt(input.readLine());
            edge = new int[N + 1];
            visit = new int[N + 1];
            p = cnt = 0;
            StringTokenizer st = new StringTokenizer(input.readLine());
            for (int i = 1; i <= N; i++) {
                edge[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 1; i <= N; i++) {
                if (visit[i] == 0) {
                    dfs(i);
                }
            }
            output.append(N - cnt).append("\n");
        }
        System.out.println(output);
    }

    static void dfs(int n) {
        visit[n] = 1; // grey
        int nn = edge[n];
        if (visit[nn] == 0) {
            dfs(nn);
        } else if (visit[nn] == 1) {
            //cycle
            p = nn;
        }
        visit[n] = 2; // black
        if (p != 0) {
            if (p == n) p = 0;
            cnt++;
        }
    }
}
