package Sep4;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class boj17086 {
	//아기 상어2.
	/*
	 * 상어의 이동은 8방향. 1이 아기상어 0이 빈칸
	 * 빈칸 위치에서 bfs탐색하여. 깊이를 구했음.
	 * 그 깊이의 최대값 출력
	 */
	static int n, m, max;
	static int[][] map;
	static boolean[][] visited;
	static int[] di = {-1,1,0,0,1,1,-1,-1};
	static int[] dj = {0,0,-1,1,1,-1,-1,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		max = 1;
		map = new int[n][m];
		for(int i=0;i<n;i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}//input end
		
		for(int i=0;i<n;i++) {
			for (int j = 0; j < m; j++) {
				if(map[i][j]==0) {
					bfs(new Point(i,j));					
				}
			}
		}
		System.out.println(max);
	}
	private static void bfs(Point point) {
		visited = new boolean[n][m];
		Queue<Point> que = new ArrayDeque<>();
		visited[point.i][point.j] = true;
		que.add(point);
		int depth = 0;
		while(!que.isEmpty()) {
			int size = que.size();
			while(--size>=0) {
				Point cur = que.poll();
				for(int d=0;d<8;d++) {
					int ni = cur.i+di[d];
					int nj = cur.j+dj[d];
					if(0<=ni&&ni<n&&0<=nj&&nj<m&&!visited[ni][nj]) {
						visited[ni][nj] = true;
						if(map[ni][nj]==1) {
							max = Math.max(max, depth+1);
							return;
						}
						que.add(new Point(ni, nj));
					}
				}
			}
			depth++;
		}
	}
	static class Point{
		int i, j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}
