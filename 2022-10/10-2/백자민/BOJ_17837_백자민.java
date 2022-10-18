package week10_2;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_17837_백자민 {
	
	static int N,K,time;
	static boolean flag;
	
	static Point[] horse;
	
	static int[] di = {-1,1,0,0}; //하,상,좌,우
	static int[] dj = {0,0,-1,1};
	
	static int[][] map;
	static ArrayList<Integer>[][] state;
	
	static void game() {
		for(int k=0;k<K;k++) {
			Point temp = horse[k];
			
			int ni = temp.i+di[temp.dir];
			int nj = temp.j+dj[temp.dir];
			
			if(ni<0 || ni>=N || nj<0 || nj>=N || map[ni][nj]==2) { //다음 이동위치가 벽or파란색
				//방향 바꾸기 
				if(temp.dir==0 || temp.dir==2) 
					horse[k].dir = temp.dir+1; //0->1 2->3
				else
					horse[k].dir = temp.dir+1; //1->0 3->2
				
				//바꾸고 이동가능하면 이동
				ni = temp.i+di[horse[k].dir];
				nj = temp.j+dj[horse[k].dir];
				
				if(ni<0 || ni>=N || nj<0 || nj>=N || map[ni][nj]==2) continue;
				
				k--;//방금 말 다시 움직이기
				continue;
			} 
			else if(map[ni][nj]<2) {
				boolean more = false;
				ArrayList<Integer> moveList = new ArrayList<>();
				for(int i=0,size=state[temp.i][temp.j].size();i<size;i++) {
					int num = state[temp.i][temp.j].get(k);
					if(num==k) { //지금 말 지도에서 빼기
						more = true;
						moveList.add(k);
						state[temp.i][temp.j].remove(i);
						i--;
						continue;
					}
					if(more) { //지금 말 위의 말도 다 좌표 갱신
						horse[num].i = ni;
						horse[num].j = nj;
						moveList.add(num);
						state[temp.i][temp.j].remove(i);
						i--;
					}
				}
				//다같이 이동
				horse[k].i = ni;
				horse[k].j = nj;
				
				if(map[ni][nj]==0) {
					for(int i=0,size=moveList.size();i<size;i++) {
						state[ni][nj].add(moveList.get(i));
					}
				}
				else if(map[ni][nj]==1) {
					for(int size=moveList.size(),i=size-1;i>=0;i--) {
						state[ni][nj].add(moveList.get(i));
					}
				}
				
				if(state[ni][nj].size()>=4) {
					flag = true;
					return;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		
		map = new int[N][N];
		horse = new Point[K];
		state = new ArrayList[N][N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j] = sc.nextInt();
				state[i][j] = new ArrayList<>();
			}
		}
		
		for(int k=0;k<K;k++) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			int dir = sc.nextInt();
			horse[k] = new Point(i-1,j-1,4-dir);
			state[i-1][j-1].add(k);
		}
		time=0;
		while(time<=1000 && !flag) {
			time++;
			game();
		}
		System.out.println(flag?time:-1);
		
	}
	
	static class Point {
		int i,j,dir;

		public Point(int i, int j, int dir) {
			this.i = i;
			this.j = j;
			this.dir = dir;
		}
		
	}
}
