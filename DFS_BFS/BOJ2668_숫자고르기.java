import java.io.*;
import java.util.*;

public class BOJ2668_숫자고르기 {
    static int N;
    static int[] arr;
    static int[] visit;
    static int cent, flag;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(input.readLine());
        arr = new int[N + 1];
        visit = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(input.readLine());
        }
        for (int i = 1; i <= N; i++) {
            if (visit[i] == 0) {
                cent = 0;
                flag = 0;
                dfs(i);
            }
        }
        list.sort(((o1, o2) -> o1-o2));
        StringBuilder output = new StringBuilder();
        output.append(list.size()).append("\n");
        for (int num : list) {
            output.append(num).append("\n");
        }
        System.out.println(output);

    }

    static void dfs(int n) {
        visit[n] = 1;
        if (visit[arr[n]] == 0) {
            dfs(arr[n]);
        } else if (visit[arr[n]] == 1) {
            cent = arr[n];
            flag = 1;
        }
        visit[n] = 2;
        if (flag == 1) {
            if (cent != 0) {
                list.add(n);
                if (cent == n) {
                    flag = 0;
                }
            }
        }
    }
}
