import java.util.Arrays;

class Solution {
  public int solution(int[][] routes) {
    Arrays.sort(routes, (o1, o2) -> Integer.compare(o1[1], o2[1]));

    int answer = 0;
    int lastCamera = Integer.MIN_VALUE;

    for (int[] route : routes) {
      if (lastCamera < route[0]) {
        answer++;
        lastCamera = route[1];
      }
    }
    return answer;
  }
}

public class LEV3_단속카메라_210713 {

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[][] routes = {{-20, 15}, {-14, -5},{-18,-13},{-5,-3}};
    System.out.println(solution.solution(routes));
  }
}
