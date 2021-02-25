import java.util.Arrays;

public class LEV1_예산 {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        for (int i = 0; i < d.length; i++) {
            int cost = d[i];
            if (budget < cost) continue;
            budget -= cost;
            answer++;
        }
        return answer;
    }
}
