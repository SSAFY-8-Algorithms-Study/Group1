package boj;

// 1670 정상 회담 2
// 접근 법이 어려워서 고민을 많이 한 것 치고, 코드는 매우 간단
// 파스칼의 삼각형 느낌인데, 경우의 수를 구해야 하는 문제 이므로
// 악수하는 사람 2명을 정하면 남은 사람끼리 악수하는 방법은 이전의 구했던 값으로 대체할 수 있다고 판단
// DP를 적용하면 될 것같아서 DP로 풀었음
// 점화식을 세워보면 결국 DP(N) = N + ((N-2) *2) + ((N-4) * 4) + ... + (4 * (N- 4)) + (2 * (N-2)) + (N) 
// 곱셈 결과가 int를 벗어나고, long도 벗어나서 문제에서 정답을 987654321로 나눈 나머지를 출력하라고 한 것

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력 받기 위한 버퍼리더
		
		int N = Integer.parseInt(br.readLine()); 
		
		long[] dp = new long[10001];
		dp[0] = 1;
		dp[2] = 1;
		dp[4] = 2;
		
		for (int i = 6; i <= 10000; i+=2) {
			for (int j = 0; j <= i-2; j+=2) {
				dp[i] += ((dp[j]%987654321)* (dp[i-2-j] % 987654321))%987654321; 
			}
		}
		dp[0] = 0;
		System.out.println(dp[N]%987654321);
	}
}
