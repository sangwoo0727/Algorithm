import java.io.*;
import java.util.*;

public class BOJ1629_곱셈 {
    static long A, B, C;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());
        System.out.println(func(A, B));
    }
    static long func(long A, long B){
        if (B==0) return 1 % C;
        if (B==1) return A % C;
        long tmp = func(A, B/2) % C;
        if (B%2!=0){
            return ((tmp * tmp) % C * (A % C)) % C;
        }else{
            return (tmp * tmp) % C;
        }
    }
}
