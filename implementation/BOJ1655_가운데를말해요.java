import java.io.*;
import java.util.*;

public class BOJ1655_가운데를말해요 {
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> -(o1 - o2));
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>(((o1, o2) -> (o1 - o2)));
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(input.readLine());
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(input.readLine());
            if (maxHeap.isEmpty()) {
                maxHeap.add(n);
            } else if (maxHeap.size() == minHeap.size()) {
                maxHeap.add(n);
            } else {
                minHeap.add(n);
            }

            if (!maxHeap.isEmpty() && !minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
                int maxNum = maxHeap.poll();
                int minNum = minHeap.poll();
                maxHeap.add(minNum);
                minHeap.add(maxNum);
            }
            output.append(maxHeap.peek()).append("\n");
        }
        System.out.println(output);
    }
}
