package boj11060;

import java.util.Arrays;
import java.util.Scanner;
/*
 * dp[i] : i번째 칸까지 최소 몇 번 점프를 해야 하는지
 * dp 배열을 Integer.MAX_VALUE로 채운다.
 * dp[0]을 0으로 초기화한다.
 * N만큼 for문을 돌리면서 
 * dp[i]의 값이 Integer.MAX_VALUE의 값과 같다면 멈춘다. -> 중간에 갈 수 있는 길이 끊겼다는 의미
 * num[i]의 값만큼 또 for문을 돌리면서 dp 값을 update 한다.
 * */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] num = new int[N];
		
		for(int i = 0; i < N; i++) {
			num[i] = sc.nextInt();
		}
		
		int[] dp = new int[N];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for(int i = 0; i< N; i++) {
			if(dp[i] == Integer.MAX_VALUE) break;
			for(int j = 1; j <= num[i]; j++) {
				int idx = i + j;
				if(idx == N) break;
				dp[idx] = Math.min(dp[idx], dp[i]+1);
			}
		}
		System.out.println(dp[N-1] == Integer.MAX_VALUE ? -1 : dp[N-1]);
		
	}

}
