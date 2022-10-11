package boj11403;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 플로이드 워셜 알고리즘 사용
 * D 배열의 값이 Integer.MAX_VALUE라면 경로가 없는 것.
 * */

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[][] D = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(D[i], Integer.MAX_VALUE);
		}
		boolean[][] graph = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int temp = sc.nextInt();
				if (temp == 0) {
					graph[i][j] = false;
				} else {
					graph[i][j] = true;
					D[i][j] = 1;
				}
			}
		} // end input

		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (D[i][j] == Integer.MAX_VALUE) {
						if (D[i][k] != Integer.MAX_VALUE && D[k][j] != Integer.MAX_VALUE) {
							D[i][j] = D[i][k] + D[k][j];
						}
					} else {
						if (D[i][k] != Integer.MAX_VALUE && D[k][j] != Integer.MAX_VALUE) {
							D[i][j] = Math.min(D[i][j], D[i][k] + D[k][j]);
						}
					}
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (D[i][j] == Integer.MAX_VALUE) {
					System.out.print(0 + " ");
				} else {
					System.out.print(1 + " ");
				}
			}
			System.out.println();
		}

	}

}
