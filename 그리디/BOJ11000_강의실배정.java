import java.io.*;
import java.util.*;

public class BOJ11000_강의실배정 {
    private static int N;
    private static Pair[] arr;
    private static PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(input.readLine());
        arr = new Pair[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            arr[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(arr, (o1, o2) -> {
            if (o1.l == o2.l) return o1.r - o2.r;
            return o1.l - o2.l;
        });
        for (Pair lesson : arr) {
            if (pq.isEmpty()){
                pq.add(lesson.r);
                continue;
            }
            int out = pq.peek();
            if (out <= lesson.l) {
                pq.poll();
            }
            pq.add(lesson.r);
        }
        System.out.println(pq.size());
    }
    private static class Pair{
        int l, r;
        Pair(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }
}
