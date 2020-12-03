import java.io.*;
import java.util.*;

public class BOJ2170_선긋기 {
    static int N, output;
    static List<Line> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            list.add(new Line(l, r));
        }
        list.sort((o1, o2) -> Integer.compare(o1.left, o2.left));
        int start = list.get(0).left;
        int end = list.get(0).right;
        for (int i = 1; i < N; i++) {
            int l = list.get(i).left;
            int r = list.get(i).right;
            if (l < end && end < r) {
                end = r;
            }
            if (end < l) {
                output += end - start;
                start = l;
                end = r;
            }
        }
        output += end - start;
        System.out.println(output);
    }

    static class Line {
        int left, right;
        Line(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
}
