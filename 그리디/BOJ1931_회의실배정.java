import java.io.*;
import java.util.*;

public class BOJ1931_회의실배정 {
    static List<Node> list = new ArrayList<>();
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(input.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            list.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        list.sort((o1, o2) -> {
            if (o1.r == o2.r) return o1.l - o2.l;
            return o1.r - o2.r;
        });
        int total = 0;
        int time = 0;
        for (int i = 0; i < N; i++) {
            Node node = list.get(i);
            if (node.l >= time) {
                total += 1;
                time = node.r;
            }
        }
        System.out.println(total);
    }
    static class Node{
        int l, r;
        Node(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }
}
