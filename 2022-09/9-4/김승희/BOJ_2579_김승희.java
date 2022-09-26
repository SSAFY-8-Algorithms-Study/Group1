package boj2579;

import java.util.Scanner;
/*
 * dp를 이용해 해결
 * dp[i][0] -> i번째 계단까지 오는데 1번 연속으로 밟았다.
 * -> 그 전 계단(i-1번 계단)을 밟으면 안된다.
 * -> 그 전전 계단(i-2번 계단)을 오르는 2가지 방법(dp[i-2][0], dp[i-2][1]) 중 큰 값을 선택.
 * dp[i][1] -> i번쨰 계단까지 오는데 2번 연속으로 밟았다.
 * -> 그 전 계단(i-1번 계단)까지 오는데 1번 연속으로 밟아야 한다. -> dp[i-1][0]
 * */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] stairs = new int[N];
		for (int i = 0; i < N; i++) {
			stairs[i] = sc.nextInt();
		}

		int[][] dp = new int[N][2];
		dp[0][0] = stairs[0];
		for (int i = 1; i < N; i++) {
			if (i == 1) {
				dp[i][0] = stairs[i];
				dp[i][1] = dp[i-1][0] + stairs[i];
			} else {
				dp[i][0] = stairs[i] + Math.max(dp[i-2][0], dp[i-2][1]);
				dp[i][1] = dp[i-1][0] + stairs[i];	
			}
		}

		int answer = Math.max(dp[N - 1][0], dp[N - 1][1]);
		System.out.println(answer);
	}

}
