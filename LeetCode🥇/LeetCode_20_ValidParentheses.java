import java.util.*;

public class LeetCode_20_ValidParentheses {
    public boolean isValid(String s){
        Map<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        Deque<Character> stack = new ArrayDeque<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                if (stack.isEmpty()) return false;
                char top = stack.peek();
                if (map.get(c) == top){
                    stack.poll();
                }else {
                    return false;
                }
            }else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
