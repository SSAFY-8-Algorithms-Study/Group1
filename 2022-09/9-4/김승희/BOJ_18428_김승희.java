package boj18428;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * 장애물의 위치 3개를 조합으로 구한다.
 * 입력으로 들어온 origin을 복사한 후 해당 위치에 대해 장애물을 설치한다.
 * 델타 탐색을 응용하여 선생님이 감시를 시작한다.
 * 이때 while문을 도는데 범위를 벗어나거나 장애물을 만나면 while문을 빠져나온다.
 * 만약 학생을 만난다면, 선생님의 감시에 걸린 것이기 때문에 더 이상 함수를 진행할 필요가 없다.
 * 선생님의 감시를 모두 피했다면 answer를 true로 만들어서 다음 프로세스를 더 이상 진행하지 않도록 처리한다. 
 * */

public class Main {
	static boolean answer;
	static int N;
	static String[][] origin;
	static ArrayList<Tuple> teachers;
	static int[] number;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

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

		N = Integer.parseInt(br.readLine());
		origin = new String[N][N];
		teachers = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			String[] inArr = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				origin[i][j] = inArr[j];
				if (origin[i][j].equals("T")) {
					teachers.add(new Tuple(i, j));
				}
			}
		}
		answer = false;
		number = new int[3];
		combi(0, 0);
		if (answer) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

	public static void combi(int cnt, int idx) {
		if (answer) {
			return;
		}
		if (cnt == 3) {
			obstacle();
			return;
		}
		for (int i = idx; i < N * N; i++) {
			number[cnt] = i;
			combi(cnt + 1, idx + 1);
		}
	}

	public static void obstacle() {
		String[][] map = copy(origin);

		for (int i = 0; i < 3; i++) {
			int q = number[i] / N;
			int r = number[i] % N;
			if (map[q][r].equals("X")) {
				map[q][r] = "O";
			} else {
				return;
			}
		} // 장애물 설치

		for (int i = 0; i < teachers.size(); i++) {
			Tuple tp = teachers.get(i);
			for (int k = 0; k < 4; k++) {
				int ni = tp.i + di[k];
				int nj = tp.j + dj[k];
				while (true) {
					if (ni < 0 || nj < 0 || ni >= N || nj >= N || map[ni][nj].equals("O")) {
						break;
					}
					if (map[ni][nj].equals("S")) {
						return;
					}
					ni += di[k];
					nj += dj[k];
				}
			}
		}
		answer = true;
	}

	public static void print(String[][] arr) {
		System.out.println("---------------------");
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println("---------------------");

	}

	public static String[][] copy(String[][] origin) {
		String[][] copy = new String[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				copy[i][j] = origin[i][j];
			}
		}
		return copy;
	}
}
