public class Kakao_2020BlindRecruitment_3_자물쇠와열쇠 {
    public boolean solution(int[][] key, int[][] lock) {
        int boardSize = lock.length * 3;
        int[][] board = new int[boardSize][boardSize];
        for (int d = 0; d < 4; d++) {
            int[][] spinKey = spin(key, d);
            for (int i = 0; i + key.length < boardSize; i++) {
                for (int j = 0; j + key.length < boardSize; j++) {
                    for (int n = lock.length; n < lock.length * 2; n++) {
                        for (int m = lock.length; m < lock.length * 2; m++) {
                            board[n][m] = lock[n - lock.length][m - lock.length];
                        }
                    }
                    for (int n = i; n < i + key.length; n++) {
                        for (int m = j; m < j + key.length; m++) {
                            board[n][m] ^= spinKey[n - i][m - j];
                        }
                    }
                    boolean flag = false;
                    label:for (int n = lock.length; n < lock.length * 2; n++) {
                        for (int m = lock.length; m < lock.length * 2; m++) {
                            if (board[n][m] == 0) {
                                flag = true;
                                break label;
                            }
                        }
                    }
                    if (!flag) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static int[][] spin(int[][] key, int count) {
        int size = key.length;
        int[][] temp = new int[key.length][key.length];
        while (count-- > 0) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    temp[i][j] = key[size - 1 - j][i];
                }
            }
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    key[i][j] = temp[i][j];
                }
            }
        }
        return key;
    }
}
