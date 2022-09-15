package week9_2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_22116_백자민 {
	
	static int N, ans;
	static int[][] map;
	
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	
	static void getSlope(int l, int r){
		while(l<=r) {
			int mdd = (l+r)/2;
			
			if(isValid(mdd)) 
				r = mdd-1;
			else {
				l = mdd+1;
				ans = l;
			}
		}
	}
	
	static boolean isValid(int slope) { //해당 경사값으로 도착할 수 있는지 검사
		boolean[][] visit = new boolean[N][N];
		Queue<Point> q = new LinkedList<>();
		
		visit[0][0] = true;
		q.offer(new Point(0,0));
		
		while(!q.isEmpty()) {
			Point temp = q.poll();
			
			if(temp.i==N-1 && temp.j==N-1) return true;
			
			for(int d=0;d<4;d++) {
				int ni = temp.i+di[d];
				int nj = temp.j+dj[d];
								
				if(ni<0 || nj<0 || ni>=N || nj>=N) continue;
				
				if(visit[ni][nj] || Math.abs(map[ni][nj]-map[temp.i][temp.j])>slope) continue;
				
				visit[ni][nj] = true;
				q.offer(new Point(ni,nj));
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new int[N][N];
		
		int maxV=0, minV=Integer.MAX_VALUE;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j] = sc.nextInt();
				maxV = Math.max(map[i][j], maxV);
				minV = Math.min(map[i][j], minV);
			}
		}
		ans = 0;
		 //탐색
		getSlope(0,maxV-minV);
		System.out.println(ans);
	}
	
	static class Point {
		int i,j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}
