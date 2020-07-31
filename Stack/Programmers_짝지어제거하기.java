import java.util.*;

public class Programmers_짝지어제거하기 {
    public int solution(String s){
        Deque<Character> st = new ArrayDeque<>();
        for(char c: s.toCharArray()){
            if(st.isEmpty()) st.addLast(c);
            else{
                if(st.peekLast() == c) st.pollLast();
                else st.addLast(c);
            }
        }
        return st.size()==0? 1: 0;
    }
}
