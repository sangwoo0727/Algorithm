import java.io.*;
import java.util.*;

public class BOJ1987_알파벳 {
    static int R,C;
    static char[][] bd;
    static int[][] d = {{0,0,-1,1},{1,-1,0,0}};
    static int ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        bd = new char[R][C];
        for(int i=0; i<R; i++){
            bd[i] = br.readLine().toCharArray();
        }
        int bit = 0;
        bit |= (1<<(bd[0][0]-'A'));
        dfs(0,0, bit,1);
        System.out.println(ans);
    }
    static void dfs(int n,int m, int bit,int cnt){
        ans = Math.max(ans,cnt);
        for(int k=0; k<4; k++){
            int nn = n+d[0][k];
            int nm = m+d[1][k];
            if(inner(nn,nm) && (bit&(1<<(bd[nn][nm]-'A')))==0){
                dfs(nn,nm,bit|(1<<(bd[nn][nm]-'A')),cnt+1);
            }
        }
    }
    static boolean inner(int n,int m){
        return 0<=n && n<R && 0<=m && m<C;
    }
}
