import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1991_트리순회 {
    private static int N;
    private static Tree tree;
    private static StringBuilder output;
    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
    private static void solve() {
        output = new StringBuilder();
        tree.preOrder(tree.root);
        output.append("\n");
        tree.inOrder(tree.root);
        output.append("\n");
        tree.postOrder(tree.root);
        System.out.println(output);
    }
    private static void input() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(input.readLine());
        tree = new Tree();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            char a = st.nextToken().charAt(0);
            char b = st.nextToken().charAt(0);
            char c = st.nextToken().charAt(0);
            tree.addNode(a, b, c);
        }
    }

    private static class Tree {
        private Node root;

        void addNode(char rootVal, char leftVal, char rightVal) {
            if (this.root == null) {
                this.root = new Node();
                this.root.val = rootVal;
                if (leftVal != '.') {
                    Node left = new Node();
                    left.val = leftVal;
                    this.root.left = left;
                }
                if (rightVal != '.') {
                    Node right = new Node();
                    right.val = rightVal;
                    this.root.right = right;
                }
            } else {
                this.search(this.root, rootVal, leftVal, rightVal);
            }
        }

        void search(Node root, char rootVal, char leftVal, char rightVal) {
            if (root == null) {
                return;
            }
            if (root.val == rootVal) {
                if (leftVal != '.') {
                    Node left = new Node();
                    left.val = leftVal;
                    root.left = left;
                }
                if (rightVal != '.') {
                    Node right = new Node();
                    right.val = rightVal;
                    root.right = right;
                }
                return;
            }
            search(root.left, rootVal, leftVal, rightVal);
            search(root.right, rootVal, leftVal, rightVal);
        }

        void preOrder(Node node) {
            output.append(node.val);
            if (node.left != null) {
                preOrder(node.left);
            }
            if (node.right != null) {
                preOrder(node.right);
            }
        }

        void inOrder(Node node) {
            if (node.left != null) {
                inOrder(node.left);
            }
            output.append(node.val);
            if (node.right != null) {
                inOrder(node.right);
            }
        }

        void postOrder(Node node) {
            if (node.left != null) {
                postOrder(node.left);
            }
            if (node.right != null) {
                postOrder(node.right);
            }
            output.append(node.val);
        }
    }
    private static class Node {
        char val;
        Node left;
        Node right;
    }
}
