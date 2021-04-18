import java.io.*;
import java.util.*;

public class BOJ9202_Boggle {
    private static int[][] d = {
            {-1, -1, -1, 0, 0, 1, 1, 1},
            {-1, 0, 1, -1, 1, -1, 0, 1}
    };
    private static Trie trie;
    private static Set<String> set;
    private static boolean[][] visit;
    private static char[][] board;
    private static int[] score = {0, 0, 0, 1, 1, 2, 3, 5, 11};
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int w = Integer.parseInt(input.readLine());
        trie = new Trie();
        for (int i = 0; i < w; i++) {
            String word = input.readLine();
            trie.insert(word);
        }
        StringBuilder output = new StringBuilder();
        String blank = input.readLine();
        int b = Integer.parseInt(input.readLine());
        board = new char[4][4];
        for (int k = 0; k < b; k++) {
            set = new TreeSet<>((o1, o2) -> {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return -(o1.length() - o2.length());
            });
            for (int i = 0; i < 4; i++) {
                String line = input.readLine();
                board[i] = line.toCharArray();
            }
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    visit = new boolean[4][4];
                    visit[i][j] = true;
                    String word = "" + board[i][j];
                    dfs(i, j, word);
                    visit[i][j] = false;
                }
            }
            String maxWord = "";
            int sum = 0;
            boolean flag = false;
            for (String s : set) {
                if (!flag) {
                    maxWord = s;
                    flag = true;
                }
                sum += score[s.length()];
            }
            output.append(sum).append(" ").append(maxWord).append(" ").append(set.size()).append("\n");
            if (k != b - 1) {
                blank = input.readLine();
            }
        }
        System.out.println(output);
    }

    private static void dfs(int n, int m, String word) {
        if (word.length() > 8) return;
        int flag = trie.contains(word);
        if (flag == 1) {
            set.add(word);
        }
        if (flag == -1) return;
        for (int k = 0; k < 8; k++) {
            int nn = n + d[0][k];
            int nm = m + d[1][k];
            if (inner(nn, nm) && !visit[nn][nm]) {
                visit[nn][nm] = true;
                dfs(nn, nm, word + board[nn][nm]);
                visit[nn][nm] = false;
            }
        }
    }
    private static class TrieNode {
        Map<Character, TrieNode> childNodes = new HashMap<>();
        boolean isLast;
    }

    private static class Trie {
        TrieNode root;
        Trie() {
            root = new TrieNode();
        }
        void insert(String word) {
            TrieNode thisNode = this.root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!thisNode.childNodes.containsKey(c)) {
                    thisNode.childNodes.put(c, new TrieNode());
                }
                thisNode = thisNode.childNodes.get(c);
            }
            thisNode.isLast = true;
        }

        int contains(String word) {
            TrieNode thisNode = this.root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                TrieNode node = thisNode.childNodes.get(c);
                if (node == null) {
                    return -1;
                }
                thisNode = node;
            }
            if (thisNode.isLast) {
                return 1;
            }
            return 0;
        }
    }

    private static boolean inner(int n, int m) {
        return 0 <= n && n < 4 && 0 <= m && m < 4;
    }
}
