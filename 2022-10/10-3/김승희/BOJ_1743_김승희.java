package boj1743;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/*
 * BFS 돌림
 *
 * */

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		boolean[][] map = new boolean[N][M];
		for(int i = 0; i < K; i++) {
			int a = sc.nextInt()-1;
			int b = sc.nextInt()-1;
			map[a][b] = true;
		}
		
		int size = 0;
		int[] di = {-1, 1, 0, 0};
		int[] dj = {0, 0, -1, 1};
		boolean[][] visit= new boolean[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(!map[i][j] || visit[i][j]) continue;
				Queue<int[]> Q = new ArrayDeque<>();
				Q.add(new int[] {i, j});
				visit[i][j] = true;
				int temp = 0;
				while(!Q.isEmpty()) {
					int[] a = Q.poll();
					temp++;
					for(int k = 0; k < 4; k++) {
						int ni = a[0] + di[k];
						int nj = a[1] + dj[k];
						if(ni < 0 || nj < 0 || ni >= N || nj >= M) continue;
						if(!map[ni][nj] || visit[ni][nj]) continue;
						visit[ni][nj] = true;
						Q.add(new int[] {ni, nj});
					}
				}
				size = Math.max(size, temp);
			}
		}
		System.out.println(size);
	}

}
