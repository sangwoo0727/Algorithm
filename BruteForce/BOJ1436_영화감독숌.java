import java.io.*;
public class BOJ1436_영화감독숌 {
    static int N;
    static int output;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int num = 1;
        while (true) {
            String numToString = Integer.toString(num);
            if (numToString.contains("666")) {
                if (--N == 0) {
                    output = Integer.parseInt(numToString);
                    break;
                }
            }
            num++;
        }
        System.out.println(output);
    }
}
