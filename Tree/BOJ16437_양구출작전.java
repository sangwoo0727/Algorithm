import java.io.*;
import java.util.*;

public class BOJ16437_양구출작전 {
    static int N;
    static int[] cnt;
    static List<Integer>[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(input.readLine());
        cnt = new int[N + 1];
        tree = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 2; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            char type = st.nextToken().charAt(0);
            int num = Integer.parseInt(st.nextToken());
            int parent = Integer.parseInt(st.nextToken());
            if (type == 'S') {
                cnt[i] = num;
            } else {
                cnt[i] = -num;
            }
            tree[parent].add(i);
        }
        System.out.println(dfs(1));
    }

    static long dfs(int now) {
        long answer = cnt[now];
        for (int i = 0; i < tree[now].size(); i++) {
            int next = tree[now].get(i);
            answer += dfs(next);
        }
        return answer < 0 ? 0 : answer;
    }
}
