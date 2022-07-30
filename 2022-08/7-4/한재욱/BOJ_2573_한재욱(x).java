package juyly_4th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2573_ {
	static int[] dx = { 0, 0, -1, 1, 1, 1, -1, -1 };
	static int[] dy = { -1, 1, 0, 0, 1, -1, -1, 1 };

	public static int removeice(int y, int x, int[][] map) {// 5 3
		int cnt = 0;
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (0 <= nx && nx < map[0].length && 0 <= ny && ny < map.length && map[ny][nx] == 0) {
				cnt++;
			}
		}
		return cnt;
	}

	public static boolean twoIceverg(int[][] map) {
		System.out.println("실행");
		int cnt = 0;
		int[][] visited = new int[map.length][map[0].length];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] != 0 && visited[i][j]!=0) {
					cnt++;
					visited[i][j] = 1;
					visited = spread(i,j ,map, visited);
				}
			}
		}
		if (cnt > 2) {
			return true;
		}
		return false;
	}
	
	public static int[][] spread(int y, int x, int[][]map, int[][]visited){
		for(int i=0; i<8; i++) {
			int ny = y + dy[i];
			int nx = x+ dx[i];
			if(0<=nx && nx<map.length && 0<=ny && ny<map.length && visited[ny][nx]==0&&map[ny][nx]>0)  {
				visited[ny][nx] = 1;
				visited = spread(ny, nx, map, visited);
				System.out.println(Arrays.deepToString(visited));
			}
		}
		return visited;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
		int map[][] = new int[n][m];
		int remove[][];
		int time = 0;

		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		remove = new int[n][m];
		while (true) {
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if (map[i][j] != 0) {
						remove[i][j] = removeice(i, j, map);
					}
				}
			}
			for (int i = 0; i < remove.length; i++) {
				for (int j = 0; j < remove[i].length; j++) {
					map[i][j] -= remove[i][j];
					if(map[i][j]<0) {
						map[i][j] = 0;
					}
				}
			}
			time++;

			if (twoIceverg(map)) {
				break;
			}
			break;
		}
		System.out.println(time);
	}
}
