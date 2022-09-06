package week9_1;

import java.util.Scanner;

public class BOJ_10162_백자민 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int[] btn = new int[3];
		
		if(T >= 300) {
			btn[0] = T/300;
			T -= (T/300) * 300;
		}
		
		if(T>=60) {
			btn[1] = T/60;
			T -= (T/60) * 60;
		}
		
		if(T>=10) {
			btn[2] = T/10;
			T -= (T/10) * 10;
		}
		
		if(T!=0) {
			System.out.println(-1);
		}
		else {
			for(int b: btn) {
				System.out.print(b+" ");
			}
		}
	}
}
