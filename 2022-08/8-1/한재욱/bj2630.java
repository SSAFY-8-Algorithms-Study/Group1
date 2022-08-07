package Aug1;

import java.util.Scanner;

public class bj2630 {
	static int wcnt = 0;
	static int bcnt = 0;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		map = new int[n+1][n+1];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		divide(1,1, n);
		System.out.println(wcnt);
		System.out.println(bcnt);
		
	}
	public static void divide(int i, int j, int n) {
		if(n<0) {
			return;
		}
		if(allEquals(i, j, n)) {
			 if(map[i][j]==0)
				 wcnt++;
			 else
				 bcnt++;
			 return;
		}
		n = n/2;
		divide(i, j, n);
		divide(i, j+n, n);
		divide(i+n, j, n);
		divide(i+n, j+n, n);
	}
	public static boolean allEquals(int i, int j , int n) {
		int color = map[i][j];
		for(int ii =i;ii<i+n;ii++) {
			for(int jj=j;jj<j+n;jj++) {
				if(map[ii][jj]!=color)
					return false;
			}
		}
		return true;
	}
}
