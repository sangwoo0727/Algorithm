import java.util.*;
public class Programmers_최댓값과최솟값 {
    public String solution(String s){
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(s, " ");
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        while(st.hasMoreTokens()){
            int n = Integer.parseInt(st.nextToken());
            min = Math.min(min,n);
            max = Math.max(max,n);
        }
        sb.append(min).append(" ").append(max);
        return sb.toString();
    }
}
