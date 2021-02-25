public class LEV1_히샤드수 {
    public boolean solution(int x) {
        int num = String.valueOf(x).chars().map(n -> n - '0').sum();
        return x % num == 0;
    }
}
