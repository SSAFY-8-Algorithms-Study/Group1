package bj2468;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[][] map;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		int answer = 1;
		for (int i = 1; i < 100; i++) {
			int temp = bfs(n, i);
			answer = Math.max(answer, temp);
		}
		System.out.println(answer);

	}

	public static int bfs(int n, int chk) {
		boolean[][] visit = new boolean[n][n];
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] <= chk || visit[i][j]) {
					continue;
				}
				Queue<Tuple> queue = new LinkedList<>();
				visit[i][j] = true;
				queue.add(new Tuple(i, j));
				while (!queue.isEmpty()) {
					Tuple tuple = queue.poll();
					for (int k = 0; k < 4; k++) {
						int nx = tuple.x + dx[k];
						int ny = tuple.y + dy[k];
						if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
							continue;
						}
						if (map[nx][ny] <= chk || visit[nx][ny]) {
							continue;
						}
						queue.add(new Tuple(nx, ny));
						visit[nx][ny] = true;
					}
				}
				cnt++;
			}
		}
		return cnt;
	}
}

class Tuple {
	int x, y;

	public Tuple(int x, int y) {
		this.x = x;
		this.y = y;
	}
}