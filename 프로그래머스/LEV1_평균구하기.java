import java.util.Arrays;

public class LEV1_평균구하기 {
    public double solution(int[] arr) {
        return Arrays.stream(arr).average().orElse(0);
    }
}
