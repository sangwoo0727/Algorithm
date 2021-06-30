import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

class Solution {

  private Map<Integer, Integer> atoms;

  public int[] solution(String s) {
    int[] answer = this.countAtom(s)
        .makeNtuple();
    return answer;
  }

  private int[] makeNtuple() {
    List<Integer> tuple = new ArrayList<>(atoms.keySet());
    tuple.sort((o1, o2) -> -(atoms.get(o1) - atoms.get(o2)));
    return tuple.stream().mapToInt(Integer::intValue).toArray();
  }

  private Solution countAtom(String s) {
    atoms = new HashMap<>();
    StringTokenizer st = new StringTokenizer(s, "{,}");
    while (st.hasMoreTokens()) {
      int atom = Integer.parseInt(st.nextToken());
      atoms.put(atom, atoms.getOrDefault(atom, 0) + 1);
    }
    return this;
  }
}

public class Kakao_2019인턴십_2_튜플_210630 {

  public static void main(String[] args) {

  }
}
