public class DevMatching2021_1_로또의최고순위와최저순위 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int cnt = 0;
        int zeroCnt = 0;
        for (int i = 0; i < 6; i++) {
            if (lottos[i] == 0){
                zeroCnt++;
                continue;
            }
            for (int j = 0; j < 6; j++) {
                if (lottos[i] == win_nums[j]) {
                    cnt++;
                    break;
                }
            }
        }
        return getScore(cnt, zeroCnt);
    }

    private static int[] getScore(int cnt, int zeroCnt) {
        int[] ans = new int[2];
        ans[0] = Math.min(7 - (cnt + zeroCnt), 6);
        ans[1] = Math.min(7 - cnt, 6);
        return ans;
    }
}
