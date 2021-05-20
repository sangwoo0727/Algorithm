import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ12886_돌그룹 {
    private static Queue<Node> q = new LinkedList<>();
    private static int sum = 0;
    private static boolean[][] visit = new boolean[1500][1500];
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        q.add(new Node(a, b, c));
        sum = a + b + c;
        if (sum % 3 != 0) {
            System.out.println(0);
        } else {
            System.out.println(bfs() ? "1" : "0");
        }
    }
    private static boolean bfs() {
        while (!q.isEmpty()) {
            Node now = q.poll();
            int x = now.x, y = now.y, z = now.z;
            if (x == y && y == z) {
                return true;
            }
            int[] first = new int[]{x, y, x};
            int[] second = new int[]{y, z, z};
            for (int i = 0; i < 3; i++) {
                int a = first[i];
                int b = second[i];
                if (a < b) {
                    b -= a;
                    a += a;
                } else if (a > b) {
                    a -= b;
                    b += b;
                } else {
                    continue;
                }
                int c = sum - a - b;
                int max = Math.max(Math.max(a, b), c);
                int min = Math.min(Math.min(a, b), c);
                if (!visit[max][min]) {
                    visit[max][min] = true;
                    q.add(new Node(a, b, c));
                }
            }
        }
        return false;
    }
    private static class Node {
        int x, y, z;
        Node(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
