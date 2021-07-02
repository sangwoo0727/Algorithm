import java.util.HashSet;
import java.util.Set;

class Solution {

  private Set<Integer> set;
  private boolean[] isUsed;
  private int N, M;

  public int solution(String[] user_id, String[] banned_id) {
    init(user_id.length, banned_id.length);
    recFunc(user_id, banned_id, 0);
    return set.size();
  }

  private void recFunc(String[] user_id, String[] banned_id, int k) {
    if (k >= M) {
      int bit = getBit();
      set.add(bit);
      return;
    }
    for (int i = 0; i < N; i++) {
      if (!isUsed[i]) {
        String uid = user_id[i];
        String bid = banned_id[k];

        if (isMatch(uid, bid)) {
          isUsed[i] = true;
          recFunc(user_id, banned_id, k + 1);
          isUsed[i] = false;
        }
      }
    }
  }

  private int getBit() {
    StringBuilder bitBuilder = new StringBuilder();
    for (boolean bit : isUsed) {
      if (bit) {
        bitBuilder.append(1);
      } else {
        bitBuilder.append(0);
      }
    }
    return Integer.parseInt(bitBuilder.toString());
  }

  private boolean isMatch(String uid, String bid) {
    if (uid.length() != bid.length()) {
      return false;
    }
    for (int i = 0; i < uid.length(); i++) {
      char uidAlp = uid.charAt(i);
      char bidAlp = bid.charAt(i);

      if (bidAlp == '*') {
        continue;
      }
      if (uidAlp != bidAlp) {
        return false;
      }
    }
    return true;
  }

  private void init(int userIdLength, int bannedIdLength) {
    set = new HashSet<>();
    N = userIdLength;
    M = bannedIdLength;
    isUsed = new boolean[N];
  }
}

public class Kakao_2019겨울인턴십_3_불량사용자 {

  public static void main(String[] args) {

  }
}
