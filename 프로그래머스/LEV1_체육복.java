import java.util.*;

public class LEV1_체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        boolean[] visit = new boolean[n + 1];
        for (int l : lost) {
            visit[l] = true;
        }
        Set<Integer> set = new HashSet<>();
        for (int r : reserve) {
            if (visit[r]) {
                set.add(r);
                visit[r] = false;
            }
        }
        for (int r : reserve) {
            if (set.contains(r)) {
                continue;
            }
            if (1 < r && visit[r - 1]) {
                visit[r - 1] = false;
            } else if (r < n && visit[r + 1]) {
                visit[r + 1] = false;
            }
        }

        int answer = -1;
        for (boolean b : visit) {
            if (!b) answer++;
        }
        return answer;
    }
}
