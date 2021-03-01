import java.util.Arrays;

public class LEV2_소수찾기 {
    static boolean[] isDigit = new boolean[10000000];
    static boolean[] visit = new boolean[10000000];
    static int[] line;
    static boolean[] check;
    static int answer;
    static {
        isDigit[0] = true;
        isDigit[1] = true;
        for (int i = 2; i <= 9999999; i++) {
            if (isDigit[i]) continue;
            for (int j = i + i; j <= 9999999; j += i) {
                isDigit[j] = true;
            }
        }
    }
    public int solution(String numbers) {
        answer = 0;
        int[] arr = numbers.chars().map(c -> c - '0').toArray();
        Arrays.sort(arr);
        line = new int[numbers.length()];
        for (int i = 1; i <= numbers.length(); i++) {
            check = new boolean[numbers.length()];
            dfs(0, i, arr);
        }
        return answer;
    }

    static void dfs(int cnt, int k, int[] arr) {
        if (cnt == k) {
            StringBuilder output = new StringBuilder();
            for (int i = 0; i < k; i++) {
                output.append(line[i]);
            }
            int digit = Integer.parseInt(output.toString());
            if (!visit[digit]) {
                visit[digit] = true;
                if (!isDigit[digit]) {
                    answer++;
                }
            }
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!check[i]) {
                check[i] = true;
                line[cnt] = arr[i];
                dfs(cnt + 1, k, arr);
                check[i] = false;
            }
        }
    }
}
