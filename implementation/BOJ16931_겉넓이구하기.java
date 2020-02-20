import java.io.*;
import java.util.*;
 
public class Main{
	static int[][] arr;
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = null;
    	int TC = Integer.parseInt(br.readLine());
    	for(int tc=1; tc<=TC; tc++) {
    		st = new StringTokenizer(br.readLine());
    		int N = Integer.parseInt(st.nextToken());
    		int t = Integer.parseInt(st.nextToken()); //initial temp
    		int d = 0; //day
    		int leftt = t, rightt = t;
    		arr = new int[3][N];
    		boolean flg = false;
    		for(int n=0; n<N; n++) {
    			st = new StringTokenizer(br.readLine());
    			arr[0][n] = Integer.parseInt(st.nextToken()); //방문 시간
    			arr[1][n] = Integer.parseInt(st.nextToken()); 
    			arr[2][n] = Integer.parseInt(st.nextToken());
    			
    		}
    		for(int n=0; n<N; n++) {
    			int range = arr[0][n] - d;
    			leftt = leftt - range;
    			rightt = rightt + range;
    			if(rightt < arr[1][n] || arr[2][n] < leftt) {
    				sb.append("NO").append("\n");
    				flg = true;
    				break;
    			}else {
    				if(leftt <= arr[1][n] && arr[2][n]<= rightt) {
    					leftt = arr[1][n];
    					rightt = arr[2][n];
    				}else if(leftt <= arr[1][n] && rightt <= arr[2][n]) {
    					leftt = arr[1][n];
    				}else if(arr[1][n] <= leftt && arr[2][n] <= rightt) {
    					rightt = arr[2][n];
    				}
    			}
    			d = arr[0][n];
    		}
    		if(!flg) sb.append("YES").append("\n");
    	}
    	System.out.println(sb);
    }
}