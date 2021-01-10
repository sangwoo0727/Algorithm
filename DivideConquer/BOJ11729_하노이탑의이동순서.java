import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BOJ11729_하노이탑의이동순서 {
    static int N;
    static List<Pair> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(input.readLine());
        hanoi(N, 1, 2, 3);
        StringBuilder output = new StringBuilder();
        output.append(list.size()).append("\n");
        for (int i = 0; i < list.size(); i++) {
            output.append(list.get(i).begin).append(" ").append(list.get(i).end).append("\n");
        }
        System.out.println(output);
    }

    static void hanoi(int n, int begin, int mid, int end) {
        if (n == 1) {
            list.add(new Pair(begin, end));
        }
        else {
            hanoi(n - 1, begin, end, mid);
            list.add(new Pair(begin, end));
            hanoi(n - 1, mid, begin, end);
        }
    }

    static class Pair{
        int begin, end;
        Pair(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }
    }
}
