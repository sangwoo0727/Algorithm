import java.util.*;

public class Kakao_2018BlindRecruitment_4_셔틀버스 {
	public String solution(int n, int t, int m, String[] timetable) {
		String answer = "";		
		for(int i=0; i<timetable.length; i++) {
			timetable[i] = timetable[i].substring(0, 2)+timetable[i].substring(3, 5);
		}
		Arrays.sort(timetable);
		int hh = 9, mm = 0;
		int idx = 0;
		for(int i=0; i<n; i++) {
			if(i==n-1) {
				if(idx==timetable.length) {
					answer = makeans(hh,mm);
				}else if(idx<timetable.length) {
					int cnt = 0;
					for(;;) {
						if(idx>=timetable.length || cnt>=m) break;
						String hhh = timetable[idx].substring(0, 2);
						String mmm = timetable[idx].substring(2, 4);
						if(Integer.parseInt(hhh) > hh) break;
						else if(Integer.parseInt(hhh) == hh && Integer.parseInt(mmm)>mm) break;
						idx++; cnt++;
					}
					if(cnt==m) {
						idx--;
						String hhh = timetable[idx].substring(0, 2);
						String mmm = timetable[idx].substring(2, 4);
						if(Integer.parseInt(mmm)==0) {
							hhh = Integer.toString(Integer.parseInt(hhh)-1);
							mmm = Integer.toString(59);
						}else {
							mmm = Integer.toString(Integer.parseInt(mmm)-1);
						}
						answer = makeans(Integer.parseInt(hhh),Integer.parseInt(mmm));
					}else {
						answer = makeans(hh,mm);
					}
				}
			}else {
				int cnt = 0;
				for(;;) {
					if(idx>=timetable.length || cnt>=m) break;
					String hhh = timetable[idx].substring(0, 2);
					String mmm = timetable[idx].substring(2, 4);
					if(Integer.parseInt(hhh) > hh) break;
					else if(Integer.parseInt(hhh) == hh && mm< Integer.parseInt(mmm)) break;
					idx++; cnt++;
				}
			}
			mm+=t;
			if(mm>=60) {
				mm-=60;
				hh+=1;
			}
		}
		return answer;
	}
	static String makeans(int h,int m) {
		String ans="";
		if(h/10==0) ans+="0";
		ans+=h+":";
		if(m/10==0) ans+="0";
		ans+=m;
		return ans;
	}
}
