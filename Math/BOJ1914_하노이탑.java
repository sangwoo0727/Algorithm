import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class BOJ1914_하노이탑 {
    static int N;
    static List<Pair> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(input.readLine());
        StringBuilder output = new StringBuilder();
        if (N > 20) {
            BigInteger out = new BigInteger("1");
            for (int i = 1; i <= N; i++) {
                out = out.multiply(new BigInteger("2"));
            }
            out = out.subtract(new BigInteger("1"));
            System.out.println(out);
        } else {
            hanoi(N, 1, 2, 3);
            output.append(list.size()).append("\n");
            for (int i = 0; i < list.size(); i++) {
                output.append(list.get(i).n).append(" ").append(list.get(i).m).append("\n");
            }
            System.out.println(output);
        }
    }

    static void hanoi(int n, int from, int by, int to) {
        if (n == 1) {
            list.add(new Pair(from, to));
            return;
        }
        hanoi(n - 1, from, to, by);
        list.add(new Pair(from, to));
        hanoi(n - 1, by, from, to);
    }
    static class Pair {
        int n, m;
        Pair(int n, int m) {
            this.n = n;
            this.m = m;
        }
    }
}
