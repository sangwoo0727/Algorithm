import java.io.*;
import java.util.*;

public class BOJ2178_미로탐색 {
    static int N, M;
    static int[][] input;
    static int[][] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        input = new int[N][M];
        dist = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                input[i][j] = line.charAt(j) - '0';
            }
        }
        getDist();
        System.out.println(dist[N - 1][M - 1]);
    }

    static void getDist() {
        int[][] dir = {{0, 0, -1, 1}, {1, -1, 0, 0}};
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 1));
        dist[0][0] = 1;
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            dist[now.n][now.m] = now.d;
            for (int k = 0; k < 4; k++) {
                int nn = now.n + dir[0][k];
                int nm = now.m + dir[1][k];
                if (inner(nn, nm)) {
                    if (dist[nn][nm] == 0) {
                        dist[nn][nm] = now.d + 1;
                        queue.add(new Node(nn, nm, now.d + 1));
                    } else if (dist[nn][nm] > now.d + 1) {
                        dist[nn][nm] = now.d + 1;
                        queue.add(new Node(nn, nm, now.d + 1));
                    }
                }
            }
        }
    }

    static boolean inner(int n, int m) {
        return 0 <= n && n < N && 0 <= m && m < M && input[n][m] == 1;
    }
    static class Node {
        int n,m,d;
        Node(int n, int m, int d) {
            this.n = n;
            this.m = m;
            this.d = d;
        }
    }
}
