package week11_1;

import java.util.Scanner;

/*
 * 최단 거리의 경우의 수를 고려하여 거리를 계산한다.
 * 1. 대각선 한 번 이동하는 것보다 가로+세로 이동하는 것이 더 빠른 경우
 * 2. 가로+세로 이동보다 대각선 이동이 더 빠른경우
 * 	2-1. 대각선으로만 이동이 가능한 경우 
 * 	2-2. 대각선 이동과 가로 또는 세로 이동이 한 번 필요한 경우 
 * 3. 대각선 이동과 가로+세로 이동을 모두 사용해야 하는 경우
 * */

public class BOJ_1459_백자민 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long x = sc.nextInt();
		long y = sc.nextInt();
		int w = sc.nextInt();
		int s = sc.nextInt();
		
		long result = 0;
		
		
		if(2*w < s) {//대각선 한번보다 가로+세로 이동이 더 빠른 경우
			result = (x+y)*w; //가로+세로로만 이동 
		}
		
		//가로세로보다 대각선이 빠른 경우
		else if(w > s) {
			if((x+y)%2==0) result = Math.max(x, y)*s; //대각선으로만 이동 가능
			else result = (Math.max(x, y)-1)*s + w; //대각선 + 마지막에 가로/세로
		}
		
		else { 
			long temp = Math.min(x*s, y*s); //일단 대각선으로 가능한만큼 이동
			result = temp+Math.abs(x-y)*w; //남은만큼 가로+세로로 도착
		}
		
		System.out.println(result);
	}
}
