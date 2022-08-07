package week8_1;

import java.util.Scanner;

public class BOJ_2563_백자민 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[][] paper = new int[100][100];
		//사각형 개수만큼 넓이 계산
		int ans = 0;
		
		while(N>0) {
			int x = sc.nextInt();
			int y = 100 - sc.nextInt()-1;
			
			//색종이가 위치한 곳 좌표의 수 증가
			for(int i=y;i>y-10;i--) {
				for(int j=x;j<x+10;j++) {
					paper[i][j]++;
				}
			}
			N--;
		}
		
		//값이 1보다 크면 겹친 부분
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(paper[i][j]!=0) ans++;
				//System.out.print(paper[i][j]+" ");
			}
			//System.out.println();
		}
		
		System.out.println(ans);
	}
}
