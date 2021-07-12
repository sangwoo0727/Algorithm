class Solution {

  public int solution(String s) {
    int answer = 0;
    boolean[][] isPalidrome = new boolean[s.length()][s.length()];
    for (int j = 0; j < s.length(); j++) {
      for (int i = 0; i <= j; i++) {
        if (s.charAt(i) != s.charAt(j)) {
          isPalidrome[i][j] = false;
          continue;
        }
        if (i + 1 > j - 1 || isPalidrome[i + 1][j - 1]) {
          answer = Math.max(answer, j - i + 1);
          isPalidrome[i][j] = true;
        } else {
          isPalidrome[i][j] = false;
        }
      }
    }
    return answer;
  }
}

public class LEV3_가장긴팰린드롬 {

}
