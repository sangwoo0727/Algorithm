import java.util.Arrays;

public class LEV2_구명보트 {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int left = 0, right = people.length - 1;
        Arrays.sort(people);
        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
                right--;
            } else {
                right--;
            }
            answer++;
        }
        if (left == right) answer++;
        return answer;
    }
}
