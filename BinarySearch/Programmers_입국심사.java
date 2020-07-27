import java.util.*;
public class Programmers_입국심사 {
    public long solution(int n, int[] times){
        long ans =0;
        Arrays.sort(times);
        long l = 1, r = (long)times[times.length-1]*(long)n;
        while (l<=r) {
            long m = (l+r)/2;
            long sum = 0;
            for(int time : times){
                sum += m/time;
            }
            if(sum < n) l = m+1;
            else{
                ans = m;
                r = m-1;
            }
        }
        return ans;
    }
}
