import java.io.*;
import java.util.*;

public class BOJ4358_생태학 {
    static Map<String, Integer> map = new TreeMap<>((o1, o2) -> o1.compareTo(o2));
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int size = 0;
        while (true) {
            String s = input.readLine();
            if (s == null || s.length() == 0) {
                break;
            }
            size += 1;
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }
        StringBuilder output = new StringBuilder();
        for (String s : map.keySet()) {
            double percent = map.get(s) * 100 / (double) size;
            output.append(s).append(" ").append(String.format("%.4f", percent)).append("\n");
        }
        System.out.println(output);
    }
}
