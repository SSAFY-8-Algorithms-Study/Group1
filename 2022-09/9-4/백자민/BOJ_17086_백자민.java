package week9_4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * map에 있는 상어의 위치부터 시작해서 안전거리를 구한다(bfs).
 * 입력받을 때, 상어의 좌표를 큐에 넣어둔다. 이후 bfs 탐색을 하면서 상어의 좌표를 기준으로 범위를 넓혀가며 안전거리를 계산한다. 
 * 탐색이 끝나면 안전거리가 저장된 배열 중 최댓값을 출력한다. 
 * */

public class BOJ_17086_백자민 {
	
	static int N, M, ans;
	
	static int[][] map, dist;
	static Queue<Point> queue;
	
	//위쪽부터 시계방향
	static int[] di = {-1,-1,0,1,1,1,0,-1};
	static int[] dj = {0,1,1,1,0,-1,-1,-1};
	
	static void bfs() {
		while(!queue.isEmpty()) {
			Point temp = queue.poll();
			
			for(int d=0;d<8;d++) {
				int ni = temp.i+di[d];
				int nj = temp.j+dj[d];
				
				if(ni<0 || nj<0 || ni>=N || nj>=M) //범위체크
					continue;
				if(dist[ni][nj]!=0 || map[ni][nj]==1) //이미 안전거리 계산 or 상어자리
					continue;
				dist[ni][nj] = dist[temp.i][temp.j]+1;
				
				if(dist[ni][nj]>ans)
					ans = dist[ni][nj];//안전거리 최댓값 갱신
				
				queue.add(new Point(ni,nj));
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N][M];
		dist = new int[N][M];
		queue = new LinkedList<>();
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j]==1) {
					queue.add(new Point(i,j)); //상어좌표 저장
				}
			}
		}
		ans = 0;
		bfs();
		System.out.println(ans);
	}
	
	static class Point {
		int i,j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
		
	}
}
