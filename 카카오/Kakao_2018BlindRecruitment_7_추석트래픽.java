import java.util.*;

public class Kakao_2018BlindRecruitment_7_추석트래픽 {
    public static int solution(String[] lines) {
        StringTokenizer st;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<Pair> list = new ArrayList<>();
        for(String line: lines){
            st = new StringTokenizer(line, " :s");
            String date = st.nextToken();
            int hours = Integer.parseInt(st.nextToken())*3600000;
            int minutes = Integer.parseInt(st.nextToken())*60000;
            int seconds = (int) (Double.parseDouble(st.nextToken())*1000);
            int length = (int) (Double.parseDouble(st.nextToken())*1000);
            list.add(new Pair(hours+minutes+seconds-length+1, hours+minutes+seconds));
        }
        list.sort((o1, o2) -> Integer.compare(o1.left,o2.left));

        int answer = 0;
        int time = list.get(0).left;
        for(Pair p: list){
            if(p.left>time+999){
                while (!pq.isEmpty() && pq.peek()+999 <p.left){
                    pq.poll();
                }
                if(pq.size()>0) time = pq.peek();
                else time = p.left;
            }
            pq.offer(p.right);
            answer = Math.max(answer,pq.size());
        }
        return answer;
    }
    static class Pair{
        int left,right;
        Pair(int left,int right){
            this.left = left;
            this.right = right;
        }
    }
}
