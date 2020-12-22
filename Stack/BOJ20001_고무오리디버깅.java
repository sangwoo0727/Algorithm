import java.io.*;
import java.util.*;

public class BOJ20001_고무오리디버깅 {
    enum Order{
        BEGIN("고무오리 디버깅 시작"),
        PROBLEM("문제"),
        DUCK("고무오리"),
        END("고무오리 디버깅 끝"),
        DONE("고무오리야 사랑해"),
        NOTYET("힝구");

        private String value;
        Order(String value) {
            this.value = value;
        }
        String getValue() {
            return this.value;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int stack = 0;
        while (true) {
            String input = br.readLine();
            if (input.equals(Order.END.getValue())) {
                break;
            } else if (input.equals(Order.PROBLEM.getValue())) {
                stack += 1;
            } else if (input.equals(Order.DUCK.getValue())) {
                stack = stack > 0 ? stack - 1 : stack + 2;
            }
        }
        System.out.println(stack == 0 ? Order.DONE.getValue() : Order.NOTYET.getValue());
    }
}
