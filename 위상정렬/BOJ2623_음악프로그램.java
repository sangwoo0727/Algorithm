import java.io.*;
import java.util.*;

public class BOJ2623_음악프로그램 {
    static int N, M;
    static boolean[][] dupl;
    static List<Integer>[] adj;
    static int[] ind;
    static List<Integer> flow = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dupl = new boolean[N + 1][N + 1];
        ind = new int[N + 1];
        adj = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(input.readLine());
            int n = Integer.parseInt(st.nextToken());
            int prev = 0;
            for (int j = 0; j < n; j++) {
                int now = Integer.parseInt(st.nextToken());
                if (j!=0 && !dupl[prev][now]) {
                    dupl[prev][now] = true;
                    adj[prev].add(now);
                    ind[now]++;
                }
                prev = now;
            }
        }
        StringBuilder output = new StringBuilder();
        bfs();
        if (flow.size() < N) {
            System.out.println(0);
        }else {
            for (int n : flow) {
                output.append(n).append("\n");
            }
            System.out.println(output);
        }
    }
    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (ind[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int now = q.poll();
            flow.add(now);
            for (int k = 0; k < adj[now].size(); k++) {
                int nn = adj[now].get(k);
                ind[nn]--;
                if (ind[nn] == 0) {
                    q.add(nn);
                }
            }
        }
    }
}
