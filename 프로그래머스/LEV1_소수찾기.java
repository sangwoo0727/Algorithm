public class LEV1_소수찾기 {
    static boolean[] isDigit = new boolean[1000001];
    static {
        for (int i = 2; i <= 1000000; i++) {
            for (int j = i + i; j <= 1000000; j += i) {
                if (!isDigit[j]) isDigit[j] = true;
            }
        }
    }
    public int solution(int n) {
        int answer = 0;
        for (int i = 2; i <= n; i++) {
            if (!isDigit[i]) answer++;
        }
        return answer;
    }
}
