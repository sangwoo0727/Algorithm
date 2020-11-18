import java.io.*;
import java.util.*;

public class BOJ11725_트리의부모찾기 {
    static int N;
    static int[] parent;
    static boolean[] visit;
    static List<Integer>[] adj;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        parent = new int[N+1];
        visit = new boolean[N+1];
        adj = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int inputCnt=0; inputCnt < N-1; inputCnt++){
            st = new StringTokenizer(br.readLine());
            int val1 = Integer.parseInt(st.nextToken());
            int val2 = Integer.parseInt(st.nextToken());
            adj[val1].add(val2);
            adj[val2].add(val1);
        }
        bfsSearch(1);
        StringBuilder output = new StringBuilder();
        for (int i=2; i<=N; i++){
            output.append(parent[i]).append("\n");
        }
        System.out.println(output);
    }
    static void bfsSearch(int root){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int now = queue.poll();
            visit[now] = true;
            for (int i = 0; i< adj[now].size(); i++){
                int next = adj[now].get(i);
                if (!visit[next]){
                    visit[next] = true;
                    parent[next] = now;
                    queue.add(next);
                }
            }
        }
    }
}
