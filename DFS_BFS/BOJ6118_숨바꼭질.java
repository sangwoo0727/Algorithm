import java.io.*;
import java.util.*;

public class BOJ6118_숨바꼭질 {
    static int N, M, dist, cnt, min;
    static List<Integer>[] adj;
    static int[] visit;
    public static void main(String[] args) throws IOException {
        input();
        bfs(1);
        boolean flag = false;
        for (int i=1; i<=N; i++){
            if (visit[i] == dist){
                if (!flag){
                    min = i;
                    flag = true;
                }
                cnt++;
            }
        }
        System.out.println(min + " " + dist + " " + cnt);
    }

    static void bfs(int st) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(st,0));
        while (!q.isEmpty()){
            Pair p = q.poll();
            visit[p.n] = p.d;
            dist = Math.max(dist, visit[p.n]);
            for (int nn : adj[p.n]){
                if (visit[nn] == -1){
                    visit[nn] = p.d + 1;
                    q.add(new Pair(nn, p.d + 1));
                }
            }
        }
    }
    static void input() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N + 1];
        for (int i=1; i<=N; i++){
            adj[i] = new ArrayList<>();
        }
        for (int i=1; i<=M; i++){
            st = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }
        visit = new int[N + 1];
        Arrays.fill(visit, -1);
    }
    static class Pair{
        int n,d;
        Pair(int n, int d){
            this.n = n;
            this.d = d;
        }
    }
}
