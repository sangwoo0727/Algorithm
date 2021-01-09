import java.io.*;
import java.util.*;

public class BOJ7562_나이트의이동 {
    static int[][] d = {{-1, -2, -2, -1, 1, 2, 2, 1}, {-2, -1, 1, 2, 2, 1, -1, -2}};
    static int[][] map;
    static boolean[][] visit;
    static int N, sn,sm,en, em;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        int tc = Integer.parseInt(input.readLine());
        for (int t = 1; t <= tc; t++) {
            N = Integer.parseInt(input.readLine());
            map = new int[N][N];
            visit = new boolean[N][N];
            StringTokenizer st = new StringTokenizer(input.readLine());
            sn = Integer.parseInt(st.nextToken());
            sm = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(input.readLine());
            en = Integer.parseInt(st.nextToken());
            em = Integer.parseInt(st.nextToken());
            output.append(bfs(sn, sm, en, em)).append("\n");
        }
        System.out.println(output);
    }
    static int bfs(int sn, int sm, int en, int em) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(sn, sm, 0));
        int ans = 0;
        while (!q.isEmpty()) {
            Node now = q.poll();
            if (now.n == en && now.m == em){
                ans = now.d;
                break;
            }
            visit[now.n][now.m] = true;
            for (int k = 0; k < 8; k++) {
                int nn = now.n + d[0][k];
                int nm = now.m + d[1][k];
                if (inner(nn, nm)) {
                    visit[nn][nm] = true;
                    q.add(new Node(nn, nm, now.d + 1));
                }
            }
        }
        return ans;
    }

    static boolean inner(int n, int m) {
        return 0 <= n && n < N && 0 <= m && m < N && !visit[n][m];
    }
    static class Node{
        int n,m, d;
        Node(int n, int m, int d) {
            this.n = n;
            this.m = m;
            this.d = d;
        }
    }
}
