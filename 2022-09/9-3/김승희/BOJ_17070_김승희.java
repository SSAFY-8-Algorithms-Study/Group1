package boj17070;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 격자의 크기가 크지 않아서 재귀 함수로 완전탐색을 진행하였다.
 * 격자는 파이프가 갈 수 있는 곳(true)과 갈 수 없는 곳(false) 2가지로 나뉘기 때문에 boolean형 2차원 배열 Map에 저장하였다.
 * move 함수(파이프의 왼쪽 위치 a, 파이프의 오른쪽 위치 b, 현재 파이프가 놓여있는 방향 d)
 * 현재 파이프가 놓여있는 방향이 가로(0)라면 가로 또는 대각선으로 갈 수 있다.
 * 현재 파이프가 놓여있는 방향이 세로(1)라면 세로 또는 대각선으로 갈 수 있다.
 * 현재 파이프가 놓여있는 방향이 대각선(2)라면 가로 또는 세로 또는 대각선으로 갈 수 있다.
 * 
 * 대각선으로 갈 수 있는지 확인할 때는 가로와 세로와 달리 4개의 칸이 빈 칸인지 확인해야 한다.
 * */

public class Main {
	static int N, ans;
	static boolean[][] Map;

	static class Tuple {
		int i, j;

		public Tuple(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}

	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		Map = new boolean[N][N];
		ans = 0;
		for (int i = 0; i < N; i++) {
			String[] inArr = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				if (inArr[j].equals("0")) {
					Map[i][j] = true;
				}
			}
		}
		move(new Tuple(0, 0), new Tuple(0, 1), 0);
		System.out.println(ans);
	}

	public static void move(Tuple a, Tuple b, int d) {
		if (b.i == N - 1 && b.j == N - 1) {
			ans++;
			return;
		}
		int ni = b.i + 1;
		int nj = b.j + 1;
		if (d == 0) {
			if (nj >= N || !Map[b.i][nj]) {
				return;
			}
			move(b, new Tuple(b.i, nj), 0);
			if (ni >= N || !Map[ni][b.j] || !Map[ni][nj]) {
				return;
			}
			move(b, new Tuple(ni, nj), 2);
		} else if (d == 1) {
			if (ni >= N || !Map[ni][b.j]) {
				return;
			}
			move(b, new Tuple(ni, b.j), 1);
			if (nj >= N || !Map[b.i][nj] || !Map[ni][nj]) {
				return;
			}
			move(b, new Tuple(ni, nj), 2);
		} else if (d == 2) {
			if (0 <= nj && nj < N && Map[b.i][nj]) {
				move(b, new Tuple(b.i, nj), 0);
			}
			if (ni < N && Map[ni][b.j]) {
				move(b, new Tuple(ni, b.j), 1);
			}
			if (ni >= N || nj >= N || !Map[b.i][nj] || !Map[ni][b.j] || !Map[ni][nj]) {
				return;
			}
			move(b, new Tuple(ni, nj), 2);
		}
	}

}
