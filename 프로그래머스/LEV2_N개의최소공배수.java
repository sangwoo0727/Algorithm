public class LEV2_N개의최소공배수 {
    public int solution(int[] arr) {
        int answer = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int b = arr[i];
            int gcd = gcd(answer, b);
            answer = answer * b / gcd;
        }
        return answer;
    }

    static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
