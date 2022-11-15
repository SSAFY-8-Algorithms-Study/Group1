package week11_1;

import java.util.Scanner;

/*
 * 줄어들지 않는 수를 만들 수 있는 모든 경우의 수를 규칙에 따라 구해둔 후 원하는 값을 출력한다.
 * 2차원 배열의 i 인덱스는 만들 수 있는 수의 길이(한 자리수, 두 자리수 ...)이고 j 인덱스는 사용할 수 있는 숫자의 범위이다.
 * 한자리 수일 경우를 모두 구해준 후, 이를 이용하여 더 큰 수를 만들 경우를 구한다. 이후 주어진 자리수로 구할 수 있는 최대 개수를 출력한다.
 * */

public class BOJ_2688_백자민 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		long[][] num = new long[65][10];
		
		for(int i=0;i<10;i++) { //한자리 수일 경우
			num[1][i] = i+1;
		}
		
		for(int t=0;t<T;t++) {
			int n = sc.nextInt();
			
			for(int i=2;i<=n;i++) { //한자리 수일 경우 빼고 나머지 자리수일 경우 구하기 
				num[i][0] = 1;
				for(int j=1;j<10;j++) {
					num[i][j] = num[i-1][j]+num[i][j-1]; // 이전 자리수~9 
				}
			}
			
			System.out.println(num[n][9]);
		}
	}
}
