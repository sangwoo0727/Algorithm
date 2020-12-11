import java.util.*;
import java.io.*;

public class BOJ2056_작업 {
    static int N, output = Integer.MIN_VALUE;
    static Queue<Integer> q = new LinkedList<>();
    static List<Integer>[] graph;
    static int[] indegree, singleTime, processTime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        singleTime = new int[N + 1];
        processTime = new int[N + 1];
        indegree = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            processTime[i] = singleTime[i] = Integer.parseInt(st.nextToken());
            int prevCnt = Integer.parseInt(st.nextToken());
            indegree[i] = prevCnt;
            for (int j = 0; j < prevCnt; j++) {
                int prev = Integer.parseInt(st.nextToken());
                graph[prev].add(i);
            }
        }

        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) q.add(i);
        }

        topologicalSort();
        for (int i = 1; i <= N; i++) {
            output = Math.max(output, processTime[i]);
        }
        System.out.println(output);
    }

    static void topologicalSort() {
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : graph[now]) {
                processTime[next] = Math.max(processTime[next], processTime[now] + singleTime[next]);
                if (--indegree[next] == 0) {
                    q.add(next);
                }
            }
        }
    }
}
