package study.oct5;

import java.util.Arrays;
import java.util.Scanner;

// 왼쪽->오른쪽 미로탈 출 최소 몇번 점프 해야 갈수 있는지.
/*dp문제로 생각
 * dp배열을 가장 큰수로 초기화 하고, 움직 인 횟수를 dp배열에 넣을것
 *  첫번째 칸에 쓰인 정수부터, 움직일 수 잇는 범위로 뛸 때 그 칸에 있는 수보다 내가 움직인 횟수가 작으면 값을 변경.
 *  도달 하지 못하면 -1 출력. 
 * */
public class BOJ11060 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] map = new int[n];
		int[] dp = new int[n];
		for (int i = 0; i < n; i++) {
			map[i] = sc.nextInt();
		} // end
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int i = 0; i < n; i++) {
			if (i + 1 > n - 1 || dp[i] == Integer.MAX_VALUE)
				continue;
			for (int j = i + 1; j < i + 1 + map[i]; j++) {
				if (j > n - 1)
					break;
				if (dp[j] > dp[i] + 1) {
					dp[j] = dp[i] + 1;
				}
			}
		}
		System.out.println(dp[n - 1] == Integer.MAX_VALUE ? -1 : dp[n - 1]);

	}
}