import java.util.Scanner;

public class Main {
	static int N;
	static int[] number;
	static boolean[] select, check;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		number = new int[N];
		select = new boolean[N];
		int sum = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			number[i] = sc.nextInt();
			if (number[i] < min) {
				min = number[i];
			}
			sum += number[i];
		}
		if (min > 1) {
			System.out.println(1);
		} else {
			check = new boolean[sum + 2];
			subset(0);
			for (int i = 1; i < sum + 2; i++) {
				if (!check[i]) {
					System.out.println(i);
					break;
				}
			}
		}
	}

	static void subset(int cnt) {
		if (cnt == N) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				if (select[i])
					sum += number[i];
			}
			check[sum] = true;
			return;
		}
		select[cnt] = true;
		subset(cnt + 1);
		select[cnt] = false;
		subset(cnt + 1);
	}

}
