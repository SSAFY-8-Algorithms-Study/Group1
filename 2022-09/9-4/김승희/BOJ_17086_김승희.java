package boj17086;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

/*
 * BFS를 이용하여 해결
 * 처음에 들어오는 아기 상어의 위치를 큐에 넣어준다.
 * 큐의 크기만큼 for문을 돌려서 -> 아기 상어들과 특정 거리만큼 떨어진 공간을 볼 수 있다.
 * 큐에 들어있는 위치들에서 다음에 갈 수 있는 공간을 찾아 큐에 넣는다.
 * 입력으로 들어오는 map을 유지할 필요가 없기 때문에 방문한 공간을 1로 만들어 방문 체크를 한다.
 * */

public class Main {
	static class Tuple {
		int i, j;

		public Tuple(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inArr = br.readLine().split(" ");

		int n = Integer.parseInt(inArr[0]);
		int m = Integer.parseInt(inArr[1]);
		Queue<Tuple> queue = new ArrayDeque<>();
		int[][] map = new int[n][m];
		for (int i = 0; i < n; i++) {
			inArr = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(inArr[j]);
				if (map[i][j] == 1) {
					queue.add(new Tuple(i, j));
				}
			}
		}

		int maxDist = -1;
		int[] di = { -1, 1, 0, 0, -1, -1, 1, 1 };
		int[] dj = { 0, 0, -1, 1, -1, 1, -1, 1 };
		while (!queue.isEmpty()) {
			int size = queue.size();
			maxDist++;
			for (int i = 0; i < size; i++) {
				Tuple tp = queue.poll();
				for (int k = 0; k < 8; k++) {
					int ni = tp.i + di[k];
					int nj = tp.j + dj[k];
					if (ni < 0 || nj < 0 || ni >= n || nj >= m) {
						continue;
					}
					if (map[ni][nj] == 1) {
						continue;
					}

					map[ni][nj] = 1;
					queue.add(new Tuple(ni, nj));
				}
			}

		}
		System.out.println(maxDist);
	}

}
