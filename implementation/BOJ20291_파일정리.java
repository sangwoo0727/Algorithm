import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class BOJ20291_파일정리 {
    private static Map<String, Integer> map = new TreeMap<>((o1, o2) -> o1.compareTo(o2));
    private static StringBuilder output = new StringBuilder();
    public static void main(String[] args) throws IOException {
        input();
        for (String key : map.keySet()) {
            output.append(key).append(" ").append(map.get(key)).append("\n");
        }
        System.out.println(output);
    }
    private static void input() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(input.readLine());
        for (int i = 0; i < N; i++) {
            String fileName = input.readLine();
            String[] splits = fileName.split("\\.");
            String ext = splits[splits.length - 1];
            map.put(ext, map.getOrDefault(ext, 0) + 1);
        }
    }
}
