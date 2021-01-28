import java.util.*;
import java.io.*;

public class BOJ1158_요세푸스문제 {
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        for (int i=1; i<=n; i++) q.add(i);
        int cnt = 0;
        StringBuilder output = new StringBuilder();
        output.append("<");
        while (!q.isEmpty()){
            cnt++;
            int now = q.poll();
            if (cnt==k){
                output.append(now);
                if (q.size()!=0) output.append(", ");
                cnt=0;
            }else{
                q.add(now);
            }
        }
        output.append(">");
        System.out.println(output);
    }
}
