import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static int R, C, N;
	static boolean[][] Map;
	static int[] di = { 1, -1, 0, 0 };
	static int[] dj = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] inArr = br.readLine().split(" ");
		R = Integer.parseInt(inArr[0]);
		C = Integer.parseInt(inArr[1]);
		N = Integer.parseInt(inArr[2]);

		Map = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			char[] ch = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if (ch[j] == 'O') {
					Map[i][j] = true;
				}
			}
		} // end input
		int time = 1;
		while (true) {
			if (time == N) {
				print(false);
				break;
			}
			// 시간 update
			time++;
			// 빈 곳에 폭탄 설치 -> map 전체가 모두 폭탄
			if (time == N) {
				print(true);
				break;
			}
			// 시간 update
			time++;
			// 폭탄 폭발
			bomb();
		}

	}

	static class Tuple {
		int i, j;

		public Tuple(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}

	}

	static void print(boolean chk) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (chk) {
					sb.append("O");
				} else {
					if (Map[i][j]) {
						sb.append("O");
					} else {
						sb.append(".");
					}
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	static void bomb_install() {

	}

	static void bomb() {
		// 이전에 설치된 폭탄 list
		ArrayList<Tuple> list = new ArrayList<>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (Map[i][j]) {
					list.add(new Tuple(i, j));
				}
			}
		}
		// 폭탄의 인접 네 칸을 빈 곳으로 만들기
		for (int p = 0; p < list.size(); p++) {
			int i = list.get(p).i;
			int j = list.get(p).j;
			if (Map[i][j]) {
				for (int k = 0; k < 4; k++) {
					int ni = i + di[k];
					int nj = j + dj[k];

					if (ni < 0 || nj < 0 || ni >= R || nj >= C) {
						continue;
					}
					if (Map[ni][nj]) {
						continue;
					}
					Map[ni][nj] = true;
				}
			}
		}

		// Map update
		// true는 이전에 설치된 폭탄에 의해 빈 곳이 된 곳
		// false는 이후에 설치된 폭탄들 중 남은 것들
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				Map[i][j] = !Map[i][j];
			}
		}

	}

}