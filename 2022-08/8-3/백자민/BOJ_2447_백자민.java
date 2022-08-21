package week8_3;

import java.util.Scanner;

public class BOJ_2447_백자민 {
	
	static char[][] map;
	
	static void star(int si, int sj, int n, boolean isStar) {
		if(!isStar) {
			for(int i=si;i<si+n;i++) {
				for(int j=sj;j<sj+n;j++) {
					map[i][j] = ' ';
				}
			}
			return;
		}
		
		if(n==1) {
			map[si][sj] = '*';
			return;
		}
		
		for(int i=si;i<si+n;i+=n/3) {
			for(int j=sj;j<sj+n;j+=n/3) {
				//빈칸 구역
				if(i==n/3+si && j==n/3+sj) {
					star(i, j, n/3, false);
					continue;
				}
				else
					star(i, j, n/3, true);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		map = new char[N][N];
		star(0,0,N,true);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				sb.append(map[i][j]);
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}
