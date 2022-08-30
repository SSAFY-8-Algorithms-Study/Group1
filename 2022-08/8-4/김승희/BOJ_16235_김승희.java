import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static int N, M, K;
	static int[][] A, Food;
	static ArrayList<Integer>[][] Tree;
	static int[] di = { 1, -1, 0, 0, 1, 1, -1, -1 };
	static int[] dj = { 0, 0, 1, -1, 1, -1, 1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		A = new int[N][N];
		Food = new int[N][N];
		Tree = new ArrayList[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				A[i][j] = sc.nextInt();
				Food[i][j] = 5;
				Tree[i][j] = new ArrayList<>();
			}
		}

		for (int k = 0; k < M; k++) {
			// zero index로 맞추기 위해 -1
			int i = sc.nextInt() - 1;
			int j = sc.nextInt() - 1;
			int age = sc.nextInt();
			Tree[i][j].add(age);
		}
		// end input. init.

		int year = 0;
		while (year != K) {
			SS();
			Autumn();
			Winter();
			year++;
		}

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				cnt += Tree[i][j].size();
			}
		}
		System.out.println(cnt);
	}

	static void SS() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (Tree[i][j].size() == 0)
					continue;
				int dead = 0;
				ArrayList<Integer> temp = new ArrayList<>();
				for (int p = 0; p < Tree[i][j].size(); p++) {
					int age = Tree[i][j].get(p);
					if (Food[i][j] >= age) {
						Food[i][j] -= age;
						temp.add(age + 1);
					} else {
						dead += age / 2;
					}
				}
				Tree[i][j] = temp;
				Food[i][j] += dead;
			}
		}
	}

	static void Autumn() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (Tree[i][j].size() == 0)
					continue;
				for (int p = 0; p < Tree[i][j].size(); p++) {
					int age = Tree[i][j].get(p);
					if (age % 5 == 0) {
						for (int k = 0; k < 8; k++) {
							int ni = i + di[k];
							int nj = j + dj[k];
							if (ni < 0 || nj < 0 || ni >= N || nj >= N) {
								continue;
							}
							Tree[ni][nj].add(1);
						}
					}
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (Tree[i][j].size() == 0)
					continue;
				Collections.sort(Tree[i][j]);
			}
		}
	}

	static void Winter() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				Food[i][j] += A[i][j];
			}
		}
	}

}