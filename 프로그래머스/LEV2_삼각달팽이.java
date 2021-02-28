public class LEV2_삼각달팽이 {
    public int[] solution(int N) {
        int[][] arr = new int[N][N];
        int n = 0, m = 0;
        int number = 1;
        int blockCnt = (N * (N + 1)) / 2;
        int dir = 0;
        while (blockCnt-- > 0) {
            arr[n][m] = number++;
            if (dir == 0) {
                if (n == N - 1 || arr[n+1][m] != 0) {
                    dir = 1;
                    m++;
                } else {
                    n++;
                }
            } else if (dir == 1) {
                if (m == N - 1 || arr[n][m + 1] != 0) {
                    dir = 2;
                    n--; m--;
                } else {
                    m++;
                }
            } else {
                if (arr[n - 1][m - 1] != 0) {
                    dir = 0;
                    n++;
                } else {
                    n--; m--;
                }
            }
        }
        int[] answer = new int[N * (N + 1) / 2];
        int idx = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 0) break;
                answer[idx++] = arr[i][j];
            }
        }
        return answer;
    }
}
