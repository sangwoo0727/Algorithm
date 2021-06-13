import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solve {
    private List<List<String>> logFiles;
    private BufferedReader input;
    private StringBuilder output = new StringBuilder();
    private int N, Q;
    private String start, end;
    private int level;
    private static Solve solve;

    public static Solve getInstance() {
        if (solve == null) {
            solve = new Solve();
        }
        return solve;
    }

    public void processing() throws IOException {
        setLogFiles();
        setInput();
        processQuery();
        printAnswer();
    }
    private void printAnswer() {
        System.out.println(this.output);
    }
    private void processQuery() throws IOException {
        for (int i = 0; i < Q; i++) {
            int ans = 0;
            String query = input.readLine();
            parsingQuery(query);
            for (int lev = 1; lev <= 6; lev++) {
                if (logFiles.get(lev).size() == 0) continue;
                if (this.level > lev) continue;
                int findStart = lowerBound(this.start, lev);
                int findEnd = upperBound(this.end, lev);
                if (findEnd - findStart >= 0) {
                    ans += (findEnd - findStart);
                }
            }
            output.append(ans).append("\n");
        }
    }

    private int upperBound(String key, int lev) {
        int size = logFiles.get(lev).size();
        int l = 0, r = size - 1;
        int result = size;
        while (l <= r) {
            int m = (l + r) / 2;
            if (logFiles.get(lev).get(m).compareTo(key) <= 0) {
                l = m + 1;
            } else {
                result = m;
                r = m - 1;
            }
        }
        return result;
    }
    private int lowerBound(String key, int lev) {
        int size = logFiles.get(lev).size();
        int l = 0, r = size - 1;
        int result = size;
        while (l <= r) {
            int m = (l + r) / 2;
            if (logFiles.get(lev).get(m).compareTo(key) < 0) {
                l = m + 1;
            } else {
                result = m;
                r = m - 1;
            }
        }
        return result;
    }
    private void parsingQuery(String query) {
        String[] splits = query.split("[- :#]");
        StringBuilder start = new StringBuilder();
        StringBuilder end = new StringBuilder();
        int level = 0;
        for (int i = 0; i < splits.length; i++) {
            if (i == splits.length - 1) {
                level = Integer.parseInt(splits[i]);
                continue;
            }
            if (i <= 5) {
                start.append(splits[i]);
            } else {
                end.append(splits[i]);
            }
        }
        this.start = start.toString();
        this.end = end.toString();
        this.level = level;
    }
    private void setLogFiles() {
        this.logFiles = new ArrayList<>();
        for (int i = 0; i <= 6; i++) {
            logFiles.add(new ArrayList<>());
        }
    }
    private void setInput() throws IOException {
        input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        this.N = Integer.parseInt(st.nextToken());
        this.Q = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            String log = input.readLine();
            setLogIntoLogFiles(log);
        }
    }

    private void setLogIntoLogFiles(String log) {
        String[] splits = log.split("[- :#]");
        int level = Integer.parseInt(splits[splits.length - 1]);
        StringBuilder dateLog = new StringBuilder();
        for (int i = 0; i < splits.length - 1; i++) {
            dateLog.append(splits[i]);
        }
        logFiles.get(level).add(dateLog.toString());
    }
}
public class BOJ21774_가희와로그파일 {
    public static void main(String[] args) throws IOException {
        Solve solve = Solve.getInstance();
        solve.processing();
    }
}
