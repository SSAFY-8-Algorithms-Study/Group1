package boj18353;

import java.util.Arrays;
import java.util.Scanner;
/*
 * dp[i] : i번째 병사까지 전투력이 증가하는 병사의 수
 * */
public class Main {
	static class Tuple {
		int last, cnt;

		public Tuple(int last, int cnt) {
			super();
			this.last = last;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Tuple [last=" + last + ", cnt=" + cnt + "]";
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); 
		int[] soldier = new int[n];

		for (int i = 0; i < n; i++) {
			soldier[i] = sc.nextInt();
		} // end input

		if (n == 1) {
			System.out.println(0);
		} else {

			int ans = 1;
			int[] dp = new int[n];
			Arrays.fill(dp, 1);
			for (int i = 1; i < n; i++) {
				for (int j = 0; j < i; j++) {
					if (soldier[j] > soldier[i]) {
						dp[i] = Math.max(dp[i], dp[j] + 1);
					}
				}
				ans = Math.max(ans, dp[i]);
			}
//			System.out.println(Arrays.toString(dp));
			System.out.println(n - ans);
		}
	}
}
