class Solution {

  private int[] answer;

  public int[] solution(int[] A, int K) {
    return this.doRotate(A, K)
        .getAnswer();
  }

  private int[] getAnswer() {
    return this.answer;
  }

  private Solution doRotate(int[] A, int k) {
    answer = new int[A.length];
    for (int i = 0; i < A.length; i++) {
      answer[(i + k) % A.length] = A[i];
    }
    return this;
  }
}

public class Codility_CyclicRotation {

  public static void main(String[] args) {
    Solution solution = new Solution();
  }
}
