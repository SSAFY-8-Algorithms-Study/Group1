// 1743 음식물 피하기
// BFS 정석 문제
// 처음에는 map이랑 check 배열을 둘다 만들었는데 다시 보니 그렇게 안해도 될 것같아서
// check배열 하나로 해보았다. int 배열이라서 메모리를 생각보다 좀 먹어서 차라리 boolean 배열 두개로 하는 게 메모리는 더 적게 먹을 것 같다

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static int N,M, answer;
	static int[][] check;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	
	static class coord{
		int i, j;

		public coord(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		check = new int[N][M];
		answer = Integer.MIN_VALUE;
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken()) -1;
			int j = Integer.parseInt(st.nextToken()) -1;
			check[i][j] = 1;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (check[i][j] == 1) {
					check[i][j] = 2;
					bfs(i,j);
				}
			}
		}
		System.out.println(answer);
	}
	public static void bfs(int i, int j) {
		ArrayDeque<coord> q = new ArrayDeque<>();
		q.add(new coord(i, j));
		int count = 1;
		while (!q.isEmpty()) {
			coord temp = q.poll();
			for (int k = 0; k < 4; k++) {
				int ni = temp.i +di[k];
				int nj = temp.j +dj[k];
				if (ni < 0 || nj < 0 || ni >= N || nj >= M || check[ni][nj] == 2 || check[ni][nj] == 0) {
					continue;
				}
				check[ni][nj] = 2;
				count++;
				q.add(new coord(ni, nj));
			}
		}
		answer = Integer.max(count, answer);
	}
}