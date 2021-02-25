public class LEV1_3진법뒤집기 {
    public int solution(int n) {
        int ans = 0;
        String base3 = new StringBuilder(Integer.toString(n,3))
                .reverse()
                .toString();
        int idx = 0;
        for (int i = base3.length() - 1; i >= 0; i--) {
            ans += (base3.charAt(i) - '0') * Math.pow(3, idx++);
        }
        return ans;
    }
}
