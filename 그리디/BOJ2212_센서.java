import java.io.*;
import java.util.*;

public class BOJ2212_센서 {
    static int N, K;
    static int[] sensor;
    static int[] diff;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(input.readLine());
        K = Integer.parseInt(input.readLine());
        sensor = new int[N];
        diff = new int[N - 1];
        StringTokenizer st = new StringTokenizer(input.readLine());
        for (int i=0; i<N; i++){
            sensor[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sensor);
        for (int i=0; i<N-1; i++){
            diff[i] = sensor[i+1] - sensor[i];
        }
        Arrays.sort(diff);
        int sum = 0;
        for (int i=0; i<N-K; i++){
            sum += diff[i];
        }
        System.out.println(sum);
    }
}
