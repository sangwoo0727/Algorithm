class Solution {
  private String binaryString;

  public int solution(int N) {
    return this.makeBinaryNum(N)
        .getLongestBinaryGap();
  }

  private int getLongestBinaryGap() {
    int answer = 0;
    int count = 0;
    for (int i = 0; i < binaryString.length(); i++) {
      char digit = binaryString.charAt(i);
      if (digit == '0') {
        count++;
      } else {
        answer = Math.max(answer, count);
        count = 0;
      }
    }
    return answer;
  }

  private Solution makeBinaryNum(int N) {
    this.binaryString = Integer.toBinaryString(N);
    return this;
  }

}
public class Codility_BinaryGap {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.solution(1041));
  }

}
