import java.io.*;
import java.util.*;

public class BOJ1725_히스토그램_스택 {
    static int output;
    static int[] histo;
    static Deque<Integer> stack = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        histo = new int[N+1];
        histo[0] = 0;
        for (int i=1; i<=N; i++){
            histo[i] = Integer.parseInt(br.readLine());
        }
        for (int i=1; i<=N; i++){
            while (!stack.isEmpty() && histo[stack.peek()] > histo[i]){
                int height = histo[stack.poll()];
                int width = stack.isEmpty()? i - 1 : i - stack.peek() - 1;
                output = Math.max(output, height * width);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            int height = histo[stack.poll()];
            int width = stack.isEmpty() ? N : N - stack.peek() - 1;
            output = Math.max(output, height * width);
        }
        System.out.println(output);
    }
}
