package week8_3;

import java.util.Scanner;

public class BOJ_17608_백자민 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] bar = new int[N];
		
		for(int i=0;i<N;i++) {
			bar[i] = sc.nextInt();
		}
		
		int cnt = 1;
		int height = bar[N-1];
		for(int i=N-2;i>=0;i--) {
			if(bar[i]>height) {
				height = bar[i];
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
	
}
