package Aug1;

import java.util.Scanner;

public class boj2563 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int Tc = sc.nextInt();
		int area = 0;
		int map[][] = new int[101][101];
		for (int tc = 0; tc < Tc; tc++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			for (int i = y; i < y + 10; i++) {
				for (int j = x; j < x + 10; j++) {
					if (map[i][j] == 0) {
						map[i][j] = 1;
						area++;
					}
				}
			}
		}
		System.out.println(area);
	}
}