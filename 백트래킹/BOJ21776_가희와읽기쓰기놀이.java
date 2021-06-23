import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Solution {

  private int N, C;
  private boolean[] visit;
  private int[] select;
  private List<Integer> playerLists;
  private List<List<Integer>> player;
  private List<List<String>> cardsOpers;
  private Set<String> set;
  private static Solution solution;

  public static Solution getInstance() {
    if (solution == null) {
      solution = new Solution();
    }
    return solution;
  }

  public void process() throws IOException {
    this.setInput()
        .playGame()
        .printAnswer();
  }

  private void printAnswer() {
    StringBuilder output = new StringBuilder();
    for (String s : set) {
      output.append(s).append("\n");
    }
    System.out.println(output);
  }
  private Solution playGame() {
    recFunc(0);
    return this;
  }

  private void addNewString() {
    int[] map = new int[N + 1];
    StringBuilder sb = new StringBuilder();
    label:
    for (int person : select) {
      int idx = map[person]++;
      int card = player.get(person).get(idx);
      List<String> opers = cardsOpers.get(card);
      for (String opStr : opers) {
        StringTokenizer st = new StringTokenizer(opStr);
        String op = st.nextToken();
        String target = st.nextToken();

        if ("ADD".equals(op)) {
          sb.append(target);
        } else {
          try {
            sb.deleteCharAt(Integer.parseInt(target));
          } catch (RuntimeException e) {
            sb = new StringBuilder("ERROR");
            break label;
          }
        }
      }
    }
    if (sb.toString().isEmpty()) {
      sb = new StringBuilder("EMPTY");
    }
    set.add(sb.toString());
  }

  private void recFunc(int k) {
    if (k == playerLists.size()) {
      addNewString();
      return;
    }
    for (int i = 0; i < playerLists.size(); i++) {
      if (!visit[i]) {
        visit[i] = true;
        select[k] = playerLists.get(i);
        recFunc(k + 1);
        visit[i] = false;
      }
    }
  }

  private Solution setInput() throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(input.readLine());
    N = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    set = new TreeSet<>();
    player = new ArrayList<>();
    cardsOpers = new ArrayList<>();
    playerLists = new ArrayList<>();
    player.add(new ArrayList<>());
    for (int i = 1; i <= N; i++) {
      player.add(new ArrayList<>());
      st = new StringTokenizer(input.readLine());
      int count = Integer.parseInt(st.nextToken());
      for (int c = 1; c <= count; c++) {
        int card = Integer.parseInt(st.nextToken());
        player.get(i).add(card);
        playerLists.add(i);
      }
    }
    visit = new boolean[playerLists.size()];
    select = new int[playerLists.size()];
    cardsOpers = new ArrayList<>();
    cardsOpers.add(new ArrayList<>());
    for (int c = 1; c <= C; c++) {
      cardsOpers.add(new ArrayList<>());
      String[] opers = input.readLine().split(",");
      for (String oper : opers) {
        cardsOpers.get(c).add(oper);
      }
    }
    return this;
  }
}

public class BOJ21776_가희와읽기쓰기놀이 {

  public static void main(String[] args) throws IOException {
    Solution.getInstance()
        .process();
  }
}
