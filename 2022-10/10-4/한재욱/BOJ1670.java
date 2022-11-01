package study.oct5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1670 {
	// 2:1, 4:2, 6:5 ,8:14, 10:42
	/* 위에 경우에서 한지점을 잡고 두사람이 악수할때 남은 것의 경우의 수느낌으로
	 * 4명중 2명이 악수할 경우(1명을 기준점으로 잡고) dp[0]*dp[2], dp[2] % dp[0] 이 두가지 경우가나오는대ㅔ
	 * 그 경우의 수를 다더하면 답이 나옴. 규칙성 파악하기가 어려웠다. 
	 * */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long dp[] = new long[10_001];
		dp[0] = 1;
		dp[2] = 1;
		for(int i=4;i<=N;i+=2) {
			for(int j=0;j<=i-2;j+=2) {
				dp[i] += ((dp[j] * dp[i-2-j])%987654321);
				dp[i] %= 987654321;
			}
		}
		System.out.println(dp[N]);
	}
}

