public class LeetCode_55_JumpGame {
    private static boolean[] visit;
    public static boolean canJump(int[] nums) {
        visit = new boolean[nums.length];
        dfs(0, nums);
        return visit[nums.length - 1];
    }

    private static void dfs(int n, int[] nums) {
        visit[n] = true;
        if (n == nums.length - 1) {
            return;
        }
        for (int num = 1; num <= nums[n]; num++) {
            if (n + num < nums.length && !visit[n + num]) {
                dfs(n + num, nums);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
    }
}
