import java.util.*;
import java.io.*;

class Node{
	int n;
	int m;
	Node(int n, int m){
		this.n = n;
		this.m = m;
	}
}
class Door{
	int n;
	int m;
	char alp;
	Door(int n, int m, char alp){
		this.n = n;
		this.m = m;
		this.alp = alp;
	}
}
public class Solution {
	static boolean[] alp;
	static char[][] bd;
	static boolean[][] ck;
	static int[] dc = {-1,1,0,0};
	static int[] dr = {0,0,-1,1};
	static int ans;
	static int H,W;
	
	static boolean inner(int n, int m) {
		if(n<=0 || n>=H-1 || m<=0 || m>=W-1 || ck[n][m] || bd[n][m]=='*') 
			return false;
		else return true;
	}
	static void initGame(Queue<Node> gq, ArrayList<Door> aq) { //게임 시작은 테두리에서만
		for(int w=0; w<W; w++) {
			if(bd[0][w]=='.' || bd[0][w]=='$') {
				gq.add(new Node(0,w));
			}else if(bd[0][w]-'a'>=0 && bd[0][w]-'a'<=25) {
				alp[bd[0][w]-'a'] = true;
				gq.add(new Node(0,w));
			}else if(bd[0][w]-'A'>=0 && bd[0][w]-'A'<=25){
				if(alp[bd[0][w]-'A']) {
					gq.add(new Node(0,w));
				}else {
					aq.add(new Door(0,w,bd[0][w]));
				}
			}
			
			if(bd[H-1][w]=='.' || bd[H-1][w]=='$') {
				gq.add(new Node(H-1,w));
			}else if(bd[H-1][w]-'a'>=0 && bd[H-1][w]-'a'<=25) {
				alp[bd[H-1][w]-'a'] = true;
				gq.add(new Node(H-1,w));
			}else if(bd[H-1][w]-'A'>=0 && bd[H-1][w]-'A'<=25){
				if(alp[bd[H-1][w]-'A']) {
					gq.add(new Node(H-1,w));
				}else {
					aq.add(new Door(H-1,w,bd[H-1][w]));
				}
			}
		}
		for(int h=1;h<H-1;h++) {
			if(bd[h][0]=='.' || bd[h][0]=='$') {
				gq.add(new Node(h,0));
			}else if(bd[h][0]-'a'>=0 && bd[h][0]-'a'<=25) {
				alp[bd[h][0]-'a'] = true;
				gq.add(new Node(h,0));
			}else if(bd[h][0]-'A'>=0 && bd[h][0]-'A'<=25){
				if(alp[bd[h][0]-'A']) {
					gq.add(new Node(h,0));
				}else {
					aq.add(new Door(h,0,bd[h][0]));
				}
			}
			
			if(bd[h][W-1]=='.' || bd[h][W-1]=='$') {
				gq.add(new Node(h,W-1));
			}else if(bd[h][W-1]-'a'>=0 && bd[h][W-1]-'a'<=25) {
				alp[bd[h][W-1]-'a'] = true;
				gq.add(new Node(h,W-1));
			}else if(bd[h][W-1]-'A'>=0 && bd[h][W-1]-'A'<=25){
				if(alp[bd[h][W-1]-'A']) {
					gq.add(new Node(h,W-1));
				}else {
					aq.add(new Door(h,W-1,bd[h][W-1]));
				}
			}
			
		}
	}
	
	static void bfs() {
		Queue <Node> gq = new LinkedList<>();
		ArrayList <Door> aq = new ArrayList<>();
		initGame(gq,aq);
		
		while(!gq.isEmpty()) {
			Node cur = gq.poll();
			if(bd[cur.n][cur.m]=='$') {
				ans++;
			}else if(bd[cur.n][cur.m]-'a' >=0 && bd[cur.n][cur.m]-'a'<=25) {
				if(!alp[bd[cur.n][cur.m]-'a']) {
					alp[bd[cur.n][cur.m]-'a']=true;
				}
				for(int i=0; i<aq.size();i++) {
					if(aq.get(i).alp-'A'== bd[cur.n][cur.m]-'a') {
						gq.add(new Node(aq.get(i).n, aq.get(i).m));
					}
				}
			}else if(bd[cur.n][cur.m]-'A' >=0 && bd[cur.n][cur.m]-'A'<=25) {
				if(!alp[bd[cur.n][cur.m]-'A']) {
					aq.add(new Door(cur.n,cur.m,bd[cur.n][cur.m]));					
				}
			}
			ck[cur.n][cur.m]= true;
			for(int k=0; k<4; k++) {
				int nn = cur.n+dc[k];
				int nm = cur.m+dr[k];
				if(inner(nn,nm)) {
					if(bd[nn][nm]=='.' || bd[nn][nm]=='$') {
						gq.add(new Node(nn,nm));
						ck[nn][nm]=true;
					}
					else if(bd[nn][nm]-'a'>=0 && bd[nn][nm]-'a'<=25) {
						alp[bd[nn][nm]-'a']=true;
						for(int i=0; i<aq.size();i++) {
							if(aq.get(i).alp-'A'== bd[nn][nm]-'a') {
								gq.add(new Node(aq.get(i).n, aq.get(i).m));
								gq.add(new Node(nn,nm));
								ck[nn][nm]=true;
								ck[aq.get(i).n][aq.get(i).m]= true;
							}
						}
					}
					else {
						if(alp[bd[nn][nm]-'A']) {
							gq.add(new Node(nn,nm));
							ck[nn][nm]=true;
						}else {
							aq.add(new Door(nn,nm,bd[nn][nm]));
						}
					}
				}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			ans = 0;
			alp = new boolean[26];
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			bd = new char[H+1][W+1];
			ck = new boolean[H+1][W+1];
			for(int h=0; h<H; h++) {
				String[] s = br.readLine().split("");
				for(int w=0; w<W; w++) {
					bd[h][w] = s[w].charAt(0);
				}
			}
			char[] ac = br.readLine().toCharArray();
			if(ac[0]!='0') {
				for(int l=0; l<ac.length; l++) {
					alp[ac[l]-'a'] = true;
				}
			}
			bfs();
			System.out.println(ans);
		}
	}
}