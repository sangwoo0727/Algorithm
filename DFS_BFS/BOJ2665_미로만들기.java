import java.io.*;
import java.util.*;

public class BOJ2665_미로만들기 {
    static int[][] map;
    static int[][] visit;
    static int[][] d = {{-1, 1, 0, 0}, {0, 0, -1, 1}};
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(input.readLine());
        map = new int[N][N];
        visit = new int[N][N];
        for (int i = 0; i < N; i++) {
            String line = input.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
                visit[i][j] = Integer.MAX_VALUE;
            }
        }
        bfs(0, 0);
        System.out.println(visit[N - 1][N - 1]);
    }

    static void bfs(int n, int m) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(n, m, 0));
        visit[n][m] = 0;
        while (!q.isEmpty()) {
            Node now = q.poll();
            for (int k = 0; k < 4; k++) {
                int nn = now.n + d[0][k];
                int nm = now.m + d[1][k];
                if (inner(nn, nm)) {
                    if (map[nn][nm] == 1 && visit[nn][nm] > now.c) {
                        visit[nn][nm] = now.c;
                        q.add(new Node(nn, nm, now.c));
                    } else if (map[nn][nm]==0 && visit[nn][nm] > now.c + 1) {
                        visit[nn][nm] = now.c + 1;
                        q.add(new Node(nn, nm, now.c + 1));
                    }
                }
            }
        }
    }

    static boolean inner(int n, int m) {
        return 0 <= n && n < N && 0 <= m && m < N;
    }
    static class Node{
        int n,m,c;
        Node(int n, int m, int c) {
            this.n = n;
            this.m = m;
            this.c = c;
        }
    }
}
