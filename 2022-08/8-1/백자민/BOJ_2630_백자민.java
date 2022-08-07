package week8_1;

import java.util.Scanner;

public class BOJ_2630_백자민 {
	
	static int[][] map;
	static int[] cnt;
	
	static void cut(int mi, int mj, int n) {
		
		for(int i=mi;i<mi+n;i++) {
			for(int j=mj;j<mj+n;j++) {
				if(map[mi][mj] != map[i][j]) {
					//시계방향 순서 
					cut(mi,mj,n/2);
					cut(mi,mj+n/2,n/2);
					cut(n/2+mi,mj,n/2);
					cut(n/2+mi,n/2+mj,n/2);
					
					return;
				}
			}
		}
		
		cnt[map[mi][mj]]++;
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		map = new int[N][N];
		cnt = new int[2];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		cut(0,0,N);
		System.out.println(cnt[0]);
		System.out.println(cnt[1]);
	}
}
