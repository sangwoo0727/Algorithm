import java.io.*;
import java.util.*;

public class BOJ1939_중량제한 {
    static int N, M, output;
    static boolean[] visit;
    static List<Node>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, w));
            list[b].add(new Node(a, w));
        }
        st = new StringTokenizer(br.readLine());
        int factory1 = Integer.parseInt(st.nextToken());
        int factory2 = Integer.parseInt(st.nextToken());
        binarySearch(0, 1000000000, factory1, factory2);
        System.out.println(output);
    }
    static void binarySearch(int left, int right, int f1, int f2) {
        if (left > right) return;
        int mid = (left + right) / 2;
        visit = new boolean[N + 1];
        if (bfs(mid, f1, f2)) {
            output = mid;
            binarySearch(mid + 1, right, f1, f2);
        } else {
            binarySearch(left, mid - 1, f1, f2);
        }
    }

    static boolean bfs(int weight, int f1, int f2) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(f1);
        while (!queue.isEmpty()) {
            int now = queue.poll();
            visit[now] = true;
            for (int i = 0; i < list[now].size(); i++) {
                Node next = list[now].get(i);
                if (!visit[next.n] && next.w >= weight) {
                    visit[next.n] = true;
                    queue.add(next.n);
                }
            }
        }
        return visit[f2];
    }

    static class Node {
        int n, w;
        Node(int n, int w) {
            this.n = n;
            this.w = w;
        }
    }
}
