package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 1388 바닥 장식
// DFS로 풀고 싶었는데 아직 실력이 부족한가,,
// BFS로 접근해서 풀었고, 방향은 우측 아래로 향하면서 만들어가면 되므로
// 두 방향을 이용해서 bfs를 돌렸다. 같은 방향을 비교할 때와 다른 방향을 비교할 때 검사 조건을 다르게 해주면서 풀었다.

public class Main {
    static int N, M;
    static char[][] map;
    static boolean[][] check;
    static char[] wood = {'-', '|'};
	static int[] di = {0,1};
	static int[] dj = {1,0};
	static class coord{
		int i, j;

		public coord(int i, int j) {
			this.i = i;
			this.j = j;
		}
		
	}
    public static void main(String[] args) throws IOException {    
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	
    	map = new char[N][M];
    	check = new boolean[N][M];
    	for (int i = 0; i < N; i++) {
    		map[i] = br.readLine().toCharArray();
    	}
    	int count= 0;
    	for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (check[i][j]) {
					continue;
				}
				else {
					count++;
					bfs(i,j);
				}
			}
		}
    	System.out.println(count);
    }
	public static void bfs(int i, int j) {
		ArrayDeque<coord> q = new ArrayDeque<>();
		q.add(new coord(i, j));
		check[i][j] = true;
		
		while (!q.isEmpty()) {
			coord temp = q.poll();
			for (int k = 0; k < 2; k++) {
				int ni = temp.i+di[k];
				int nj = temp.j+dj[k];
				if (ni < 0 || nj < 0 || ni >= N || nj >= M) {
					continue;
				}
				if (check[ni][nj]) {
					continue;
				}
				if (map[i][j] == wood[k] && map[ni][nj] == wood[k]) {
					check[ni][nj] = true;
					q.add(new coord(ni, nj));
				}
			}
		}
		
	}
}