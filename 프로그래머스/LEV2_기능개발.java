import java.util.*;

public class LEV2_기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int[] time = new int[progresses.length];
        for (int i = 0; i < progresses.length; i++) {
            int restProgress = 100 - progresses[i];
            int speed = speeds[i];
            time[i] = (restProgress) % speed == 0 ?
                    restProgress / speed :
                    restProgress / speed + 1;
        }
        int count = 0;
        int owner = time[0];
        for (int i = 0; i < time.length; i++) {
            if (owner >= time[i]) {
                count++;
            } else {
                answer.add(count);
                owner = time[i];
                count = 1;
            }
        }
        answer.add(count);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
