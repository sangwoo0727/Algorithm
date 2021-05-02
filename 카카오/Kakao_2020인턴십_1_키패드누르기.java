public class Kakao_2020인턴십_1_키패드누르기 {
    private static int[][] board = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
            {10, 0, 11}
    };
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        Pair left = new Pair(3, 0);
        Pair right = new Pair(3, 2);
        for (int number : numbers) {
            Pair pos = checkPosition(number);
            if (pos.m == 0) {
                answer.append("L");
                left = pos;
            } else if (pos.m == 2) {
                answer.append("R");
                right = pos;
            } else {
                int lDist = getDist(left, pos);
                int rDist = getDist(right, pos);
                if (lDist > rDist) {
                    answer.append("R");
                    right = pos;
                } else if (lDist < rDist) {
                    answer.append("L");
                    left = pos;
                } else {
                    if ("left".equals(hand)) {
                        answer.append("L");
                        left = pos;
                    } else {
                        answer.append("R");
                        right = pos;
                    }
                }
            }
        }
        return answer.toString();
    }

    private static int getDist(Pair hand, Pair pos) {
        return Math.abs(pos.n - hand.n) + Math.abs(pos.m - hand.m);
    }
    private static Pair checkPosition(int number) {
        Pair pos = new Pair(0, 0);
        label: for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (number == board[i][j]) {
                    pos = new Pair(i, j);
                    break label;
                }
            }
        }
        return pos;
    }

    private static class Pair {
        int n, m;
        Pair(int n, int m) {
            this.n = n;
            this.m = m;
        }
    }
}
