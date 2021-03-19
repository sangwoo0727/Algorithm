import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10799_쇠막대기 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        int answer = 0;
        int cnt = 0;
        for (int i = 0; i < line.length(); i++) {
            char bracket = line.charAt(i);
            if (bracket == '(') {
                char nextBracket = line.charAt(i + 1);
                if (bracket != nextBracket) {
                    answer += cnt;
                    i += 1;
                }else{
                    cnt++;
                }
            }else{
                answer += 1;
                cnt--;
            }
        }
        System.out.println(answer);
    }
}
