import java.io.*;
import java.util.*;

public class BOJ2960_에라토스테네스의체 {
    static int N, K, output, cnt;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        check = new boolean[N+1];
        label : for (int i = 2; i <= N; i++) {
            for (int j = 1; i * j <= N; j++) {
                if (!check[i * j]) {
                    check[i * j] = true;
                    cnt++;
                    if (cnt == K){
                        output = i * j; break label;
                    }
                }
            }
        }
        System.out.println(output);
    }
}
