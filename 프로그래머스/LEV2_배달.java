import java.util.*;

public class LEV2_배달 {
    static int[] board;
    static List<Pair>[] adj;
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        board = new int[N+1];
        Arrays.fill(board, -1);
        adj = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            adj[i] = new ArrayList<>();
        }
        for(int i=0; i<road.length; i++){
            int a = road[i][0];
            int b = road[i][1];
            int c = road[i][2];
            adj[a].add(new Pair(b, c));
            adj[b].add(new Pair(a, c));
        }
        bfs(K);
        for (int value : board) {
            if (value != -1) answer++;
        }
        return answer;
    }
    static void bfs(int K){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(1,0));
        while(!q.isEmpty()){
            Pair p = q.poll();
            int n = p.v;
            int w = p.w;
            board[n] = w;
            for (int i = 0; i < adj[n].size(); i++) {
                Pair np = adj[n].get(i);
                int nn = np.v;
                int nw = np.w;
                if (w + nw > K) continue;
                if (board[nn] == -1 || w + nw <= board[nn]) {
                    board[nn] = w + nw;
                    q.add(new Pair(nn, w + nw));
                }
            }
        }
    }
    static class Pair{
        int v, w;
        Pair(int v, int w){
            this.v = v;
            this.w = w;
        }
    }
}
