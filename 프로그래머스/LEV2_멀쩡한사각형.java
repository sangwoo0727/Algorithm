public class LEV2_멀쩡한사각형 {
    public long solution(int w, int h) {
        long gcd = gcd(w, h);
        // 반복되는 횟수 : 최대공약수 만큼
        // 하나의 반복 블록 -1 하는 이유는 가로길이 만큼과 세로길이 만큼 가는데, 시작점이 둘이 같다.
        // 선이 가로지르는 블록을 맨위와 맨왼쪽으로 붙혀보면 된다.
        return (long)w * (long)h - (w / gcd + h / gcd - 1) * gcd;
    }
    private static long gcd(int n, int m) {
        while (m > 0) {
            int temp = n % m;
            n = m;
            m = temp;
        }
        return n;
    }
}
