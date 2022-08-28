package week8_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_16918_백자민 {
	
	static int R, C, N, bombtime;
	static char[][] map;
	static int[][] time;
	
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	
	static void bombman() { //폭탄심기 
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j]=='.') {
					map[i][j] = 'O';
					time[i][j] = bombtime+3; //터질 시간 갱신
				}
			}
		}
	}
	
	static void bomb() {
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j] == 'O' && time[i][j]==bombtime) { //터질 시간이 다 된 폭탄
					map[i][j] = '.'; //폭탄 터지고 
					
					for(int d=0;d<4;d++) {//근처 4방 모두 터짐
						int ni = i+di[d];
						int nj = j+dj[d];
						
						if(ni>=0 && ni<R && nj>=0 && nj<C && map[ni][nj]=='O' && time[ni][nj]!=bombtime) {
							map[ni][nj] = '.'; 
							time[ni][nj] = 0; //나중에 터지면 안되니까
						}
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		time = new int[R][C];
		
		for(int i=0;i<R;i++) {
			map[i] = br.readLine().toCharArray();
			for(int j=0;j<C;j++) {
				if(map[i][j]=='O')
					time[i][j] = 3;
			}
		}
		
		bombtime = 2;
		while(bombtime<=N) {
			if(bombtime%2==0)
				bombman();
			else
				bomb();
			bombtime++;
		}
		
		for(int i=0;i<R;i++) {
			System.out.println(map[i]);
		}
	}
}
