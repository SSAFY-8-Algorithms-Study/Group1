import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 상근이는 불이 붙으려는 칸은 움직일 수 없고, 불이 옮겨옴과 동시에 다른칸으로 이동가능
// BFS문제. Que에먼저 불부터 담아주고, 상근이를 담아줌. visit배열은 상근이만 줬음.
// Que에서 나온게 type이 상근(s)일때와 불(f)일때 나눠서 가장 빠른시간 또는 불가능한 경우 출력
public class Main {
	static int w, h, time;
	static int[][] map;
	static boolean[][] v;
	static Queue<Point> que;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };
	static boolean exit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int Tc = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= Tc; tc++) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			map = new int[h][w];
			v = new boolean[h][w];
			time = 0;
			que = new ArrayDeque<>();
			exit = false;
			Point start = null;
			for (int i = 0; i < h; i++) {
				String line = br.readLine();
				for (int j = 0; j < w; j++) {
					map[i][j] = line.charAt(j);
					if (map[i][j] == '*')
						que.add(new Point(i, j, 'f'));
					if (map[i][j] == '@')
						start = new Point(i, j, 's');
				}
			} // end
			bfs(start);
			
			System.out.println((exit?time:"IMPOSSIBLE"));
		}
	}

	private static void bfs(Point start) {
		que.add(start);
		v[start.i][start.j] = true;
		while (!que.isEmpty()) {
			int size = que.size();
			while (--size >= 0) {
				Point cur = que.poll();
				if(cur.type=='e') {
					exit = true;
					return;
				}
				if (cur.type == 'f') {
					for (int d = 0; d < 4; d++) {
						int ni = cur.i + di[d];
						int nj = cur.j + dj[d];
						if (0 <= ni && ni < h && 0 <= nj && nj < w && map[ni][nj] != '#'&& map[ni][nj] != '*') {
							map[ni][nj] = '*';
							que.add(new Point(ni, nj, 'f'));
						}
					}
				} else {
					for (int d = 0; d < 4; d++) {
						int ni = cur.i + di[d];
						int nj = cur.j + dj[d];
						if (0 <= ni && ni < h && 0 <= nj && nj<w) {
							if(map[ni][nj]!='#'&&map[ni][nj]!='*'&&!v[ni][nj]) {
								que.add(new Point(ni, nj,'s'));
								v[ni][nj] = true;
							}
						}else {
							que.add(new Point(ni, nj,'e'));
						}
					}
				}
			}
			time++;
		}
	}

	static class Point {
		int i, j;
		char type;

		public Point(int i, int j, char type) {
			this.i = i;
			this.j = j;
			this.type = type;
		}

	}
}