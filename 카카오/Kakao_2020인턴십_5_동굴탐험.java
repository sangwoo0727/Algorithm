import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Kakao_2020인턴십_5_동굴탐험 {
    private static List<Integer>[] undirectedAdj;
    private static List<Integer>[] directedAdj;
    private static int[] visit;
    private static boolean answer = true;
    public boolean solution(int n, int[][] path, int[][] order) {
        undirectedAdj = new List[n];
        directedAdj = new List[n];
        visit = new int[n];
        for (int i = 0; i < n; i++) {
            undirectedAdj[i] = new ArrayList<>();
            directedAdj[i] = new ArrayList<>();
        }
        for (int[] p : path) {
            undirectedAdj[p[0]].add(p[1]);
            undirectedAdj[p[1]].add(p[0]);
        }
        bfs();
        for (int[] o : order) {
            directedAdj[o[0]].add(o[1]);
        }
        visit = new int[n];
        for (int i = 0; i < n; i++) {
            if (!answer) return false;
            if (visit[i] != 2) {
                dfs(i);
            }
        }
        return answer;
    }

    private static void dfs(int n) {
        if (!answer) {
            return;
        }
        visit[n] = 1;
        for (int nn : directedAdj[n]) {
            if (visit[nn] == 1) {
                answer = false;
                return;
            }
            if (visit[nn] == 0) {
                visit[nn] = 1;
                dfs(nn);
            }
        }
        visit[n] = 2;
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        visit[0] = 1;
        q.add(0);
        while (!q.isEmpty()) {
            int n = q.poll();
            for (int nn : undirectedAdj[n]) {
                if (visit[nn] == 0) {
                    visit[nn] = 1;
                    directedAdj[n].add(nn);
                    q.add(nn);
                }
            }
        }
    }
}
