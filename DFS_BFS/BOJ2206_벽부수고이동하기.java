import java.io.*;
import java.util.*;

public class BOJ2206_벽부수고이동하기 {
    static int[][] map;
    static boolean[][][] visit;
    static int[][] d = {{-1, 1, 0, 0}, {0, 0, -1, 1}};
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new boolean[N][M][2];
        for (int i = 0; i < N; i++) {
            String line = input.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
        System.out.println(bfs());
    }
    static int bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 1, 1));
        int ans = -1;
        while (!q.isEmpty()) {
            Node now = q.poll();
            if (now.n == N - 1 && now.m == M - 1) {
                ans = now.d;
                break;
            }
            visit[now.n][now.m][now.flag] = true;
            for (int k = 0; k < 4; k++) {
                int nn = now.n + d[0][k];
                int nm = now.m + d[1][k];
                if (inner(nn, nm, now.flag)) {
                    if (map[nn][nm] == 0) {
                        visit[nn][nm][now.flag] = true;
                        q.add(new Node(nn, nm, now.d + 1, now.flag));
                    } else {
                        if (now.flag == 1) {
                            visit[nn][nm][1] = true;
                            q.add(new Node(nn, nm, now.d + 1, 0));
                        }
                    }
                }
            }
        }
        return ans;
    }

    static boolean inner(int n, int m, int f) {
        return 0 <= n && n < N && 0 <= m && m < M && !visit[n][m][f];
    }
    static class Node{
        int n,m,d,flag;
        Node(int n, int m, int d, int flag) {
            this.n = n;
            this.m = m;
            this.d = d;
            this.flag = flag;
        }
    }
}
