import java.io.*;
import java.util.*;

public class BOJ18870_좌표압축 {
    private static int N;
    private static int[] arr;
    private static int[] answer;
    private static PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> o1.n - o2.n);
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(input.readLine());
        arr = new int[N];
        answer = new int[N];
        StringTokenizer st = new StringTokenizer(input.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            pq.add(new Pair(arr[i], i));
        }

        int n = 0;
        int prev = pq.peek().n;
        while (!pq.isEmpty()) {
            Pair now = pq.poll();
            if (now.n == prev) {
                answer[now.idx] = n;
            }else{
                answer[now.idx] = ++n;
                prev = now.n;
            }
        }
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < N; i++) {
            output.append(answer[i]).append(" ");
        }
        System.out.println(output);
    }
    private static class Pair{
        int n, idx;
        Pair(int n, int idx) {
            this.n = n;
            this.idx = idx;
        }
    }
}
