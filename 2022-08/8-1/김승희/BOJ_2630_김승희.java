package bj2630;

import java.util.Scanner;

public class Main {
	static int[][] map;
	static int white = 0;
	static int blue = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		Process(0, 0, N);
		System.out.println(white);
		System.out.println(blue);
	}

	public static void Process(int i, int j, int len) {
		int temp = isOne(i, j, len);
		if (temp == 0) {
			white++;
		} else if (temp == 1) {
			blue++;
		} else {
			Process(i, j, len / 2);
			Process(i, j + len / 2, len / 2);
			Process(i + len / 2, j, len / 2);
			Process(i + len / 2, j + len / 2, len / 2);
		}
	}

	public static int isOne(int i, int j, int len) {
		int chk = map[i][j];
		for (int x = 0; x < len; x++) {
			for (int y = 0; y < len; y++) {
				if (chk != map[i + x][j + y]) {
					return -100;
				}
			}
		}
		return chk;
	}

}
