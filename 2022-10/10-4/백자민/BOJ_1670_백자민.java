package week10_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 한 그룹(2명)이 악수를 하면 해당 그룹을 기준으로 두 개의 구역이 생성된다. 
 * 따라서 이렇게 두 개의 구역을 나눌 수 있는 경우마다 악수를 할 수 있는 경우의 수를 구해서 곱한다. 
 * 각 구역에는 짝수 명의 사람이 있어야 모두 악수를 할 수 있으므로 이를 기준으로 반복문을 사용하여 경우의 수를 구한다. 
 * */

public class BOJ_1670_백자민 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		long[] sum = new long[n+1];
		
		//1번은 고려하지 않음 - 그러면 한쪽 구역에 홀수명이 남기 때문 
		sum[0] = 1;
		sum[2] = 1;
		
		for(int i=4;i<=n;i+=2) { //모두 악수를 해야 하기 때문에 짝수로 맞추기
			for(int j=0;j<=i-2;j+=2) {
				sum[i] += sum[j]*sum[i-j-2];
				sum[i] %= 987654321;
			}
		}
		
		System.out.println(sum[n]);
	}
}
