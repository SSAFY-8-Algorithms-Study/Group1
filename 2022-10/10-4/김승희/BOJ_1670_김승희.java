import java.util.Scanner;
/*
 * dp로 풀었다.
 * */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[] dp = new long[N + 1];
		dp[2] = dp[0] = 1;
		for (int i = 4; i <= N; i += 2) {
			for (int j = 2; i - j >= 0; j += 2) {
				dp[i] = (dp[i] + (dp[j - 2] * dp[i - j]) % 987654321) % 987654321;
			}
		}
		System.out.println(dp[N]);
	}
}