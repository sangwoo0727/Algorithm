import java.io.*;
import java.util.*;

public class BOJ4195_친구네트워크 {
    static int[] p;
    static int[] size;
    static HashMap<String, Integer> map;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(input.readLine());
        StringBuilder output = new StringBuilder();
        for (int t = 1; t <= tc; t++) {
            int n = Integer.parseInt(input.readLine());
            p = new int[200001];
            map = new HashMap<>();
            size = new int[200001];
            int idx = 0;
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(input.readLine());
                String s1 = st.nextToken();
                String s2 = st.nextToken();
                if (!map.containsKey(s1)) {
                    map.put(s1, ++idx);
                    p[map.get(s1)] = map.get(s1);
                    size[map.get(s1)] = 1;
                }
                if (!map.containsKey(s2)) {
                    map.put(s2, ++idx);
                    p[map.get(s2)] = map.get(s2);
                    size[map.get(s2)] = 1;
                }
                int n1 = map.get(s1);
                int n2 = map.get(s2);
                merge(n1, n2);
                output.append(size[find(n1)]).append("\n");
            }
        }
        System.out.println(output);
    }

    static void merge(int n, int m) {
        n = find(n);
        m = find(m);
        if (n != m) {
            size[n] = size[n] + size[m];
        }
        p[m] = n;
    }

    static int find(int n) {
        if (p[n] == n) {
            return n;
        }
        return p[n] = find(p[n]);
    }
}
