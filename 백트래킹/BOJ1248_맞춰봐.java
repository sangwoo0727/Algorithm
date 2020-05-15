import java.io.*;

public class BOJ1248_맞춰봐 {
	static StringBuilder sb = new StringBuilder();
	static char[][] s;
	static int[] arr;
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		s = new char[N][N];
		arr = new int[N];
		String str = br.readLine();
		int tmp=0, idx=0;
		for(int i=0; i<N*(N+1)/2; i++) {
			for(int j=tmp; j<N; j++) {
				s[i][j] = str.charAt(idx++);
			}
			tmp++;
		}
		solve(0);
		System.out.println(sb);
	}
	static void solve(int r) {
		if(sb.length()!=0) return;
		if(r==N) {
			for(int i=0; i<N; i++) {
				sb.append(arr[i]).append(" ");
			}
			return;
		}
		for(int i=-10; i<=10; i++) {
			arr[r] = i;
			if(check(r)) solve(r+1);
		}
	}
	static boolean check(int r) {
		int sum = 0;
		for(int i=r; i>=0; i--) {
			sum+=arr[i];
			if(s[i][r] == '+' && sum <=0) return false;
			if(s[i][r] == '-' && sum >=0) return false;
			if(s[i][r] == '0' && sum != 0) return false;
		}
		return true;
	}
}
