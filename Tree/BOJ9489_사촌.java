import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ9489_사촌 {
    private static int N, K, kIdx;
    private static int[] nodes;
    private static int[] parents;
    private static StringBuilder output = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            if (N == 0 && K == 0) {
                break;
            }
            nodes = new int[N + 1];
            parents = new int[N + 1];
            st = new StringTokenizer(input.readLine());
            for (int i = 1; i <= N; i++) {
                nodes[i] = Integer.parseInt(st.nextToken());
                if (K == nodes[i]) {
                    kIdx = i;
                }
            }
            makeTree();
            output.append(findSibling()).append("\n");
        }
        System.out.println(output);
    }

    private static int findSibling() {
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            int now = nodes[i];
            if (now != K  && parents[i] != parents[kIdx] && parents[parents[i]] == parents[parents[kIdx]]) {
                ans++;
            }
        }
        return ans;
    }

    private static void makeTree() {
        int idx = 0;
        int prev = nodes[1];
        parents[0] = -1;
        for (int i = 2; i <= N; i++) {
            if (prev + 1 != nodes[i]) {
                idx++;
            }
            parents[i] = idx;
            prev = nodes[i];
        }
    }
}
