import java.util.Scanner;

public class Main {
	static int N, K, answer;
	static int[] kit, kit_select;
	static boolean[] select;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		K = sc.nextInt();
		answer = 0;
		kit = new int[N];
		kit_select = new int[N];
		select = new boolean[N];

		for (int i = 0; i < N; i++) {
			kit[i] = sc.nextInt();
		}

		permutation(0);
		System.out.println(answer);

	}

	static void permutation(int cnt) {
		if (cnt == N) {
			if (check()) {
				answer++;
			}
			return;
		}

		for (int i = 0; i < N; i++) {
			if (select[i])
				continue;
			kit_select[cnt] = kit[i];
			select[i] = true;
			permutation(cnt + 1);
			select[i] = false;
		}
	}

	static boolean check() {
		int weight = 500;
		for (int i = 0; i < N; i++) {
			weight += kit_select[i] - K;
			if (weight < 500) {
				return false;
			}
		}
		return true;
	}

}