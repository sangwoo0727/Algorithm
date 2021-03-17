import java.util.*;

public class LEV3_단어변환 {
    private static int[] used;
    public int solution(String begin, String target, String[] words) {
        used = new int[words.length];
        return bfs(begin, target, words);
    }
    private static int bfs(String begin, String target, String[] words) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(begin, 0));
        while (!q.isEmpty()) {
            Pair pair = q.poll();
            String now = pair.now;
            int cnt = pair.cnt;
            if (checkTarget(now, target)) {
                return cnt;
            }
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                if (isUsed(i) && compareWord(now, word)) {
                    used[i] = cnt + 1;
                    q.add(new Pair(word, cnt + 1));
                }
            }
        }
        return 0;
    }

    private static boolean checkTarget(String now, String target) {
        return now.equals(target);
    }
    private static boolean compareWord(String now, String word) {
        int cnt = 0;
        for (int i = 0; i < now.length(); i++) {
            if (now.charAt(i) != word.charAt(i)) {
                cnt++;
            }
        }
        return cnt == 1;
    }
    private static boolean isUsed(int index) {
        return used[index] == 0;
    }
    private static class Pair{
        String now;
        int cnt;
        Pair(String now, int cnt) {
            this.now = now;
            this.cnt = cnt;
        }
    }
}
