import java.io.*;
import java.util.*;

public class BOJ11866_요세푸스문제0 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            q.add(i);
        }
        StringBuilder output = new StringBuilder("<");
        int k = 0;
        while (q.size() > 1) {
            int n = q.poll();
            k++;
            if (k == K) {
                output.append(n).append(", ");
                k = 0;
            }else{
                q.add(n);
            }
        }
        output.append(q.poll()).append(">");
        System.out.println(output);
    }
}
