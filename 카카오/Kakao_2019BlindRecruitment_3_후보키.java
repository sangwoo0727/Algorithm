import java.util.*;
public class Kakao_2019BlindRecruitment_3_후보키 {
    static List<Integer> bList = new ArrayList<>();
    public static int solution(String[][] relation){
        int N = relation.length;
        int M = relation[0].length;
        for(int bit=1; bit<(1<<M); bit++){
            bList.add(bit);
        }
        bList.sort((o1, o2) -> {
            int cnt1 = 0, cnt2 = 0;
            for(int i=0; i<M; i++){
                if((o1&(1<<i))>0) cnt1++;
                if((o2&(1<<i))>0) cnt2++;
            }
            return cnt1 == cnt2 ? o1.compareTo(o2) : Integer.compare(cnt1,cnt2);
        });
        List<Integer> list = new ArrayList<>();
        label : for(Integer bit : bList){
            for(Integer n : list){
                if((bit&n) == n){
                    continue label;
                }
            }
            Set<String> set = new HashSet<>();
            for (String[] string : relation) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < M; i++) {
                    if ((bit & (1 << i)) > 0) sb.append(string[i]).append(" ");
                }
                set.add(sb.toString());
            }
            if(set.size() == N) list.add(bit);
        }
        return list.size();
    }
}
