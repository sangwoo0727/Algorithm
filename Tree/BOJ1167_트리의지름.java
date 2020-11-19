import java.io.*;
import java.util.*;

public class BOJ1167_트리의지름 {
    static List<Node>[] list;
    static boolean[] visit;
    static int N, max, maxNode;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visit = new boolean[N+1];
        list = new ArrayList[N+1];
        for (int i=1; i<=N; i++){
            list[i] = new ArrayList<>();
        }
        for (int n=0; n<N; n++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startNode = Integer.parseInt(st.nextToken());
            while (true){
                int adjNode = Integer.parseInt(st.nextToken());
                if (adjNode == -1) break;
                int dist = Integer.parseInt(st.nextToken());
                list[startNode].add(new Node(adjNode, dist));
            }
        }
        dfs(1,0);
        max = 0;
        visit = new boolean[N+1];
        dfs(maxNode, 0);
        System.out.println(max);
    }
    static void dfs(int n,int dist){
        visit[n] = true;
        if (dist > max){
            max = dist;
            maxNode = n;
        }
        for (int i=0; i<list[n].size(); i++){
            Node node = list[n].get(i);
            if (!visit[node.num]){
                visit[node.num] = true;
                dfs(node.num , dist + node.dist);
            }
        }
    }
    static class Node{
        int num;
        int dist;
        Node(int num, int dist){
            this.num = num;
            this.dist = dist;
        }
    }
}
