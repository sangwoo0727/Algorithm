import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solve {
    private static Solve solve;
    int R, C;
    int gr, gc;
    int pr, pc;
    char[][] board;

    public static Solve getInstance() {
        if (solve == null) {
            solve = new Solve();
        }
        return solve;
    }

    public void setInput() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        this.R = Integer.parseInt(st.nextToken());
        this.C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(input.readLine());
        this.gr = Integer.parseInt(st.nextToken());
        this.gc = Integer.parseInt(st.nextToken());
        this.pr = Integer.parseInt(st.nextToken());
        this.pc = Integer.parseInt(st.nextToken());
        board = new char[R][C];
        for (int i = 0; i < R; i++) {
            board[i] = input.readLine().toCharArray();
        }
    }

    public int[] checkMap() {
        int[] count = new int[2];
        for (int i = 0; i < this.R; i++) {
            for (int j = 0; j < this.C; j++) {
                if (this.board[i][j] == 'G') {
                    count[0]++;
                } else if (this.board[i][j] == 'P') {
                    count[1]++;
                }
            }
        }
        return count;
    }

    public int getAnswer() {
        Person person = Person.getInstance();
        Pillow pillow = Pillow.getInstance();
        boolean personFlag = person.countPersonInMap == person.area;
        boolean pillowFlag = pillow.countPillowInMap == pillow.area;

        if (personFlag && !pillowFlag) {
            return 1;
        } else {
            return 0;
        }
    }
}
class Pillow {
    int area;
    int countPillowInMap;
    private static Pillow pillow;

    public static Pillow getInstance() {
        if (pillow == null) {
            pillow = new Pillow();
        }
        return pillow;
    }

    public void setArea(int r, int c) {
        this.area = r * c;
    }
}

class Person {
    int area;
    int countPersonInMap;
    private static Person person;

    public static Person getInstance() {
        if (person == null) {
            person = new Person();
        }
        return person;
    }
    public void setArea(int r, int c) {
        this.area = r * c;
    }
}
public class BOJ21771_가희야거기서자는거아니야 {
    public static void main(String[] args) throws IOException {
        Solve solve = Solve.getInstance();
        solve.setInput();
        Person person = Person.getInstance();
        person.setArea(solve.gr, solve.gc);
        Pillow pillow = Pillow.getInstance();
        pillow.setArea(solve.pr, solve.pc);

        int[] count = solve.checkMap();
        person.countPersonInMap = count[0];
        pillow.countPillowInMap = count[1];

        System.out.println(solve.getAnswer());
    }
}
