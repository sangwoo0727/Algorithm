import java.io.*;
import java.util.*;

public class BOJ1135_뉴스전하기 {
    static int N;
    static int[] dp;
    static List<Integer>[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(input.readLine());
        tree = new List[N];
        dp = new int[N];
        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
            dp[i] = -1;
        }
        StringTokenizer st = new StringTokenizer(input.readLine());
        st.nextToken();
        for (int i = 1; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            tree[parent].add(i);
        }
        System.out.println(getTime(0));
    }
    static int getTime(int n) {
        if (dp[n]!=-1) return dp[n];
        if (tree[n].size()==0) return dp[n] = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < tree[n].size(); i++) {
            list.add(getTime(tree[n].get(i)));
        }
        list.sort((o1, o2) -> -(o1 - o2));
        for (int i = 0; i < list.size(); i++) {
            dp[n] = Math.max(dp[n], list.get(i) + i + 1);
        }
        return dp[n];
    }
}
