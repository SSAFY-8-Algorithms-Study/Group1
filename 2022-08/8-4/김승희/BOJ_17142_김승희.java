import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[][] Map;
	static int N, M, min_value;
	static Tuple[] select;
	static ArrayList<Tuple> virus;
	static int[] di = { 1, -1, 0, 0 };
	static int[] dj = { 0, 0, 1, -1 };

	static class Tuple {
		int i, j;

		public Tuple(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}

		@Override
		public String toString() {
			return "Tuple [i=" + i + ", j=" + j + "]";
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		Map = new int[N][N];
		virus = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				Map[i][j] = sc.nextInt();
				if (Map[i][j] == 2) {
					virus.add(new Tuple(i, j));
				}
			}
		} // end input

		if (check(Map)) { // 처음부터 모두 바이러스인 경우
			System.out.println(0);
			System.exit(0);
		}

		min_value = Integer.MAX_VALUE;
		select = new Tuple[M];
		combination(0, 0);

		if (min_value == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(min_value);
		}

	}

	static void combination(int cnt, int start) {
		if (cnt == M) {
			bfs();
			return;
		}
		for (int i = start; i < virus.size(); i++) {
			select[cnt] = virus.get(i);
			combination(cnt + 1, i + 1);
		}
	}

	static void bfs() {
		int[][] copy = deepcopy(Map);
		Queue<Tuple> q = new ArrayDeque<>();
		for (int k = 0; k < M; k++) {
			q.add(select[k]);
			copy[select[k].i][select[k].j] = 3;
		}
		int time = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int p = 0; p < size; p++) {
				Tuple tp = q.poll();
				for (int k = 0; k < 4; k++) {
					int ni = tp.i + di[k];
					int nj = tp.j + dj[k];
					if (ni < 0 || nj < 0 || ni >= N || nj >= N) {
						continue;
					}
					if (copy[ni][nj] == 3 || copy[ni][nj] == 1) {
						continue;
					}

					q.add(new Tuple(ni, nj));
					copy[ni][nj] = 3;
				}
			}
			if (check(copy)) {
				min_value = Math.min(min_value, time + 1);
				break;
			}
			time++;
		}
	}

	static void print(int[][] arr) {
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println("------------------------------------");
	}

	static boolean check(int[][] arr) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}

	static int[][] deepcopy(int[][] arr) {
		int[][] copy = new int[arr.length][arr[0].length];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				copy[i][j] = arr[i][j];
			}
		}
		return copy;
	}

}