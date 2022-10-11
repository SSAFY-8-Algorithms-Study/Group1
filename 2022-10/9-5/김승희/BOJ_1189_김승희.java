package boj1189;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	static int R, C, K, ans;
	static char[][] map;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inArr = br.readLine().split(" ");
		R = Integer.parseInt(inArr[0]);
		C = Integer.parseInt(inArr[1]);
		K = Integer.parseInt(inArr[2]);
		map = new char[R][];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		} // end input
		ans = 0;
		DFS(R - 1, 0, 1, new boolean[R][C]);
		System.out.println(ans);
	}

	public static void DFS(int i, int j, int dist, boolean[][] visit) {
		if (dist > K) {
			return;
		}
		visit[i][j] = true;

		for (int k = 0; k < 4; k++) {
			int ni = i + di[k];
			int nj = j + dj[k];

			if (ni < 0 || nj < 0 || ni >= R || nj >= C || visit[ni][nj]) {
				continue;
			}
			if (map[ni][nj] == 'T') {
				continue;
			}
			if (ni == 0 && nj == C - 1) {
				if (dist + 1 == K) {
					ans++;
				}
//				System.out.println((dist+1) + " ");
//				print(visit);
				continue;
			}
			DFS(ni, nj, dist + 1, copy(visit));
		}
//		System.out.println(i + " " + j + " " + dist + " ");
//		print(visit);
	}

	public static void print(boolean[][] visit) {
		System.out.println("---------------------------------");
		for (int i = 0; i < R; i++) {
			System.out.println(Arrays.toString(visit[i]));
		}
		System.out.println("---------------------------------");

	}

	public static boolean[][] copy(boolean[][] visit) {
		boolean[][] arr = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				arr[i][j] = visit[i][j];
			}
		}
		return arr;
	}

}
