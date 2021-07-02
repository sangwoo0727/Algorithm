import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Solution {

  private StringBuilder output = new StringBuilder();
  private String origin;
  private static Solution solution;

  public static Solution getInstance() {
    if (solution == null) {
      solution = new Solution();
    }
    return solution;
  }

  public void process() throws IOException {
    this.setInput()
        .simul()
        .printAnswer();
  }

  private void printAnswer() {
    System.out.println(output);
  }

  private Solution simul() {
    boolean[] isUsed = new boolean[origin.length()];
    for (int lev = 1; lev <= origin.length(); lev++) {
      PriorityQueue<String> pq = new PriorityQueue<>();
      for (int i = 0; i < origin.length(); i++) {
        if (!isUsed[i]) {
          isUsed[i] = true;
          StringBuilder candidate = new StringBuilder();
          for (int k = 0; k < origin.length(); k++) {
            if (isUsed[k]) {
              candidate.append(origin.charAt(k));
            }
          }
          pq.add(candidate.toString());
          isUsed[i] = false;
        }
      }
      String result = pq.poll();
      output.append(result).append("\n");
      int idx = 0;
      for (int i = 0; i < origin.length(); i++) {
        if (idx == result.length()) {
          break;
        }
        if (origin.charAt(i) == result.charAt(idx)) {
          isUsed[i] = true;
          idx++;
        }
      }
    }

    return this;
  }

  private Solution setInput() throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    origin = input.readLine();
    return this;
  }
}

public class BOJ16719_ZOAC {

  public static void main(String[] args) throws IOException {
    Solution.getInstance()
        .process();
  }
}
