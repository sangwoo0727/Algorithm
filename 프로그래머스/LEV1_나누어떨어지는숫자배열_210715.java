import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

  public int[] solution(int[] arr, int divisor) {
    List<Integer> answer = new ArrayList<>();
    Arrays.sort(arr);
    for (int num : arr) {
      if (num % divisor == 0) {
        answer.add(num);
      }
    }
    if (answer.isEmpty()) {
      answer.add(-1);
    }
    return answer.stream().mapToInt(Integer::intValue).toArray();
  }
}

public class LEV1_나누어떨어지는숫자배열_210715 {

}
