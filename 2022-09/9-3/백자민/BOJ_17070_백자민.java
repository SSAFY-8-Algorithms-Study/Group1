package week9_3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_17070_백자민 {
	
	static int N;
	static int[][] map;
//	static int[] di = {0,1,1}; 
//	static int[] dj = {1,0,1};
	
	static boolean isValid(Pipe p, int dir) { //다음 진행방향으로 갈 수 있는지?
		if(dir==0)  //오른쪽으로 한 칸
			return p.j+1<N && map[p.i][p.j+1]!=1;
		else if(dir==1) //아래로 한 칸
			return p.i+1<N && map[p.i+1][p.j]!=1;
		
		//대각선 한 칸
		return p.i+1<N && p.j+1<N && map[p.i+1][p.j+1]!=1 && map[p.i+1][p.j]!=1 && map[p.i][p.j+1]!=1;
	}
	
	static int bfs() {
		Queue<Pipe> q = new LinkedList<>();
		q.offer(new Pipe(0,1,0));
		
		int cnt = 0;
		
		while(!q.isEmpty()) {
			Pipe temp = q.poll();
			
			if(temp.i==N-1 && temp.j==N-1) {
				cnt++;
				continue;
			}
			
			if(temp.dir==0) { //지금 가로상태 - 오른쪽 or 대각선
				if(isValid(temp,0))
					q.offer(new Pipe(temp.i,temp.j+1, 0));
				if(isValid(temp,2))
					q.offer(new Pipe(temp.i+1,temp.j+1, 2));
			}
			else if(temp.dir==1) { //지금 세로상태 - 아래 or 대각선
				if(isValid(temp, 1))
					q.offer(new Pipe(temp.i+1,temp.j, 1));
				if(isValid(temp,2))
					q.offer(new Pipe(temp.i+1,temp.j+1, 2));
			}
			else {
				if(isValid(temp, 0))
					q.offer(new Pipe(temp.i,temp.j+1, 0));
				if(isValid(temp, 1))
					q.offer(new Pipe(temp.i+1,temp.j, 1));
				if(isValid(temp,2))
					q.offer(new Pipe(temp.i+1,temp.j+1, 2));
			}
		}
		
		return cnt;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new int[N][N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j] = sc.nextInt(); 
			}
		}
		
		if(map[N-1][N-1]==1)
			System.out.println(0);
		else
			System.out.println(bfs());
		
	}
	
	static class Pipe {
		int i,j,dir; //0:가로, 1:세로, 2:대각선

		public Pipe(int i, int j, int dir) {
			this.i = i;
			this.j = j;
			this.dir = dir;
		}
	}
}
