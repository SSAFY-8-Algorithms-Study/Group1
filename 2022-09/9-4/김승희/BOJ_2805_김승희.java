package boj2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * binary search로 높이를 구했다.
 * mid값이 절단기에 설정할 수 있는 높이 값.
 * 만약 mid값으로 잘랐을 때 얻는 나무의 양이 M보다 적다면 mid 값을 작게 해서 더 잘리도록 해줘야 한다.
 * -> end를 mid-1로
 * 만약 mid값으로 잘랐을 때 얻는 나무의 양이 M과 같거나 크다면 mid 값을 크게 해서 덜 잘리도록 해줘야 한다.
 * -> start를 mid+1로
 * -> 최대한 덜 자르도록 해야 하기 때문에 M과 같을 때에도 해준다.
 * */

public class Main {
	static int N, M;
	static long[] trees;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inArr = br.readLine().split(" ");
		N = Integer.parseInt(inArr[0]);
		M = Integer.parseInt(inArr[1]);

		trees = new long[N];
		inArr = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			trees[i] = Long.parseLong(inArr[i]);
		} // end input

		long start = 0;
		long end = 1000000000;
		long ans = 0;
		while (start <= end) {
			long mid = (start + end) / 2;
			long acc = sum(mid);

			if (acc < M) {
				end = mid - 1;
			} else {
				start = mid + 1;
				ans = Math.max(ans, mid);
			}
		}
		System.out.println(ans);

	}

	public static long sum(long mid) {
		long acc = 0;
		for (int i = 0; i < N; i++) {
			if (trees[i] > mid) {
				acc += trees[i] - mid;
			}
		}
		return acc;
	}

}
