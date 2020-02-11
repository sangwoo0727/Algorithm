import java.io.*;
import java.util.*;
 
public class SWEA4408_자기방으로돌아가기 {
    static int Max;
    static int N;
    static PriorityQueue<Integer> pq;
    static ArrayList<Pair> list;
     
    static class Pair implements Comparable<Pair>{
        int x;
        int y;
        Pair(int x, int y){
            this.x =x;
            this.y=y;
        }
        @Override
        public int compareTo(Pair p1) {
            return this.x - p1.x;
        }
    }
    public static void init() {
        Max = Integer.MIN_VALUE;
        pq = new PriorityQueue<>();
        list = new ArrayList<>();
    }
    public static void main(String[] args) throws Exception {
         
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            init();
            N = Integer.parseInt(br.readLine());
            for(int n=0; n<N; n++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                if(s>e) {
                    int tmp = s; s=e; e=tmp; 
                }
                list.add(new Pair(s,e));
            }
            Collections.sort(list);
            for(int n=0; n<N; n++) {
                int s = list.get(n).x;
                int e = list.get(n).y;
                if(pq.isEmpty()) pq.offer(e);
                else {
                    if(s%2==0) s-=1;
                    if(pq.peek() < s) {
                        pq.poll();
                        pq.add(e);
                    }else {
                        pq.add(e);
                    }
                }
                Max = Math.max(pq.size(), Max);
            }
            sb.append("#").append(t).append(" ").append(Max).append("\n");
        }
        System.out.println(sb);
    }
}
