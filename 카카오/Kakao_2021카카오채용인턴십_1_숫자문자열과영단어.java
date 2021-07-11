import java.util.Map;

class Solution {

  private static Map<String, String> map = Map.of(
      "one", "1",
      "two", "2",
      "three", "3",
      "four", "4",
      "five", "5",
      "six", "6",
      "seven", "7",
      "eight", "8",
      "nine", "9",
      "zero", "0"
  );
  public int solution(String s) {
    for (String key : map.keySet()) {
      s = s.replaceAll(key, map.get(key));
    }
    return Integer.parseInt(s);
  }
}

public class Kakao_2021카카오채용인턴십_1_숫자문자열과영단어 {

}
