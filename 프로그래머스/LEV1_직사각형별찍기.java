import java.util.*;

public class LEV1_직사각형별찍기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        StringBuilder output = new StringBuilder();
        for(int i=0; i<b; i++){
            output.append("*".repeat(Math.max(0, a)));
            output.append("\n");
        }
        System.out.print(output);
    }
}
