import java.io.*;
import java.util.*;

public class BOJ14719_빗물 {
    static int H, W;
    static int[] map;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        map = new int[W];
        st = new StringTokenizer(input.readLine());
        for (int i = 0; i < W; i++){
            map[i] = Integer.parseInt(st.nextToken());
        }
        int ans = 0;
        for (int i = 1; i < W - 1; i++) {
            int left = 0;
            for (int l = i - 1; l >= 0; l--) {
                left = Math.max(left, map[l]);
            }
            int right = 0;
            for (int r = i + 1; r < W; r++) {
                right = Math.max(right, map[r]);
            }
            int h = Math.min(left, right);
            ans += h >= map[i] ? h - map[i] : 0;
        }
        System.out.println(ans);
    }
}
