import java.io.*;
import java.util.*;

public class BOJ1759_암호만들기 {
    static StringBuilder output = new StringBuilder();
    static int L, C;
    static char[] alp;
    static char[] line;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        alp = new char[C];
        line = new char[L];
        st = new StringTokenizer(input.readLine());
        for (int i = 0; i < C; i++) {
            alp[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(alp);
        comb(0, 0, 0, 0);
        System.out.println(output);
    }

    static void comb(int idx, int cnt, int vcnt, int ccnt) {
        if (cnt == L) {
            if (vcnt >= 1 && ccnt >= 2) {
                for (int i = 0; i < L; i++) {
                    output.append(line[i]);
                }
                output.append("\n");
            }
            return;
        }
        if (idx >= C) {
            return;
        }
        char c = alp[idx];
        line[cnt] = c;
        if (check(c)) {
            comb(idx + 1, cnt + 1, vcnt + 1, ccnt);
        } else {
            comb(idx + 1, cnt + 1, vcnt, ccnt + 1);
        }
        comb(idx + 1, cnt, vcnt, ccnt);
    }

    static boolean check(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
