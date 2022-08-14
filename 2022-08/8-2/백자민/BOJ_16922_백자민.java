package week8_2;

import java.util.Scanner;

public class BOJ_16922_백자민 {
	
	static int N, ans;
	static int[] rom, num;
	static boolean[] visit;
	
	static void plus(int idx, int sum, int n) {
		if(n==0) {
			if(visit[sum]==false) {
				ans++;
				visit[sum] = true;
			}
			return;
		}
		
		for(int i=idx;i<4;i++) {
			plus(i, sum+rom[i], n-1);
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		rom = new int[] {1,5,10,50};
		visit = new boolean[1001];
		ans = 0;
		plus(0,0,N);
		System.out.println(ans);
		
	}
}
