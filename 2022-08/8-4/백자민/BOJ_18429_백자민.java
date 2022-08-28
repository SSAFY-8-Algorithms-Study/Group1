package week8_4;

import java.util.Scanner;

public class BOJ_18429_백자민 {
	
	static int N, K, ans;
	static int[] A, work;
	static boolean[] select;
	
	static boolean health(int[] kit) {
		int w = 500;
		for(int k: kit) {
			w = w+k-K;
			if(w<500)
				return false;
		}
		return true;
	}
	
	static void perm(int cnt) {
		if(cnt == N) {
			if(health(work)) {
				ans++;
			}
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(select[i]) continue;
			
			select[i] = true;
			work[cnt] = A[i];
			perm(cnt+1);
			select[i] = false;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		A = new int[N];
		work = new int[N];
		select = new boolean[N];
		
		for(int a=0;a<N;a++) {
			A[a] = sc.nextInt();
		}
		
		ans = 0;
		perm(0);
		System.out.println(ans);
	}
}
