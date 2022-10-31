package boj2003;

import java.util.Arrays;
import java.util.Scanner;
/*
 * two pointer를 이용해 풀이
 * N이 1일 경우는 따로 처리해줌
 * ans의 초기값은 number[0] 값이 M과 같을 경우에는 1, 그렇지 않을 경우에는 0
 * sum의 초기값은 number[0] + number[1]
 * sum이 M보다 작으면 end를 ++해서 sum을 키운다.
 * sum이 M과 같으면 ans를 ++, end를 ++해서 sum을 키운다.
 * sum이 M보다 크면 start와 end가 같을 경우에는 end를 ++, 그렇지 않을 경우에는 start를 ++.
 * -> start가 end보다 커질 수 없도록
 * 
 * end의 값이 범위를 넘어가지 않도록 처리해줘야 한다.
 * */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] number = new int[N];

		for (int i = 0; i < N; i++) {
			number[i] = sc.nextInt();
		}
		int start = 0;
		int end = start + 1;
		int ans = number[start] == M ? 1 : 0;
		if (N == 1) {
			System.out.println(ans);
			System.exit(0);
		}
		int sum = number[start] + number[end];

		while (true) {
			if (sum < M) {
				end++;
				if (end == N)
					break;
				sum += number[end];
			} else if (sum == M) {
				ans++;
				end++;
				if (end == N)
					break;
				sum += number[end];
			} else {
				if (start == end) {
					end++;
					if (end == N)
						break;
					sum += number[end];
				} else {
					sum -= number[start];
					start++;
				}
			}
			System.out.println("start : " + start + " end : " + end);
			System.out.println("ans " + ans);
		}
		System.out.println(ans);
	}
}
/*
 * 
 * 9 8 1 2 3 9 4 4 3 1 7
 * 
 * 4 8 1 2 3 9
 * 
 * 4 8 1 2 3 8
 * 
 * 9 8 1 2 3 8 4 4 3 1 7
 */
