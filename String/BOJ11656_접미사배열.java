import java.io.*;
import java.util.*;

public class BOJ11656_접미사배열 {
    public static void main(String[] args) throws IOException {
        StringBuilder output = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        PriorityQueue pq = new PriorityQueue();
        for (int i = 0; i < input.length(); i++) {
            pq.add(input.substring(i));
        }
        while (!pq.isEmpty()) {
            output.append(pq.poll()).append("\n");
        }
        System.out.println(output);
    }
}
