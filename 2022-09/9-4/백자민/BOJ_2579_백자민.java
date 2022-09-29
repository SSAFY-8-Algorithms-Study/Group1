package week9_4;

import java.util.Scanner;

/*
 * 1번 계단, 2번 계단, 3번 계단까지 오르는 경우의 수 중 최댓값을 구하고, 이후 계단부터는 앞서 구한 세 가지 값을 이용하여 최댓값을 구한다. 
 * 
 * */

public class BOJ_2579_백자민 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] score = new int[301];
		int[] sum = new int[301];
		
		for(int i=1;i<=N;i++) {
			score[i] = sc.nextInt();
		}
		
		sum[1] = score[1];
		sum[2] = score[1]+score[2];
		sum[3] = Math.max(score[1]+score[3], score[2]+score[3]);
		
		for(int n=4;n<=N;n++) {
			sum[n] = Math.max(sum[n-3]+score[n-1]+score[n], sum[n-2]+score[n]);
		}
		System.out.println(sum[N]);
	}
}
