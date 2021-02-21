import java.io.*;
import java.util.*;

public class BOJ1541_잃어버린괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String exp = input.readLine() + "+";
        StringTokenizer st = new StringTokenizer(exp, "-");
        int sum = 0;
        int temp = 0;
        boolean flag = false;
        while (st.hasMoreTokens()) {
            String divExp = st.nextToken();
            StringTokenizer st2 = new StringTokenizer(divExp, "+");
            while (st2.hasMoreTokens()) {
                temp += Integer.parseInt(st2.nextToken());
            }
            if (!flag) {
                sum += temp;
                flag = true;
            } else {
                sum -= temp;
            }
            temp = 0;
        }
        System.out.println(sum);
    }
}
