package boj3187;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

/*
 * 울타리가 아니면 해당 좌표를 기준으로 BFS를 돌면서 만나는 늑대와 양의 수를 count
 * BFS가 끝나고 난뒤에 
 * 양 > 늑대 -> 늑대가 잡아먹힘
 * 양 <= 늑대 -> 양이 잡아먹힘
 * 살아남은 늑대 or 양을 V or K에 누적
 * */

public class Main {
	static class Point{
		int i, j;

		public Point(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
		
	}
	
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inArr = br.readLine().split(" ");
		int R = Integer.parseInt(inArr[0]);
		int C = Integer.parseInt(inArr[1]);
		
		char[][] map = new char[R][];
		for(int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		int V = 0;
		int K = 0;
		
		boolean[][] visit = new boolean[R][C];
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(visit[i][j] || map[i][j] == '#') continue;
				Queue<Point> queue = new ArrayDeque<>();
				int vCnt = 0;
				int kCnt = 0;
				
				queue.add(new Point(i, j));
				visit[i][j] = true;
				while(!queue.isEmpty()) {
					Point pnt = queue.poll();
					if(map[pnt.i][pnt.j] == 'v') {
						vCnt++;
					}
					if(map[pnt.i][pnt.j] == 'k') {
						kCnt++;
					}
					for(int k = 0; k < 4; k++) {
						int ni = pnt.i + di[k];
						int nj = pnt.j + dj[k];
						if(ni < 0 || nj < 0 || ni>= R || nj >= C || visit[ni][nj] || map[ni][nj] == '#') continue;
						
						visit[ni][nj] = true;
						queue.add(new Point(ni, nj));
					}
				}
				
				if(kCnt > vCnt) {
					K += kCnt;
				}else {
					V += vCnt;
				}
			}
		}
		System.out.println(K + " " + V);
	}

}
