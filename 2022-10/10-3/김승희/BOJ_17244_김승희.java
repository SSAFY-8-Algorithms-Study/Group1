package boj17244;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
/*
 * X의 위치를 모두 저장해둔 후, 순열을 구해서 그 순서로 가는 시간을 구했다.
 * 이때, 현재 저장되어 있는 Time보다 커지면 더이상 진행하지 않고 넘어갔다. -> 최소 시간을 구하는 것이기 때문에
 * */
public class Main {

	static class Point {
		int i, j;

		public Point(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}

	}

	static int N, M, Time, TotalX;
	static ArrayList<Point> X;
	static Point Start, End;
	static char[][] Map;
	static int[] order;
	static boolean[] select;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inArr = br.readLine().split(" ");
		M = Integer.parseInt(inArr[0]);
		N = Integer.parseInt(inArr[1]);
		Map = new char[N][];
		TotalX = 0;
		X = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			Map[i] = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if (Map[i][j] == 'S') {
					Start = new Point(i, j);
				} else if (Map[i][j] == 'E') {
					End = new Point(i, j);
				} else if (Map[i][j] == 'X') {
					Map[i][j] = (char) (TotalX + '0');
					TotalX++;
					X.add(new Point(i, j));
				}
			}
		} // end input
		order = new int[TotalX];
		select = new boolean[TotalX];
		Time = Integer.MAX_VALUE;
		permutation(0);
		System.out.println(Time);
	}

	static void permutation(int cnt) {
		if (cnt == TotalX) {
			Point s = Start;
			int temp = 0;
			for (int i = 0; i < TotalX; i++) {
				Point p = X.get(order[i]);
				temp += BFS(s, p);
				if (temp > Time) {
					return;
				}
				s = p;
			}

			temp += BFS(s, End);
			if (temp >= Time) {
				return;
			}
			Time = temp;
			return;
		}
		for (int i = 0; i < TotalX; i++) {
			if (select[i])
				continue;
			select[i] = true;
			order[cnt] = i;
			permutation(cnt + 1);
			select[i] = false;
		}
	}

	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	static int BFS(Point st, Point end) {
		Queue<Point> Q = new ArrayDeque<Point>();
		Q.add(st);
		boolean[][] visit = new boolean[N][M];
		visit[st.i][st.j] = true;

		int time = 0;
		while (!Q.isEmpty()) {
			int size = Q.size();
			for (int p = 0; p < size; p++) {
				Point pnt = Q.poll();
				for (int k = 0; k < 4; k++) {
					int ni = pnt.i + di[k];
					int nj = pnt.j + dj[k];
					if (ni < 0 || nj < 0 || ni >= N || nj >= M || visit[ni][nj] || Map[ni][nj] == '#') {
						continue;
					}
					if (end.i == ni && end.j == nj)
						return time + 1;
					Q.add(new Point(ni, nj));
					visit[ni][nj] = true;
				}
			}
			time++;
		}
		return time;
	}
}
