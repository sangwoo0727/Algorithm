import java.util.LinkedList;
import java.util.Queue;

public class LEV2_프린터 {
    public int solution(int[] priorities, int location) {
        int[] lev = new int[10];
        Queue<Pair> q = new LinkedList<>();
        int nowHigh = 0;
        for (int i = 0; i < priorities.length; i++) {
            lev[priorities[i]]++;
            q.add(new Pair(priorities[i], i));
            nowHigh = Math.max(nowHigh, priorities[i]);
        }
        int answer = 0;
        while (!q.isEmpty()) {
            Pair work = q.poll();
            if (work.priority >= nowHigh) {
                answer++;
                lev[nowHigh]--;
                if (nowHigh == work.priority && work.locate == location) {
                    break;
                }
                for (int i = nowHigh; i >= 0; i--) {
                    if (lev[i] > 0) {
                        nowHigh = i;
                        break;
                    }
                }
            } else {
                q.add(work);
            }
        }
        return answer;
    }
    static class Pair{
        int priority;
        int locate;
        Pair(int priority, int locate) {
            this.priority = priority;
            this.locate = locate;
        }
    }
}
