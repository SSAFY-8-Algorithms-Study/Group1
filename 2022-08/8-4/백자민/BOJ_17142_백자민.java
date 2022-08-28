package week8_4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_17142_백자민 {
	
	static int N, M, min, blank;
	static int[][] map;
	static ArrayList<Point> virus;
	static Point[] active; //조합 만들 배열 
	
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	
	static void bfs(int[][] m, int tcnt) {
		Queue<Point> q = new LinkedList<>();
		
		for(int i=0;i<M;i++) {
			q.offer(active[i]);
			m[active[i].i][active[i].j] = -1;
		}
		
		while(!q.isEmpty()) {
			Point temp = q.poll();
				
			for(int d=0;d<4;d++) {
				int ni = temp.i+di[d];
				int nj = temp.j+dj[d];
				
				if(ni<0 || ni>=N || nj<0 || nj>=N) continue;
				
				if(m[ni][nj]==1 || m[ni][nj]==-1) continue;
					
				if(m[ni][nj]==0) { //바이러스는 지나갈 수 있지만 카운팅은 하지 않음
					tcnt--;
				}

				if(tcnt==0) {
					min = Math.min(min, temp.time+1);
					return;
				}
				
				m[ni][nj] = -1;
				q.offer(new Point(ni, nj, temp.time+1));
			}
			
		}

	}
	
	static void comb(int cnt, int idx) {
		if(cnt==M) {
			bfs(deepcopy(map), blank); //시뮬레이션 돌리고 최솟값 갱신 
			return;
		}
		
		for(int i=idx, size=virus.size();i<size;i++) {
			active[cnt] = virus.get(i);
			comb(cnt+1, i+1);
		}
	}
	
	static int[][] deepcopy(int[][] target) {
		int[][] copy = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				copy[i][j] = target[i][j];
			}
		}
		return copy;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][N];
		virus = new ArrayList<>();
		active = new Point[M];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j]==2)
					virus.add(new Point(i,j,0));
				if(map[i][j]==0)
					blank++;
			}
		}
		
		if(blank==0) 
			System.out.println(blank);
		else {
			min = Integer.MAX_VALUE;
			comb(0,0);
			System.out.println(min==Integer.MAX_VALUE?-1:min);
		}
	}
	
	static class Point {
		int i, j, time;

		public Point(int i, int j, int time) {
			this.i = i;
			this.j = j;
			this.time = time;
		}
	}
}
