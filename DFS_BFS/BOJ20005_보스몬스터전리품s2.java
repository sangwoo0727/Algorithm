import java.io.*;
import java.util.*;

public class BOJ20005_보스몬스터전리품s2 {
    static int N, M, P, HP;
    static int output;
    static int[] dps;
    static char[][] map;
    static boolean[] getReward = new boolean[26];
    static boolean[][] visit;
    static int[][] dir = {{0, 0, -1, 1}, {1, -1, 0, 0}};
    static Queue<Pair> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visit = new boolean[N][M];
        dps = new int[26];
        for (int i = 0; i < N; i++) {
            map[i] = input.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'B') {
                    queue.add(new Pair(i, j));
                }
            }
        }
        for (int p = 0; p < P; p++) {
            st = new StringTokenizer(input.readLine());
            int id = st.nextToken().charAt(0) - 'a';
            int w = Integer.parseInt(st.nextToken());
            dps[id] = w;
        }
        HP = Integer.parseInt(input.readLine());

        play();
        for (boolean flag : getReward) {
            if (flag) output++;
        }
        System.out.println(output);
    }
    static void play() {
        boolean[] selected = new boolean[26];
        while (HP > 0) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                Pair p = queue.poll();
                visit[p.n][p.m] = true;
                for (int k = 0; k < 4; k++) {
                    int nn = p.n + dir[0][k];
                    int nm = p.m + dir[1][k];
                    if (inner(nn, nm)) {
                        visit[nn][nm] = true;
                        if (map[nn][nm] != '.') {
                            selected[map[nn][nm]-'a'] = true;
                        }
                        queue.add(new Pair(nn, nm));
                    }
                }
            }
            // 공격
            for (int i = 0; i < 26; i++) {
                if (selected[i]) {
                    if (!getReward[i]) {
                        getReward[i] = true;
                    }
                    HP -= dps[i];
                }
            }
        }
    }

    static boolean inner(int n, int m) {
        return 0 <= n && n < N && 0 <= m && m < M && !visit[n][m] && map[n][m]!='X';
    }
    static class Pair{
        int n, m;
        Pair(int n, int m) {
            this.n = n;
            this.m = m;
        }
    }
}
