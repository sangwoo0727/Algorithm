import java.util.*;
import java.io.*;

public class BOJ1351_무한수열 {
    private static Map<Long, Long> map = new HashMap<>();
    private static long N, P, Q;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Long.parseLong(st.nextToken());
        P = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());
        map.put(0L, 1L);
        System.out.println(getAns(N));
    }

    private static Long getAns(long n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        map.put(n, getAns(n / P) + getAns(n / Q));
        return map.get(n);
    }
}
