package week8_3;

import java.util.Scanner;

public class BOJ_2960_백자민 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		boolean[] nums = new boolean[N+1];
		
		for(int i=2;i<=N;i++) {
			for(int j=i;j<=N;j+=i) {
				if(nums[j]==true) continue;
				 
				nums[j] = true;
				K--;
				
				if(K==0) {
					System.out.println(j);
					System.exit(0);
				}
			}
		}
		
	}
}
