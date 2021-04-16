import java.io.*;
import java.util.*;

public class BOJ5052_전화번호목록 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(input.readLine());
        StringBuilder output = new StringBuilder();
        for (int t = 1; t <= tc; t++) {
            int n = Integer.parseInt(input.readLine());
            Trie trie = new Trie();
            String[] nums = new String[n];
            for (int i = 0; i < n; i++) {
                nums[i] = input.readLine();
                trie.insert(nums[i]);
            }
            boolean flag = false;
            for (String num : nums) {
                flag = trie.contains(num);
                if (flag){
                    break;
                }
            }
            output.append(flag ? "NO" : "YES").append("\n");
        }
        System.out.println(output);
    }
    private static class Trie {
        private TrieNode rootNode;
        public Trie() {
            this.rootNode = new TrieNode();
        }
        private void insert(String word) {
            TrieNode thisNode = this.rootNode;
            for (int i = 0; i < word.length(); i++) {
                thisNode = thisNode.getChildNodes()
                        .computeIfAbsent(word.charAt(i), c -> new TrieNode());
            }
            thisNode.isLastChar = true;
        }

        private boolean contains(String word) {
            TrieNode thisNode = this.rootNode;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                TrieNode node = thisNode.getChildNodes().get(c);
                if (node == null) {
                    return false;
                }
                thisNode = node;
            }
            return thisNode.isLastChar && !thisNode.childNodes.isEmpty();
        }
    }
    private static class TrieNode {
        private Map<Character, TrieNode> childNodes = new HashMap<>();
        private boolean isLastChar;

        public Map<Character, TrieNode> getChildNodes() {
            return this.childNodes;
        }
    }

}
