import java.io.*;

public class BOJ1316_그룹단어체커 {
    private static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(input.readLine());
        int answer = 0;
        for (int n = 0; n < N; n++) {
            String word = input.readLine();
            boolean[] map = new boolean[26];
            char prev = '1';
            boolean flag = false;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (c != prev) {
                    if (!map[c - 'a']) {
                        map[c - 'a'] = true;
                        prev = c;
                    } else {
                        flag = true;
                        break;
                    }
                }
            }
            if (!flag) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
