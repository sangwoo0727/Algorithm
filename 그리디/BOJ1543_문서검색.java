import java.io.*;

public class BOJ1543_문서검색 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String doc = input.readLine();
        String word = input.readLine();
        int wordLen = word.length();
        int ans = 0;
        for (int i = 0; i < doc.length();) {
            if (i + wordLen - 1 < doc.length()) {
                String tmp = doc.substring(i, i + wordLen);
                if (tmp.equals(word)) {
                    ans++;
                    i = i + wordLen;
                } else {
                    i++;
                }
            } else {
                break;
            }
        }
        System.out.println(ans);
    }
}
