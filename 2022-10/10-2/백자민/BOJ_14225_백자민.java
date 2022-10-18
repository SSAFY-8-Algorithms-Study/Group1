package week10_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 주어진 수열의 부분 수열의 합을 재귀를 사용하여 구한다. 이 때 구한 부분수열의 합은 boolean 배열에 저장해둔다.
 * 배열을 처음부터 순차적으로 탐색하며 false값을 가진 (부분수열로 만들지 못한 수) 가장 작은 값을 출력한다.
 * */


public class BOJ_14225_백자민 {
	
	static int N, min;
	
	static int[] nums;
	static boolean[] visit;
	
	static void findSet(int idx, int sum) {
		if(idx==N) {
			System.out.println(sum);
			visit[sum] = true;
		}
		else {
			findSet(idx+1, sum+nums[idx]);
			findSet(idx+1, sum);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		nums = new int[N];
		visit = new boolean[20*100000+1];
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		findSet(0,0);
		
		min = 1;
		while(visit[min]) {
			min++;
		}
		System.out.println(min);
	}
}
