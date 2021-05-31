import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ13144_ListOfUniqueNumbers {
    private static boolean[] check;
    private static int N;
    private static long ans;
    private static int[] nums;
    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(ans);
    }
    private static void solve() {
        for (int l = 1, r = 0; l <= N; l++) {
            while (r + 1 <= N && !check[nums[r + 1]]) {
                r++;
                check[nums[r]] = true;
            }
            ans += (r - l + 1);
            check[nums[l]] = false;
        }
    }
    private static void input() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(input.readLine());
        nums = new int[N + 1];
        check = new boolean[N + 1];
        StringTokenizer st = new StringTokenizer(input.readLine());
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
    }
}
