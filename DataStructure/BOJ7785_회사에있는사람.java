import java.io.*;
import java.util.*;


public class BOJ7785_회사에있는사람 {
    static Map<String, String> map = new TreeMap<>(Comparator.reverseOrder());
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            String name = st.nextToken();
            String log = st.nextToken();
            map.put(name, log);
        }
        StringBuilder output = new StringBuilder();
        for (String key : map.keySet()) {
            String log = map.get(key);
            if (log.equals("enter")) {
                output.append(key).append("\n");
            }
        }
        System.out.println(output);
    }
}
