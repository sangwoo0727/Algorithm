import java.io.*;
import java.util.*;
 
public class SWEA3234_준환이의양팔저울 {
    public static int N,sum;
    public static long ans;
    public static int[] input,fac,pow;
    public static boolean[] check;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        fac = new int[10];
        pow = new int[10];
        fac[0]=1;
        pow[0]=1;
        for(int i=1; i<10; i++) {
        	fac[i] = i*fac[i-1];
        	pow[i] = 2*pow[i-1];
        }
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
        	sb.append("#").append(t).append(" ");
            N = Integer.parseInt(br.readLine());
            ans = sum = 0;
            input = new int[N];
            check = new boolean[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                input[i] = Integer.parseInt(st.nextToken());
                sum += input[i];
            }
            permu(0, 0, 0);
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
    public static void permu(int l, int r, int idx) {
        if (idx == N) {
            ans++;
            return;
        }
        if (l >= sum-l) {
            ans += fac[N-idx] * pow[N-idx];
            return;
        }
        for (int i = 0; i < N; i++) {
            if (check[i]) continue;
            check[i] = true;
            permu(l + input[i], r, idx + 1);
            if (l >= r + input[i])
                permu(l, r + input[i], idx + 1);
            check[i] = false;
        }
    }
 
}
