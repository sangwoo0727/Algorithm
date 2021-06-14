import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class Solve {
    private int N, T;
    private int[] turns;
    private Person[] people;
    private Set<Integer> publicSpace;
    private Card[] cards;
    private StringBuilder output = new StringBuilder();
    private static Solve solve;

    public static Solve getInstance() {
        if (solve == null) {
            solve = new Solve();
        }
        return solve;
    }
    public void process() throws IOException {
        this.setInput();
        this.startGame();
        this.printAnswer();
    }
    private void printAnswer() {
        System.out.println(output);
    }
    private void startGame() {
        int idx = 0;
        for (int i = 0; i < T; i++) {
            int personId = turns[i];
            Person person = people[personId];
            if (person.hasCard()) {
                Card card = person.getOwnCard();
                output.append(card.getId()).append("\n");
                if (!publicSpace.contains(card.getNum())) {
                    person.addNums(card.getNum());
                    publicSpace.add(card.getNum());
                    person.deleteCard();
                }
            } else {
                Card card = cards[idx++];
                output.append(card.getId()).append("\n");
                if ("acquire".equals(card.getOper())) {
                    if (!publicSpace.contains(card.getNum())) {
                        person.addNums(card.getNum());
                        publicSpace.add(card.getNum());
                    } else {
                        person.updateCard(card);
                    }
                } else if ("release".equals(card.getOper())) {
                    person.deleteNum(card.getNum());
                    publicSpace.remove(card.getNum());
                }
            }
        }
    }
    private void setInput() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        turns = new int[T];
        publicSpace = new HashSet<>();
        people = new Person[N + 1];
        for (int i = 0; i <= N; i++) {
            people[i] = new Person();
        }
        st = new StringTokenizer(input.readLine());
        for (int i = 0; i < T; i++) {
            turns[i] = Integer.parseInt(st.nextToken());
        }
        cards = new Card[T];
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(input.readLine());
            int id = Integer.parseInt(st.nextToken());
            String oper = st.nextToken();
            cards[i] = new Card(id, oper);
            if (!"next".equals(oper)) {
                int num = Integer.parseInt(st.nextToken());
                cards[i].setNum(num);
            }
        }
    }
}

class Person {
    private Card ownCard;
    private Set<Integer> ownNums;
    public Person() {
        ownNums = new HashSet<>();
    }

    public Card getOwnCard() {
        return ownCard;
    }
    public boolean hasCard() {
        return ownCard != null;
    }

    public void updateCard(Card card) {
        this.ownCard = card;
    }
    public void deleteCard() {
        ownCard = null;
    }
    public void addNums(int num) {
        this.ownNums.add(num);
    }

    public void deleteNum(int num) {
        ownNums.remove(num);
    }
}
class Card {
    private int id, num;
    private String oper;

    public Card(int id, String oper) {
        this.id = id;
        this.oper = oper;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getId() {
        return id;
    }

    public int getNum() {
        return num;
    }

    public String getOper() {
        return oper;
    }
}
public class BOJ21775_가희와자원놀이 {
    public static void main(String[] args) throws IOException {
        Solve solve = Solve.getInstance();
        solve.process();
    }
}
