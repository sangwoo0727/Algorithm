import java.util.ArrayList;
import java.util.List;

public class LeetCode_54_InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        if (intervals.length == 0) {
            ans.add(newInterval);
            return ans.toArray(new int[ans.size()][]);
        }
        int[] cur = new int[]{intervals[0][0], intervals[0][1]};
        boolean flag = false;
        for (int[] interval : intervals) {
            if (interval[0] <= cur[1]) {
                cur = new int[]{cur[0], Math.max(interval[1], cur[1])};
            } else {
                ans.add(cur);
                cur = new int[]{interval[0], interval[1]};
            }
            if (!flag && newInterval[0] <= cur[1]) {
                flag = true;
                if (newInterval[1] < cur[0]) {
                    ans.add(newInterval);
                } else {
                    cur = new int[]{Math.min(cur[0], newInterval[0]), Math.max(cur[1], newInterval[1])};
                }
            }
        }
        ans.add(cur);
        if (!flag) {
            ans.add(newInterval);
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
