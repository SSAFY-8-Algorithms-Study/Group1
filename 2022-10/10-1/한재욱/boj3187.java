import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 방문하지 않은 곳이며, 울타리가 아닌 지점에서 bfs탐색해서 울타리가 나눈 영역을 구하고 양의 수(v) 늑대의수(k)수를 탐색하면서 count해서 
//양이 많으면 양이 살아남고 늑대가 남으면 늑대가 살아남게한후 늑대와 양의수를 출력.

public class Main {
	static int R, C, av, ak;
	static char[][] map;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];
		av = 0;
		ak = 0;
		for (int i = 0; i < R; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = tmp.charAt(j);
			}
		} // end
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (!visited[i][j] && map[i][j] != '#') {
					bfs(new Point(i, j));
				}
			}
		}
		System.out.println(ak + " " + av);
	}

	private static void bfs(Point p) {
//		System.out.println("시작 "+p.i+" "+p.j);
		Queue<Point> que = new ArrayDeque<>();
		int vcnt = 0, kcnt = 0;
		que.add(p);
		if(map[p.i][p.j]=='v') vcnt++;
		else if(map[p.i][p.j]=='k') kcnt++;
		visited[p.i][p.j] = true;
		while(!que.isEmpty()) {
			Point cur = que.poll();
			for(int d=0;d<4;d++) {
				int ni = cur.i+di[d];
				int nj = cur.j+dj[d];
				if(0<=ni&&ni<R&&0<=nj&&nj<C&&map[ni][nj]!='#'&&!visited[ni][nj]) {
					visited[ni][nj] = true;
					que.add(new Point(ni, nj));
					if(map[ni][nj]=='v') vcnt++;
					else if(map[ni][nj]=='k') kcnt++;
				}
			}
		}
		if(vcnt>=kcnt) av += vcnt;
		else if(vcnt<kcnt) ak += kcnt;
	}

	static class Point {
		int i, j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}

	}
}