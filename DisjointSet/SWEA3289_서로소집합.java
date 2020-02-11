import java.io.*;
import java.util.*;
 
public class SWEA3289_서로소집합 {
    static int[] root;
    static int N,M;
    public static void init() {
        root = new int[N+1];
        for(int i=1; i<=N; i++) {
            root[i] = i;
        }
    }
    public static int find(int n) {
        if(n==root[n]) return n;
        else {
            return root[n] = find(root[n]);
        }
    }
    public static void merge(int n, int m) {
        n = find(n);
        m = find(m);
        if(n != m) {
            root[m]=n;
        }
         
    }
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            sb.append("#").append(t).append(" ");
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            init();
            while(M-->0) {
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());
                int n = Integer.parseInt(st.nextToken());
                int m = Integer.parseInt(st.nextToken());
                if(c==0) {
                    merge(n,m);
                }else {
                    if(find(n)==find(m))
                        sb.append(1);
                    else
                        sb.append(0);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
