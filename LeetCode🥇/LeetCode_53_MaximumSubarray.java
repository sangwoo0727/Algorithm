public class LeetCode_53_MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int cur = 0;
        for (int num : nums) {
            cur += num;
            if (ans < cur) ans = cur;
            if (cur < 0) cur = 0;
        }
        return ans;
    }
}
