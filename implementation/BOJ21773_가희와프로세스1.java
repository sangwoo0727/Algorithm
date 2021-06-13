import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Solve {
    private PriorityQueue<Process> q;
    private int T, N;
    private static Solve solve;
    private StringBuilder output;

    public static Solve getInstance() {
        if (solve == null) {
            solve = new Solve();
        }
        return solve;
    }

    public void processing() throws IOException {
        setQueue();
        setInput();
        startSchedule();
        printAnswer();
    }
    private void printAnswer() {
        System.out.println(output);
    }
    private void startSchedule() {
        for (int t = 1; t <= T; t++) {
            Process now = q.poll();
            output.append(now.id).append("\n");
            now.executeTime -= 1;
            now.priority -= 1;
            if (now.executeTime != 0) {
                q.add(now);
            }
        }
    }
    private void setQueue() {
        this.q = new PriorityQueue<>((o1, o2) -> {
            if (o1.priority == o2.priority) {
                return o1.id - o2.id;
            }
            return -(o1.priority - o2.priority);
        });
    }
    private void setInput() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        this.T = Integer.parseInt(st.nextToken());
        this.N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(input.readLine());
            int id = Integer.parseInt(st.nextToken());
            int excuteTime = Integer.parseInt(st.nextToken());
            int priority = Integer.parseInt(st.nextToken());
            q.add(new Process(id, excuteTime, priority));
        }
        output = new StringBuilder();
    }
}

class Process {
    int id;
    int executeTime;
    int priority;

    Process(int id, int executeTime, int priority) {
        this.id = id;
        this.executeTime = executeTime;
        this.priority = priority;
    }
}
public class BOJ21773_가희와프로세스1 {
    public static void main(String[] args) throws IOException {
        Solve solve = Solve.getInstance();
        solve.processing();
    }
}
