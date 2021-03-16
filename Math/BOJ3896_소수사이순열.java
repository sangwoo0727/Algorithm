import java.io.*;

public class BOJ3896_소수사이순열 {
    private static boolean[] isDigit = new boolean[3000000];
    static {
        isDigit[0] = true;
        for (int i = 2; i < 3000000; i++) {
            if (isDigit[i]) continue;
            for (int j = i + i; j < 3000000; j += i) {
                isDigit[j] = true;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        int tc = Integer.parseInt(input.readLine());
        for (int t = 1; t <= tc; t++) {
            int k = Integer.parseInt(input.readLine());
            int answer = 0;
            int right = k;
            while (isDigit[right++]) {
                answer++;
            }
            int left = k - 1;
            while (answer != 0 && isDigit[left--]) {
                answer++;
            }
            output.append(answer == 0 ? answer : answer + 1).append("\n");
        }
        System.out.println(output);
    }
}
