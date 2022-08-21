import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static char[][] paper;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		paper = new char[N][N];
		for(int i = 0; i < N; i++) {
			Arrays.fill(paper[i], ' ');
		}
		paint(0, 0, N);
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(paper[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());

	}

	public static void paint(int i, int j, int len) {
		if (len == 3) {
			basic(i, j);
			return;
		}
		int nlen = len / 3;
		paint(i, j, nlen);
		paint(i, j + nlen, nlen);
		paint(i, j + nlen * 2, nlen);
		paint(i + nlen, j, nlen);
		paint(i + nlen, j + nlen * 2, nlen);
		paint(i + nlen * 2, j, nlen);
		paint(i + nlen * 2, j + nlen, nlen);
		paint(i + nlen * 2, j + nlen * 2, nlen);

	}

	public static void basic(int i, int j) {
		for (int p = 0; p < 3; p++) {
			for (int q = 0; q < 3; q++) {
				if (p == 1 && q == 1) {
					continue;
				}
				paper[i + p][j + q] = '*';
			}
		}
	}

}