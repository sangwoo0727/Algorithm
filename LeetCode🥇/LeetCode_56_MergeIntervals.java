import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_56_MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            else return o1[0] - o2[0];
        });
        List<int[]> list = new ArrayList<>();
        int[] prev = {-1, -1};
        for (int[] interval : intervals) {
            if (interval[0] > prev[1]) {
                if (prev[0] != -1) {
                    list.add(prev);
                }
                prev = new int[]{interval[0], interval[1]};
            } else {
                prev[1] = Math.max(prev[1], interval[1]);
            }
        }
        list.add(prev);
        return list.toArray(new int[list.size()][]);
    }
}
