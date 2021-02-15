import java.util.*;

public class LEV1_모의고사 {
    static int[] solver1 = {1, 2, 3, 4, 5};
    static int[] solver2 = {2, 1, 2, 3, 2, 4, 2, 5};
    static int[] solver3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    public int[] solution(int[] answers) {
        Pair[] pairs = new Pair[3];
        pairs[0] = new Pair(1, 0);
        pairs[1] = new Pair(2, 0);
        pairs[2] = new Pair(3, 0);
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == solver1[i % solver1.length]) pairs[0].addCnt();
            if (answers[i] == solver2[i % solver2.length]) pairs[1].addCnt();
            if (answers[i] == solver3[i % solver3.length]) pairs[2].addCnt();
        }
        int max = Math.max(pairs[0].cnt, Math.max(pairs[1].cnt, pairs[2].cnt));
        List<Integer> list = new ArrayList<>();
        for (Pair p : pairs) {
            if (p.cnt == max) {
                list.add(p.solver);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    private static class Pair{
        private int solver;
        private int cnt;
        Pair(int solver, int cnt) {
            this.solver = solver;
            this.cnt = cnt;
        }
        void addCnt() {
            this.cnt++;
        }
    }
}
