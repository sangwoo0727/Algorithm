import java.util.*;

public class LeetCode_22_GenerateParentheses {
    static List<String> output;
    static Deque<Character> stack;
    static StringBuilder sb;
    public List<String> generateParenthesis(int n) {
        output = new ArrayList<>();
        stack = new ArrayDeque<>();
        sb = new StringBuilder();
        comb(0,0,n);
        return output;
    }
    static void comb(int left,int right, int n){
        if(left == n && right == n){
            output.add(sb.toString());
            return;
        }
        if(left < n){
            stack.add('(');
            sb.append('(');
            comb(left+1, right, n);
            stack.poll();
            sb.deleteCharAt(sb.length()-1);
        }
        if(right < n){
            if(stack.size()> right){
                sb.append(')');
                comb(left,right+1,n);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}
