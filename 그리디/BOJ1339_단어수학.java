import java.io.*;
import java.util.*;

public class BOJ1339_단어수학 {
    static String[] words;
    static PriorityQueue<Pair> q = new PriorityQueue<>((o1, o2) -> -(o1.sum - o2.sum));
    static int[] alp;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(input.readLine());
        alp = new int[26];
        words = new String[N];
        for (int i = 0; i < N; i++) {
            String s = input.readLine();
            words[i] = s;
            StringBuilder sb = new StringBuilder(s).reverse();
            for (int j = 0; j < sb.length(); j++) {
                char c = sb.charAt(j);
                alp[c - 'A'] += Math.pow(10, j);
            }
        }
        for (int i = 0; i < 26; i++) {
            if (alp[i] != 0) {
                q.add(new Pair(i, alp[i]));
            }
        }
        int digit = 9;
        Map<Integer, Integer> map = new HashMap<>();
        while (!q.isEmpty()) {
            Pair p = q.poll();
            map.put(p.n, digit--);
        }
        int sum = 0;
        for (int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < words[i].length(); j++) {
                char c = words[i].charAt(j);
                sb.append(map.get(c - 'A'));
            }
            int wordToNum = Integer.parseInt(sb.toString());
            sum += wordToNum;
        }
        System.out.println(sum);
    }
    static class Pair {
        int n, sum;
        Pair(int n, int sum) {
            this.n = n;
            this.sum = sum;
        }
    }
}
