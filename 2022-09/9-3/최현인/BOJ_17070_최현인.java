// 17070
// 파이프를 밀어서 갈 수 있는 경로 인지 확인
// 대각선으로 돌릴 때는 우측 칸과 아래칸이 다 비어있는지 확인 해야함
// 위 조건을 유의하면서 목적지에 도달할 수 있는 모든 경우의 수를 bfs로 탐색함

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
	static class coord{
		int i, j, dir;
		//dir : ���� : 0, �밢�� : 1, ���� 2
		public coord(int i, int j, int dir) {
			super();
			this.i = i;
			this.j = j;
			this.dir = dir;
		}
	}
	static int N;
	static int count = 0;
	static int[][] d = {{0, 1}, {0,2}, {1,2}};
	static int[] di = {0, 1, 1};
	static int[] dj = {1, 1, 0};
	
	static int[][] map; 
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		String[] temp;
		for (int i = 0; i < N; i++) {
			temp = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(temp[j]);
			}
		}
		bfs();
		System.out.println(count);
	}
	public static void bfs() {
		ArrayDeque<coord> q = new ArrayDeque<>();
		q.add(new coord(0,1,0));
		
		while (!q.isEmpty()) {
			coord cur = q.poll();
			for (int k = d[cur.dir][0]; k <= d[cur.dir][1]; k++) {
				int ni = di[k]+cur.i;
				int nj = dj[k]+cur.j;
				if (ni < N && nj < N && map[ni][nj] != 1) {
					if (k == 1) {
						if (map[ni-1][nj] == 1 || map[ni][nj-1] == 1) {
							continue;
						}
					}
					if (ni == N-1 && nj == N-1) {
						count++;
					}
					if (map[ni][nj] == 0) {
						q.add(new coord(ni, nj, k));
					}
				}
			}			
		}
		
	}
}
