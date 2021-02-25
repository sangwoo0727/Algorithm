import java.util.ArrayDeque;
import java.util.Deque;

public class DEV1_크레인인형뽑기게임 {
    static Deque<Integer> st = new ArrayDeque<>();
    public int solution(int[][] bd,int[] moves) {
        int ans = 0;
        for (int move : moves) {
            move -= 1;
            for (int i = 0; i < bd.length; i++) {
                if (bd[i][move] != 0) {
                    int num = bd[i][move];
                    bd[i][move] = 0;
                    if (st.isEmpty()) {
                        st.addLast(num);
                    } else {
                        if (st.peekLast() == num) {
                            st.pollLast();
                            ans += 2;
                        } else {
                            st.addLast(num);
                        }
                    }
                    break;
                }
            }
        }
        return ans;
    }
}
