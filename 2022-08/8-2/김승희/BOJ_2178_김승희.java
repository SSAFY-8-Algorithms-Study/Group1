import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inArr = br.readLine().split(" ");
		int n = Integer.parseInt(inArr[0]);
		int m = Integer.parseInt(inArr[1]);

		char[][] map = new char[n][m];

		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}

		int[] di = { 1, -1, 0, 0 };
		int[] dj = { 0, 0, 1, -1 };

		boolean[][] visit = new boolean[n][m];
		Queue<Tuple> queue = new LinkedList<>();

		queue.add(new Tuple(0, 0, 1));
		visit[0][0] = true;
		while (!queue.isEmpty()) {
			Tuple tp = queue.poll();
			for (int i = 0; i < 4; i++) {
				int ni = tp.i + di[i];
				int nj = tp.j + dj[i];
				if (ni < 0 || nj < 0 || ni >= n || nj >= m) {
					continue;
				}
				if (map[ni][nj] == '0' || visit[ni][nj]) {
					continue;
				}

				if (ni == n - 1 && nj == m - 1) {
					System.out.println(tp.dist + 1);
					System.exit(0);
				}
				queue.add(new Tuple(ni, nj, tp.dist + 1));
				visit[ni][nj] = true;
			}
		}

	}

	static class Tuple {
		int i, j, dist;

		public Tuple(int i, int j, int d) {
			this.i = i;
			this.j = j;
			dist = d;
		}
	}

}