import java.io.*;

public class BOJ11726_2n타일링 {
    static int N;
    static int[] dp;
    static final int MOD = 10007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1];
        System.out.println(getAnswer(N));
    }
    static int getAnswer(int n) {
        if (n==1 || n==2) {
            dp[n] = n;
            return n;
        }
        if (dp[n]!=0) return dp[n];
        dp[n] = (getAnswer(n - 1) + getAnswer(n - 2)) % MOD;
        return dp[n];
    }
}
