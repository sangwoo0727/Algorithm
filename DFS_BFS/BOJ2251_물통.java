import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2251_물통 {
    private static int[] bottles;
    private static boolean[][][] visit;
    private static List<Integer> waters = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
    private static void solve() {
        bfs();
        StringBuilder output = new StringBuilder();
        Collections.sort(waters);
        for (int water : waters) {
            output.append(water).append(" ");
        }
        System.out.println(output);
    }
    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, bottles[2]});
        visit[0][0][bottles[2]] = true;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            if (now[0] == 0) {
                waters.add(now[2]);
            }
            for (int from = 0; from < 3; from++) {
                for (int to = 0; to < 3; to++) {
                    if (!isValidMove(now, from, to)) {
                        continue;
                    }
                    int[] next = move(now, from, to);
                    if (!visit[next[0]][next[1]][next[2]]) {
                        visit[next[0]][next[1]][next[2]] = true;
                        q.add(next);
                    }
                }
            }
        }
    }

    private static int[] move(int[] now, int from, int to) {
        int[] tmp = Arrays.copyOf(now, now.length);
        if (tmp[from] <= bottles[to] - tmp[to]) {
            tmp[to] = tmp[from] + tmp[to];
            tmp[from] = 0;
        } else {
            tmp[from] = tmp[from] - (bottles[to] - tmp[to]);
            tmp[to] = bottles[to];
        }
        return tmp;
    }

    private static boolean isValidMove(int[] now, int from, int to) {
        return from != to && now[from] != 0 && now[to] < bottles[to];
    }

    private static void input() throws IOException {
        bottles = new int[3];
        visit = new boolean[201][201][201];
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        for (int i = 0; i < 3; i++) {
            bottles[i] = Integer.parseInt(st.nextToken());
        }
    }
}
