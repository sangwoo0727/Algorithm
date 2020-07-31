import java.io.*;

public class BOJ6359_만취한상범 {
    static int[][] door = new int[101][101];
    public static void main(String[] args) throws IOException {
        for(int i=1; i<=100; i++){
            for(int j=1; j<=100; j++){
                if(j%i==0){
                    if(door[i-1][j]==0) door[i][j]=1;
                    else door[i][j] = 0;
                }else door[i][j] = door[i-1][j];
            }
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            int ans = 0;
            for(int i=1; i<=n; i++){
                if(door[n][i]==1) ans++;
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
