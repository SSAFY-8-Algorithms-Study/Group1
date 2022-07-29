package bj2573;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[][] map;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int time = 0;
		while (true) {
			time++;
			melt(n, m);
			int cnt = bfs(n, m);
			if (cnt > 1) {
				break;
			}
			if (cnt == 0) {
				time = 0;
				break;
			}
		}
		System.out.println(time);

	}

	public static ArrayList<Tuple> glacier(int n, int m) {
		ArrayList<Tuple> arr = new ArrayList<Tuple>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0) {
					continue;
				}
				int zero_cnt = 0;
				for (int k = 0; k < 4; k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];
					if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
						continue;
					}
					if (map[nx][ny] == 0) {
						zero_cnt++;
					}
				}
				if (zero_cnt > 0) {
					arr.add(new Tuple(i, j, zero_cnt));
				}
			}
		}
		return arr;
	}

	public static void melt(int n, int m) {
		ArrayList<Tuple> arr = glacier(n, m);
		for (int i = 0; i < arr.size(); i++) {
			Tuple tuple = arr.get(i);
			map[tuple.x][tuple.y] = Math.max(0, map[tuple.x][tuple.y] - tuple.value);
		}
	}

	public static int bfs(int n, int m) {
		boolean[][] visit = new boolean[n][m];
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0 || visit[i][j]) {
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
						if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
							continue;
						}
						if (map[nx][ny] == 0 || visit[nx][ny]) {
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
	int x, y, value;

	public Tuple(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Tuple(int x, int y, int v) {
		this.x = x;
		this.y = y;
		value = v;
	}
}