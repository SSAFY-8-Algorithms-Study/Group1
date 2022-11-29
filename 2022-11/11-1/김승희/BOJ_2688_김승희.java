package boj2688;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 앞에서 2번쨰 자리를 고정시켜두고 앞에서 1번쨰 자리에 뭐가 올 수 있는지 경우의 수를 count 했다.
 * 길이가 1일 때는 모두 하나의 숫자만 올 수 있으므로 24번째 줄처럼 초기화를 해주고
 * 길이가 2일 때는 
 * 0이 앞에서 2번째 자리라면 앞에는 9부터 0까지 모두 올 수 있으니까 10,
 * 1이 앞에서 2번쨰 자리라면 앞에는 9부터 1까지 올 수 있으니까 9,
 * 
 * 이런 식으로 dp와 같이 풀었다.
 * */
public class Main {
	static int cnt, N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		int[] input = new int[tc];
		int maxV = Integer.MIN_VALUE;
		for (int i = 0; i < tc; i++) {
			input[i] = Integer.parseInt(br.readLine());
			maxV = Math.max(maxV, input[i]);
		}

		long[][] dp = new long[maxV + 1][10];
		dp[1] = new long[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		if (maxV > 1) {
			dp[2] = new long[] { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		}
		for (int i = 3; i <= maxV; i++) {
			long sum = 0;
			for (int j = 0; j < 10; j++) {
				sum += dp[i - 1][j];
			}
			dp[i][0] = sum;
			for (int j = 1; j < 10; j++) {
				sum -= dp[i - 1][j - 1];
				dp[i][j] = sum;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < tc; i++) {
			long cnt = count(dp[input[i]]);
			sb.append(cnt + "\n");
		}
		System.out.println(sb.toString());

	}

	static long count(long[] arr) {
		long sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}

}
