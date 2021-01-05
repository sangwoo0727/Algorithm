import java.io.*;
import java.util.*;

public class BOJ20493_세상은하나의손수건 {
    static int[][] d = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int x = 0, y = 0, m = 0, time = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(input.readLine());
            int midTime = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();
            x += d[m][0] * (midTime - time);
            y += d[m][1] * (midTime - time);
            time = midTime;
            if (dir.equals("left")) {
                if (m==3) m = 0;
                else m++;
            } else {
                if (m==0) m = 3;
                else m--;
            }
        }
        x += d[m][0] * (t - time);
        y += d[m][1] * (t - time);
        System.out.println(x + " " + y);
    }
}
