package boj17837;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	static int N, K;
	static int[][] WRB;
	static Horse[] horse;
	static ArrayList<Integer>[][] Map;
	static int[] di = { 0, 0, 0, -1, 1 };
	static int[] dj = { 0, 1, -1, 0, 0 };
	static int[] reverse = { 0, 2, 1, 4, 3 };

	static class Horse {
		int i, j, d;

		public Horse(int i, int j, int d) {
			super();
			this.i = i;
			this.j = j;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Horse [i=" + i + ", j=" + j + ", d=" + d + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inArr = br.readLine().split(" ");
		N = Integer.parseInt(inArr[0]);
		K = Integer.parseInt(inArr[1]);
		WRB = new int[N + 1][N + 1];
		Map = new ArrayList[N + 1][N + 1];
		for (int i = 1; i < N + 1; i++) {
			inArr = br.readLine().split(" ");
			for (int j = 1; j < N + 1; j++) {
				WRB[i][j] = Integer.parseInt(inArr[j - 1]);
				Map[i][j] = new ArrayList<Integer>();
			}
		}

		horse = new Horse[K];
		for (int p = 0; p < K; p++) {
			inArr = br.readLine().split(" ");
			int i = Integer.parseInt(inArr[0]);
			int j = Integer.parseInt(inArr[1]);
			int d = Integer.parseInt(inArr[2]);
			horse[p] = new Horse(i, j, d);
			Map[i][j].add(p);
		}

		int cnt = 0;
		while (cnt < 1001) {
			cnt++;
			if (move()) {
//				System.out.println(Arrays.toString(horse));
				break;
			}
//			print(cnt);
		}
//		print(cnt);
		System.out.println(cnt < 1001 ? cnt : -1);
	}

	static void print(int cnt) {
		System.out.println("-----------" + cnt + "-----------");
		for (int i = 1; i < N + 1; i++) {
			System.out.println(Arrays.toString(Map[i]));
		}
	}

	static boolean move() {
		for (int p = 0; p < K; p++) {
			int i = horse[p].i;
			int j = horse[p].j;
			int ni = i + di[horse[p].d];
			int nj = j + dj[horse[p].d];

			// 범위를 넘어가거나 가려는 칸이 파랑
			if (ni <= 0 || nj <= 0 || ni > N || nj > N || WRB[ni][nj] == 2) {
				horse[p].d = reverse[horse[p].d];
				ni = i + di[horse[p].d];
				nj = j + dj[horse[p].d];
				if (!(ni <= 0 || nj <= 0 || ni > N || nj > N || WRB[ni][nj] == 2)) {
					Blue(i, j, ni, nj, p);
					if (Map[ni][nj].size() > 3) {
						return true;
					}
				}
				continue;
			}

			if (WRB[ni][nj] == 0) { // 가려는 칸이 하양
				White(i, j, ni, nj, p);
			} else if (WRB[ni][nj] == 1) { // 가려는 칸이 빨강
				Red(i, j, ni, nj, p);
			}
			if (Map[ni][nj].size() > 3) {
				return true;
			}
		}
		return false;
	}

	static void White(int i, int j, int ni, int nj, int p) {
		boolean chk = false;
		ArrayList<Integer> temp = new ArrayList<>();
		for (int q = 0; q < Map[i][j].size(); q++) {
			int h = Map[i][j].get(q);
			if (h == p) {
				chk = true;
			}
			if (chk) {
				Map[ni][nj].add(h);
				horse[h].i = ni;
				horse[h].j = nj;
			} else {
				temp.add(h);
			}
		}
		Map[i][j] = temp;
	}

	static void Red(int i, int j, int ni, int nj, int p) {
		// p번 말 위에 있는 거 모두 ni, nj로 옮기는데 순서는 반대로
		int size = Map[i][j].size();
		boolean chk = false;
		ArrayList<Integer> temp = new ArrayList<>();
		for (int q = size - 1; q >= 0; q--) {
			int h = Map[i][j].get(q);

			if (chk) {
				temp.add(h);
			} else {
				Map[ni][nj].add(h);
				horse[h].i = ni;
				horse[h].j = nj;
			}
			if (h == p) {
				chk = true;
			}
		}
		Map[i][j] = temp;
	}

	static void Blue(int i, int j, int ni, int nj, int p) {
		if (WRB[ni][nj] == 0) {
			White(i, j, ni, nj, p);
		} else if (WRB[ni][nj] == 1) {
			Red(i, j, ni, nj, p);
		}
	}

}
