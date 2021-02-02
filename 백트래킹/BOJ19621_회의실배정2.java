import java.io.*;
import java.util.*;

public class BOJ19621_회의실배정2 {
    static int N, ans;
    static List<Node> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(input.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            list.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        list.sort((o1,o2)->{
            if (o1.r == o2.r) return o1.l - o2.l;
            return o1.r - o2.r;
        });
        for (int i = 0; i < N; i++) {
            dfs(i, list.get(i).n);
        }
        System.out.println(ans);
    }

    static void dfs(int n, int sum) {
        boolean flag = false;
        for (int i = n + 1; i < N; i++) {
            if (list.get(i).l >= list.get(n).r) {
                flag = true;
                dfs(i, sum + list.get(i).n);
            }
        }
        if (!flag) {
            ans = Math.max(ans, sum);
        }
    }
    static class Node{
        int l,r, n;
        Node(int l, int r, int n) {
            this.l = l;
            this.r = r;
            this.n = n;
        }
    }
}
