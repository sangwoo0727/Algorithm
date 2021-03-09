public class LEV2_땅따먹기 {
    int solution(int[][] land){
        int answer = 0;
        int[][] dp = new int[land.length][4];
        for (int i = 0; i < land.length; i++) {
            if (i == 0) {
                for (int j = 0; j < 4; j++) {
                    dp[i][j] = land[i][j];
                }
                continue;
            }
            for (int j = 0; j < 4; j++) {
                int prevMax = 0;
                for (int k = 0; k < 4; k++) {
                    if (j==k) continue;
                    prevMax = Math.max(prevMax, dp[i - 1][k]);
                }
                dp[i][j] = prevMax + land[i][j];
            }
        }
        for (int j = 0; j < 4; j++) {
            answer = Math.max(answer, dp[land.length - 1][j]);
        }
        return answer;
    }
}
