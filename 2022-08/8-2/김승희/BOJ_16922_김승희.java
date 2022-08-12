import java.util.HashSet;
import java.util.Scanner;

public class Main {
	static int[] roma = { 1, 5, 10, 50 };
	static HashSet<Integer> set = new HashSet<>();
	static int[] select;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		select = new int[n];

		if (n > 4) {
			multiset_combination(0, 4);
			Object[] arr = set.toArray();
			int q = n / 4;
			Object[] arr2 = set.toArray();

			for (int i = 1; i < q; i++) {
				set.clear();
				for (int j = 0; j < arr.length; j++) {
					for (int k = 0; k < arr2.length; k++) {
						set.add(((int) arr[j] + (int) arr2[k]));
					}
				}
				arr2 = set.toArray();
			}
			set.clear();
			int r = n % 4;
			multiset_combination(0, r);
			arr = set.toArray();
			set.clear();
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr2.length; j++) {
					set.add((int) arr[i] + (int) arr2[j]);
				}
			}

		} else {
			multiset_combination(0, n);
		}

		System.out.println(set.size());

	}

	static void multiset_combination(int cnt, int N) {
		if (cnt == N) {
			int sum = 0;
			for (int a : select) {
				sum += a;
			}
			set.add(sum);
			return;
		}

		for (int i = 0; i < 4; i++) {
			select[cnt] = roma[i];
			multiset_combination(cnt + 1, N);
		}
	}
}