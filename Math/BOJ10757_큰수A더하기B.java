import java.io.*;
import java.math.*;
import java.util.*;
public class BOJ10757_큰수A더하기B {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BigInteger a1 = new BigInteger(st.nextToken());
		BigInteger a2 = new BigInteger(st.nextToken());
		System.out.println(a1.add(a2));
	}
}
