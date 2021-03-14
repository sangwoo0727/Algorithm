import java.io.*;
import java.util.*;

public class BOJ4889_안정적인문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        int num = 1;
        while (true) {
            String line = input.readLine();
            if (line.contains("-")) {
                break;
            }
            Deque<Character> stack = new ArrayDeque<>();
            int answer = 0;
            char[] expressions = line.toCharArray();
            for (char expression : expressions) {
                if (expression == '{') {
                    stack.addLast(expression);
                }else{
                    if (!stack.isEmpty()) {
                        stack.pollLast();
                    } else {
                        stack.addLast('{');
                        answer++;
                    }
                }
            }
            if (!stack.isEmpty()) {
                answer += (stack.size() / 2);
            }
            output.append(num++).append(". ");
            output.append(answer);
            output.append("\n");
        }
        System.out.println(output);
    }
}
