import java.util.*;
import java.io.*;

public class BOJ20157_화살을쏘자 {
    static int N, output;
    static Map<Pair, Integer> sameSlope = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int gcd = getGcd(x, y);
            gcd = gcd < 0 ? -gcd : gcd;
            Pair p = new Pair(x / gcd, y / gcd);
            if (sameSlope.containsKey(p)) {
                int num = sameSlope.get(p) + 1;
                sameSlope.put(p, num);
                output = Math.max(output, num);
            } else {
                sameSlope.put(p, 1);
                output = Math.max(output, 1);
            }
        }
        System.out.println(output);
    }
    static int getGcd(int x, int y) {
        while (y != 0) {
            int temp = x % y;
            x = y;
            y = temp;
        }
        return x;
    }
    static class Pair {
        int x;
        int y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            Pair p = (Pair) obj;
            return this.x == p.x && this.y == p.y;
        }

        @Override
        public int hashCode() {
            int c = 31;
            int hashcode = Integer.hashCode(this.x);
            hashcode = c * hashcode + Integer.hashCode(this.y);
            return hashcode;
        }
    }
}
