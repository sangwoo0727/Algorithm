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
		return 0<n && n<H-1 && 0<m && m<W-1 && !ck[n][m] && bd[n][m]!='*';
	}
	
	static void initGame(Queue<Node> gq, ArrayList<Door> aq) { //게임 시작은 테두리에서만
		for(int w=0; w<W; w++) {
			char ch1 = bd[0][w], ch2 = bd[H-1][w];
			if(ch1=='.' || ch1=='$') {
				gq.add(new Node(0,w));
			}else if( 'a' <= ch1 && ch1 <= 'z') {
				alp[ch1-'a'] = true;
				gq.add(new Node(0,w));
			}else if( 'A' <= ch1 && ch1 <= 'Z'){
				if(alp[ch1-'A']) {
					gq.add(new Node(0,w));
				}else {
					aq.add(new Door(0,w,ch1));
				}
			}
			
			if(ch2=='.' || ch2=='$') {
				gq.add(new Node(H-1,w));
			}else if( 'a' <= ch2 && ch2 <= 'z') {
				alp[ch2-'a'] = true;
				gq.add(new Node(H-1,w));
			}else if('A'<= ch2 && ch2 <= 'Z'){
				if(alp[ch2-'A']) {
					gq.add(new Node(H-1,w));
				}else {
					aq.add(new Door(H-1,w,ch2));
				}
			}
		}
		for(int h=1;h<H-1;h++) {
			char ch1 = bd[h][0], ch2 = bd[h][W-1];
			if(ch1=='.' || ch1=='$') {
				gq.add(new Node(h,0));
			}else if( 'a' <= ch1 && ch1 <= 'z') {
				alp[ch1-'a'] = true;
				gq.add(new Node(h,0));
			}else if('A' <= ch1 && ch1 <= 'Z'){
				if(alp[ch1-'A']) {
					gq.add(new Node(h,0));
				}else {
					aq.add(new Door(h,0,ch1));
				}
			}
			
			if(ch2=='.' || ch2=='$') {
				gq.add(new Node(h,W-1));
			}else if('a'<= ch2 && ch2 <= 'z') {
				alp[ch2-'a'] = true;
				gq.add(new Node(h,W-1));
			}else if( 'A' <= ch2 && ch2 <= 'Z'){
				if(alp[ch2 -'A']) {
					gq.add(new Node(h,W-1));
				}else {
					aq.add(new Door(h,W-1,ch2));
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
			char c = bd[cur.n][cur.m];
			if(bd[cur.n][cur.m]=='$') {
				ans++;
			}else if( 'a' <= c && c <= 'z') {
				if(!alp[c-'a']) {
					alp[c-'a']=true;
				}
				for(int i=0; i<aq.size();i++) {
					if(aq.get(i).alp-'A'== c-'a') {
						gq.add(new Node(aq.get(i).n, aq.get(i).m));
					}
				}
			}else if('A' <= c  && c <= 'Z') {
				if(!alp[c-'A']) {
					aq.add(new Door(cur.n,cur.m,c));					
				}
			}
			ck[cur.n][cur.m]= true;
			for(int k=0; k<4; k++) {
				int nn = cur.n+dc[k];
				int nm = cur.m+dr[k];
				if(inner(nn,nm)) {
					char cn = bd[nn][nm];
					if(cn=='.' || cn=='$') {
						gq.add(new Node(nn,nm));
						ck[nn][nm]=true;
					}
					else if('a'<=cn && cn <= 'z') {
						alp[cn-'a']=true;
						gq.add(new Node(nn,nm));
						ck[nn][nm]=true;
						for(int i=0; i<aq.size();i++) {
							if(aq.get(i).alp-'A'== cn-'a') {
								gq.add(new Node(aq.get(i).n, aq.get(i).m));
								ck[aq.get(i).n][aq.get(i).m]= true;
							}
						}
					}
					else {
						if(alp[cn-'A']) {
							gq.add(new Node(nn,nm));
							ck[nn][nm]=true;
						}else {
							aq.add(new Door(nn,nm,cn));
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