import java.io.*;

public class BOJ1254_팰린드롬만들기 {
    static String s;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        s = input.readLine();
        int output = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isPalind(i)) {
                output += s.length() + i;
                break;
            }
        }
        System.out.println(output);
    }

    static boolean isPalind(int idx) {
        int length = s.length();
        for (int i = idx; i <= (length + idx) / 2; i++) {
            if (s.charAt(i) != s.charAt(length + idx - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
