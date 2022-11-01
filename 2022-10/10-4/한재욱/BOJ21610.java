package study.oct5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

//마법사 상어와 비바라기


public class BOJ21610 {
	static int N, M;
	static int[] di = { 0, 0, -1, -1, -1, +1, +1, +1, +1 };
	static int[] dj = { 0, -1, -1, 0, +1, +1, +1, 0, -1 }; // 2 4 6 8
	static int[] order = { 2, 4, 6, 8 };
	static int[][] map;
	static boolean[][] v;
	static LinkedList<Point> clouds;

	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];
		clouds = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		clouds.add(new Point(N, 1));
		clouds.add(new Point(N, 2));
		clouds.add(new Point(N - 1, 1));
		clouds.add(new Point(N - 1, 2));
		for (int i = 0; i < M; i++) {
			v = new boolean[N + 1][N + 1];
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			move(d, s);
			waterCopy();
			createCloud();
		} // end
		print();
		waterSum();
	}

	private static void createCloud() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(map[i][j]>=2&& !v[i][j]) {
					clouds.add(new Point(i,j));
					map[i][j] -= 2;
				}
			}
		}
	}

	private static void waterCopy() {// 2 4 6 8
		for (int i = 0, size = clouds.size(); i < size; i++) {
			Point cur = clouds.poll();
			int cnt = 0;
			for (int d = 0; d < order.length; d++) {
				int ni = (cur.i + di[order[d]]);
				int nj = (cur.j + dj[order[d]]);
				if(1<=ni&&ni<=N&&1<=nj&&nj<=N) {
					if (map[ni][nj] != 0)
						cnt++;
				}
			}
			map[cur.i][cur.j] += cnt;
		}
	}

	private static void move(int d, int s) {
		for (int i = 0, size = clouds.size(); i < size; i++) {
			Point cur = clouds.poll();
			int ni = (cur.i + di[d] * s) % N;
			int nj = (cur.j + dj[d] * s) % N;
			ni = (ni < 1 ? ni + N : ni);
			nj = (nj < 1 ? nj + N : nj);
			map[ni][nj]++;
			v[ni][nj] = true;
			clouds.add(new Point(ni, nj));
		}
	}

	private static void waterSum() {
		int sum = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				sum += map[i][j];
			}
		}
		System.out.println(sum);
	}
	static class Point {
		int i, j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	static void print() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}