import java.util.Arrays;

public class LEV1_제일작은수제거하기 {
    public int[] solution(int[] arr) {
        int min = Arrays.stream(arr).min().getAsInt();
        return arr.length == 1 ?
                new int[]{-1} :
                Arrays.stream(arr).filter(n -> min != n).toArray();
    }
}
