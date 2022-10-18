package boj5427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

/*
 * 불은 동서남북으로 이동, 벽에는 안붙음
 * 상근이도 동서남북으로 이동, 불이 옮겨진 곳이나 옮겨질 곳에는 못감
 * -> 상근이보다 불을 먼저 하자
 * 상근이의 위치를 SG 큐에, 불의 위치를 fire 큐에 넣는다.
 * BFS를 돌린다.
 * fire의 size만큼 불을 꺼내서 이동시킨다.
 * 불은 빈 곳(.)이나 상근이가 있었던 위치(@)로 옮겨갈 수 있다.
 * SG의 size 만큼 상근이의 위치를 꺼내서 이동시킨다.
 * 상근이는 빈 곳(.)으로만 갈 수 있다.
 * Map의 원본을 유지할 필요가 없기 때문에 Map을 변형시키면서 visit 체크를 해준 것과 같다.
 * 불이 옮겨지면 해당 위치의 Map 값을 *로 바꿔주고, 상근이가 움직이면 해당 위치의 Map 값을 @로 바꾸었다.
 * */

public class Main {
	static int N, M;
	static Queue<Point> fire, SG;
	static char[][] Map;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	static class Point {
		int i, j;

		public Point(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < TC; t++) {
			String[] inArr = br.readLine().split(" ");
			N = Integer.parseInt(inArr[1]);
			M = Integer.parseInt(inArr[0]);

			Map = new char[N][];
			fire = new ArrayDeque<>();
			SG = new ArrayDeque<>();
			for (int p = 0; p < N; p++) {
				Map[p] = br.readLine().toCharArray();
				for (int q = 0; q < M; q++) {
					if (Map[p][q] == '*') {
						fire.add(new Point(p, q));
					} else if (Map[p][q] == '@') {
						SG.add(new Point(p, q));
					}
				}
			} // end input
			int i = SG.peek().i;
			int j = SG.peek().j;
			if (i == 0 || j == 0 || i == N - 1 || j == M - 1) {
				sb.append(1 + "\n");
			} else {
				sb.append(Escape() + "\n");
			}
		}
		System.out.println(sb.toString());
	}

	static String Escape() {
		int time = 0;
		while (!SG.isEmpty()) {
			int fsize = fire.size();
			for (int p = 0; p < fsize; p++) {
				Point pnt = fire.poll();
				for (int k = 0; k < 4; k++) {
					int ni = pnt.i + di[k];
					int nj = pnt.j + dj[k];
					if (ni < 0 || nj < 0 || ni >= N || nj >= M) {
						continue;
					}
					if (Map[ni][nj] == '.' || Map[ni][nj] == '@') {
						Map[ni][nj] = '*';
						fire.add(new Point(ni, nj));
					}
				}
			}
			int size = SG.size();
			for (int p = 0; p < size; p++) {
				Point pnt = SG.poll();
				for (int k = 0; k < 4; k++) {
					int ni = pnt.i + di[k];
					int nj = pnt.j + dj[k];
					if (ni < 0 || nj < 0 || ni >= N || nj >= M) {
						continue;
					}
					if (Map[ni][nj] == '.') {
						if (ni == 0 || nj == 0 || ni == N - 1 || nj == M - 1) {
							time += 2;
							return time + "";
						}
						Map[ni][nj] = '@';
						SG.add(new Point(ni, nj));
					}
				}
			}
			time++;
		}

		return "IMPOSSIBLE";
	}

}
