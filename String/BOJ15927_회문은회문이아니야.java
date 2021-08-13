import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {

  private boolean flag;
  private int answer;
  private String word;
  private static Solution solution;

  public static Solution getInstance() {
    if (solution == null) {
      solution = new Solution();
    }
    return solution;
  }

  private Solution() {
    answer = -1;
  }

  public void solve() throws IOException {
    this.setInput()
        .findLongestSubstring()
        .print();
  }

  private void print() {
    if (answer != -1) {
      System.out.println(answer);
      return;
    }
    if (flag) {
      System.out.println(word.length() - 1);
    } else {
      System.out.println(-1);
    }
  }

  private Solution findLongestSubstring() {
    for (int i = 0; i < word.length() / 2; i++) {
      if (word.charAt(i) != word.charAt(word.length() - i - 1)) {
        answer = word.length();
        break;
      } else if (word.charAt(i) != word.charAt(i + 1)) {
        flag = true;
      }
    }
    return this;
  }

  private Solution setInput() throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    word = input.readLine();
    return this;
  }
}

public class BOJ15927_회문은회문이아니야 {

  public static void main(String[] args) throws IOException {
    Solution.getInstance()
        .solve();
  }
}
