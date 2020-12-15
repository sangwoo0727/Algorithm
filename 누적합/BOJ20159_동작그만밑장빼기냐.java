import java.io.*;
import java.util.*;

public class BOJ20159_동작그만밑장빼기냐 {
    static int N, output;
    static int[] input, myPsum, yourPsum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        input = new int[N + 1];
        myPsum = new int[N + 1];
        yourPsum = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int n = Integer.parseInt(st.nextToken());
            input[i] = n;
            if (i % 2 == 0) { // your
                yourPsum[i] = yourPsum[i - 1] + n;
                myPsum[i] = myPsum[i - 1];
            } else {
                yourPsum[i] = yourPsum[i - 1];
                myPsum[i] = myPsum[i - 1] + n;
            }
        }
        for (int i = 1; i <= N; i++) {
            int sum;
            if (i % 2 == 0) { // trick for you
                sum = myPsum[i - 1] + yourPsum[N] - yourPsum[i - 1] - input[N];
            } else { // trick for me
                sum = myPsum[i - 1] + yourPsum[N] - yourPsum[i];
            }
            output = Math.max(output, sum);
        }
        System.out.println(output);
    }
}
