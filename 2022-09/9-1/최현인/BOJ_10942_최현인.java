package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N, M;
	static int[] nums;
	static boolean[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nums = new int[N+1];
		String temp[] = br.readLine().split(" ");
		for (int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(temp[i-1]);
		}
		
		//1개 일때는 무조건 펠린드롬, 미리 기록해 두기
		dp = new boolean[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			dp[i][i] = true;
		}
		
		//2개일 때 펠린드롬 인지 확인 후,  기록해두기
		for (int i = 1; i <= N-1; i++) {
			if (nums[i] == nums[i+1]) {
				dp[i][i+1] = true;
			}
		}
		
		//3개 부터는 기록된 애들을 이용해서 계산 시간 줄이기
		for (int i = 3; i <= N; i++) {
			for (int j = 1; j <= N+1-i; j++) {
				if (nums[j] == nums[j+i-1]) { //양 끝값이 같으면 
					if (dp[j+1][j+i-2]) { //사이 값이 같은지 확인
						dp[j][j+i-1] = true; //해당 구간은 펠린드롬임
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder(); //출력 개수가 100만개이므로 출력 내용을 미리 만들어서 프린트를 한번만 하기 위함
		M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			temp = br.readLine().split(" ");
			sb.append(dp[Integer.parseInt(temp[0])][Integer.parseInt(temp[1])] ? 1: 0).append('\n');
		}
		System.out.println(sb);
	}
}