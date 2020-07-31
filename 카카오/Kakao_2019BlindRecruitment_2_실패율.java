import java.util.*;

public class Kakao_2019BlindRecruitment_2_실패율 {
    static class Pair{
        int n; double score;
        Pair(int n,double score) {
            this.n = n; this.score = score;
        }
    }
    public static int[] solution(int N, int[] stages) {
        int[] ans = new int[N];
        int sum = stages.length;
        int[] bd = new int[N+2];
        List<Pair> list = new ArrayList<>();
        for (int stage : stages) {
            bd[stage]++;
        }
        for(int i=1; i<=N; i++){
            if(bd[i] == 0) list.add(new Pair(i,0));
            else list.add(new Pair(i, (double)bd[i]/sum));
            sum -= bd[i];
        }
        list.sort((o1, o2) -> {
            if (o2.score == o1.score) return Integer.compare(o1.n, o2.n);
            return -Double.compare(o1.score, o2.score);
        });
        for(int i=0; i<list.size(); i++){
            ans[i] = list.get(i).n;
        }
        return ans;
    }
}
