import java.io.*;
import java.util.*;

public class BOJ1003_피보나치함수_topdown {
    static Pair[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(input.readLine());
        dp = new Pair[41];
        fibo(40);
        StringBuilder output = new StringBuilder();
        while (tc-- > 0) {
            int n = Integer.parseInt(input.readLine());
            output.append(dp[n].zero).append(" ").append(dp[n].one).append("\n");
        }
        System.out.println(output);
    }
    static Pair fibo(int n) {
        if (n == 0) {
            return dp[n] = new Pair(1, 0);
        }
        if (n == 1) {
            return dp[n] = new Pair(0, 1);
        }
        if (dp[n] != null) {
            return dp[n];
        }
        Pair p1 = fibo(n - 1);
        Pair p2 = fibo(n - 2);
        return dp[n] = new Pair(p1.zero + p2.zero, p1.one + p2.one);
    }
    static class Pair{
        int zero;
        int one;
        Pair(int zero, int one) {
            this.zero = zero;
            this.one = one;
        }
    }
}
