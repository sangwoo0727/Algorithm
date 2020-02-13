import java.io.*;
import java.util.*;

public class SWEA1873_상호의배틀필드 {
	static char[][] bd;
	static int H,W,N;
	static int[][] d = {{-1,1,0,0},{0,0,-1,1}};
	static int nnow,mnow;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			bd = new char[H+1][W+1];
			for(int h=0; h<H; h++) {
				String s = br.readLine();
				bd[h] = s.toCharArray();
				for(int w=0; w<W; w++) {
					if(bd[h][w]=='<' || bd[h][w]=='>' || bd[h][w]=='^' || bd[h][w]=='v') {
						nnow = h; mnow=w;
					}
				}
			}
			N = Integer.parseInt(br.readLine());
			String s = br.readLine();
			simu(s);
			for(int h=0; h<H; h++) {
				for(int w=0; w<W; w++) {
					sb.append(bd[h][w]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
	static void simu(String s) {
		for(int n=0; n<s.length(); n++) {
			char c = s.charAt(n);
			int nn=0, nm=0;
			if(c=='U') {
				nn = nnow + d[0][0];
				nm = mnow + d[1][0];
				bd[nnow][mnow]='^';
				if(inner(nn,nm)) {
					if(bd[nn][nm]=='.') {
						bd[nnow][mnow]='.';
						bd[nn][nm]='^';
						nnow = nn;
						mnow = nm;
					}
				}
				
			}else if(c=='D') {
				nn = nnow + d[0][1];
				nm = mnow + d[1][1];
				bd[nnow][mnow]='v';
				if(inner(nn,nm)) {
					if(bd[nn][nm]=='.') {
						bd[nnow][mnow]='.';
						bd[nn][nm]='v';
						nnow = nn;
						mnow = nm;
					}
				}
			}else if(c=='L') {
				nn = nnow + d[0][2];
				nm = mnow + d[1][2];
				bd[nnow][mnow]='<';
				if(inner(nn,nm)) {
					if(bd[nn][nm]=='.') {
						bd[nnow][mnow]='.';
						bd[nn][nm]='<';
						nnow = nn;
						mnow = nm;
					}
				}
			}else if(c=='R') {
				nn = nnow + d[0][3];
				nm = mnow + d[1][3];
				bd[nnow][mnow]='>';
				if(inner(nn,nm)) {
					if(bd[nn][nm]=='.') {
						bd[nnow][mnow]='.';
						bd[nn][nm]='>';
						nnow = nn;
						mnow = nm;
					}
				}
			}else { //S
				int tn=nnow, tm = mnow;
				int dx=0, dy=0;
				if(bd[tn][tm]=='^') {
					dx = d[0][0]; dy = d[1][0];
				}else if(bd[tn][tm]=='v') {
					dx = d[0][1]; dy = d[1][1];
				}else if(bd[tn][tm]=='<') {
					dx = d[0][2]; dy = d[1][2];
				}else if(bd[tn][tm]=='>') {
					dx = d[0][3]; dy= d[1][3];
				}
				while(inner(tn+dx,tm+dy)) {
					tn += dx; tm += dy;
					if(bd[tn][tm]=='*') {
						bd[tn][tm]='.';
						break;
					}else if(bd[tn][tm]=='#'){
						break;
					}else {
						continue;
					}
				}
			}
		}
	}
	static boolean inner(int n, int m) {
		return n>=0 && n<H && m>=0 && m<W;
	}
}
