import java.io.*;
import java.util.*;

public class BOJ3179_백조의호수 {
    static char[][] map;
    static int[][] visit;
    static boolean[][] check;
    static int R, C;
    static int sn, sm, en, em;
    static int[][] d = {{-1, 1, 0, 0}, {0, 0, -1, 1}};
    static Queue<Node> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visit = new int[R][C];
        boolean flag = false;
        for (int i = 0; i < R; i++) {
            String line = input.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'L') {
                    if (!flag) {
                        flag = true;
                        sn = i; sm = j;
                    } else {
                        en = i; em = j;
                    }
                }
                if (map[i][j] == '.' || map[i][j] == 'L') {
                    q.add(new Node(i, j, 0));
                }
                visit[i][j] = -1;
            }
        }
        int r = pp();
        System.out.println(bs(r));

    }
    static int pp() {
        int right = 0;
        while (!q.isEmpty()) {
            Node now = q.poll();
            visit[now.n][now.m] = now.lev;
            right = now.lev;
            for (int k = 0; k < 4; k++) {
                int nn = now.n + d[0][k];
                int nm = now.m + d[1][k];
                if (inner(nn, nm)) {
                    q.add(new Node(nn, nm, now.lev + 1));
                    visit[nn][nm] = now.lev + 1;
                }
            }
        }
        return right;
    }

    static boolean inner(int n, int m) {
        return 0 <= n && n < R && 0 <= m && m < C && visit[n][m] == -1 && map[n][m] == 'X';
    }
    static int bs(int r) {
        int l = 0;
        int ans = 0;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (bfs(mid)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    static boolean canGo(int n, int m) {
        return 0 <= n && n < R && 0 <= m && m < C && !check[n][m];
    }
    static boolean bfs(int day) {
        Queue<Pair> qq = new LinkedList<>();
        check = new boolean[R][C];
        qq.add(new Pair(sn, sm));
        while (!qq.isEmpty()) {
            Pair p = qq.poll();
            if (p.n == en && p.m == em) return true;
            for (int k = 0; k < 4; k++) {
                int nn = p.n + d[0][k];
                int nm = p.m + d[1][k];
                if (canGo(nn, nm)) {
                    if (visit[nn][nm] <= day) {
                        check[nn][nm] = true;
                        qq.add(new Pair(nn, nm));
                    }
                }
            }
        }
        return false;
    }
    static class Pair{
        int n, m;
        Pair(int n, int m) {
            this.n = n;
            this.m = m;
        }
    }
    static class Node{
        int n,m, lev;
        Node(int n, int m, int lev) {
            this.n = n;
            this.m = m;
            this.lev = lev;
        }
    }
}
