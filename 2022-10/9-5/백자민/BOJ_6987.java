package week9_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 경기를 하는 팀의 조합마다 각 팀이 우승할 경우/비길 경우/질 경우를 모두 카운트해보며 주어진 점수가 유효한 점수인지 검사한다. 
 * */

public class BOJ_6987 {
	
	static boolean flag;
	
	static int[] win, draw, lose;
	static boolean[] select;
	
	static int[] game1 = {0,0,0,0,0,1,1,1,1,2,2,2,3,3,4};
    static int[] game2 = {1,2,3,4,5,2,3,4,5,3,4,5,4,5,5};
	
	static void check(int temp) {
		if(flag)
			return;
		
		if(temp==15) {
			flag = true;
			return;
		}
		
		int team1 = game1[temp];
		int team2 = game2[temp];
		
		if(win[team1]>0 && lose[team2]>0) {
            win[team1]--;
            lose[team2]--;
            check(temp+1);
            win[team1]++;
            lose[team2]++;
        }
        
        if(lose[team1]>0 && win[team2]>0) {
            lose[team1]--;
            win[team2]--;
            check(temp+1);
            lose[team1]++;
            win[team2]++;
        }
        
        if(draw[team1]>0 && draw[team2]>0) {
            draw[team1]--;
            draw[team2]--;
            check(temp+1);
            draw[team1]++;
            draw[team2]++;
        }   
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int t=0;t<4;t++) {
			st = new StringTokenizer(br.readLine());
			
			int total=0;
			
			win = new int[6];
			draw = new int[6];
			lose = new int[6];
			
			select = new boolean[6];
			flag = false;
			
			for(int i=0;i<6;i++) {
				win[i] = Integer.parseInt(st.nextToken());
				draw[i] = Integer.parseInt(st.nextToken());
				lose[i] = Integer.parseInt(st.nextToken());
				
				total += win[i]+draw[i]+lose[i];
			}
			
			if(total!=30) //30아니면 검사할 필요X
				flag = false;
			else
				check(0);
			
			System.out.print(flag?1+" ":0+" ");
		}
	}
}
