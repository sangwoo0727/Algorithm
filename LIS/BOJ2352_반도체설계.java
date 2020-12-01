import java.io.*;
import java.util.*;

public class BOJ2352_반도체설계 {
    static int N;
    static int[] input;
    static int[] lis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        input = new int[N];
        lis = new int[N];
        for (int n = 0; n < N; n++) {
            input[n] = Integer.parseInt(st.nextToken());
        }
        lis[0] = input[0];
        int idx = 0;
        for (int i = 1; i < N; i++) {
            if (lis[idx] < input[i]) {
                lis[++idx] = input[i];
            } else {
                int ii = lowerBound(0, idx, input[i]);
                lis[ii] = input[i];
            }
        }
        System.out.println(idx + 1);
    }

    static int lowerBound(int left, int right, int k) {
        int mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (lis[mid] < k) left = mid + 1;
            else right = mid;
        }
        return right;
    }
}
