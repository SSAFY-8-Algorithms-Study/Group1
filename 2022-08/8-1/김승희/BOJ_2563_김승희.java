package bj2563;

import java.util.Scanner;

public class Main {
	static int[][] map;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		map = new int[100][100];

		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			fill(a, b);
		}
		int area = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j] == 1) {
					area++;
				}
			}
		}
		System.out.println(area);

	}

	public static void fill(int a, int b) {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				map[a + i][b + j] = 1;
			}
		}
	}

}
