import java.util.*;
public class Programmers_완주하지못한선수 {
    static HashMap<String,Integer> map = new HashMap<>();
    public String solution(String[] participant, String[] completion){
        String answer = "";
        for(String comp : completion){
            map.put(comp, map.getOrDefault(comp,0)+1);
        }
        for(String part : participant){
            if(map.containsKey(part) && map.get(part)>=1) {
                map.put(part, map.get(part)-1);
                continue;
            }
            answer = part;
            break;
        }
        return answer;
    }
}
