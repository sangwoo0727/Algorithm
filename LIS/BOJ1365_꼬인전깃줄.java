import java.io.*;
import java.util.*;

public class BOJ1365_꼬인전깃줄 {
    static int N;
    static int[] input;
    static int[] lis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        input = new int[N];
        lis = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
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
        System.out.println(N-idx-1);
    }
    static int lowerBound(int left, int right, int key) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (lis[mid] < key) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}
