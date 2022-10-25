package study.oct2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 맵을 만들어두고, 음식물쓰레기 위치를 1로 체크해둔다음 1위치에서
// dfs를 써서 음식물수 확장해서 가장큰 값을 출력.
public class BOJ1743 {
	static int n, m, k, ans, cnt;
	static int[][] map;
	static boolean[][] v;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[n + 1][m + 1];
		v = new boolean[n + 1][m + 1];
		ans = 1;
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r][c] = 1;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (!v[i][j] && map[i][j] == 1) {
					cnt = 1;
					dfs(i, j);
				}
			}
		}
		System.out.println(ans);
	}

	private static void dfs(int i, int j) {
		if (ans < cnt) {
			ans = cnt;
		}
		v[i][j] = true;
		for (int d = 0; d < 4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if (0 < ni && ni <= n && 0 < nj && nj <= m && !v[ni][nj] && map[ni][nj] == 1) {
				v[ni][nj] = true;
				cnt++;
				dfs(ni, nj);
			}
		}
	}
}
