import java.util.*;

public class DevMatching2021_3_다단계칫솔판매 {
    private static Map<String, Integer> map = new HashMap<>();
    private static int[] ref;
    private static int[] answer;
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        ref = new int[enroll.length + 1];
        for (int i = 0; i < enroll.length; i++) {
            map.put(enroll[i], i + 1);
        }
        for (int i = 0; i < referral.length; i++) {
            String refer = referral[i];
            if ("-".equals(refer)) {
                ref[i + 1] = 0;
            } else {
                ref[i + 1] = map.get(refer);
            }
        }
        answer = new int[enroll.length + 1];
        divideProfit(seller, amount);
        return Arrays.copyOfRange(answer, 1, answer.length);
    }

    private static void divideProfit(String[] seller, int[] amount) {
        for (int i = 0; i < seller.length; i++) {
            int price = amount[i] * 100;
            int now = map.get(seller[i]);
            while (true) {
                int rest = price / 10;
                int getMoney = price - rest;
                answer[now] += getMoney;
                price = rest;
                now = ref[now];
                if (now == 0) {
                    break;
                }
            }
        }
    }
}
