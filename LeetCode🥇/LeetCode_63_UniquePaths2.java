class Solution {

  private int[][] dp;

  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    dp = new int[obstacleGrid.length][obstacleGrid[0].length];
    for (int i = 0; i < dp.length; i++) {
      if (obstacleGrid[i][0] == 1) {
        break;
      }
      dp[i][0] = 1;
    }
    for (int j = 0; j < dp[0].length; j++) {
      if (obstacleGrid[0][j] == 1) {
        break;
      }
      dp[0][j] = 1;
    }
    for (int i = 1; i < dp.length; i++) {
      for (int j = 1; j < dp[i].length; j++) {
        if (obstacleGrid[i][j] == 1) {
          dp[i][j] = 0;
          continue;
        }
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
      }
    }
    return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
  }
}

public class LeetCode_63_UniquePaths2 {

}
