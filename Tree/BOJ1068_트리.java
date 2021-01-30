import java.util.*;
import java.io.*;

public class BOJ1068_트리 {
    static int N, root, remove, ans;
    static List<Integer>[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(input.readLine());
        tree = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(input.readLine());
        for (int i = 0; i < N; i++) {
            int p = Integer.parseInt(st.nextToken());
            if (p == -1) {
                root = i;
                continue;
            }
            tree[p].add(i);
        }
        remove = Integer.parseInt(input.readLine());
        bfs(root);
        System.out.println(ans);
    }

    static void bfs(int r) {
        Queue<Integer> q = new LinkedList<>();
        q.add(r);
        while (!q.isEmpty()) {
            int now = q.poll();
            if (remove == now) {
                continue;
            }
            if (tree[now].size() == 0) ans++;
            for (int k = 0; k < tree[now].size(); k++) {
                int nn = tree[now].get(k);
                if (tree[now].size() == 1 && remove == nn) {
                    ans++;
                } else {
                    q.add(nn);
                }
            }
        }
    }
}
