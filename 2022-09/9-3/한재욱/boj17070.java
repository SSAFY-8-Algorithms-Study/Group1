package Sep3;

import java.util.Scanner;

public class boj17070 {
	//17070 boj.파이프 옮기기 1
	//di, dj 2차원 배열로 가로, 세로 , 대각선마다 갈 수 있는 경로를 만들고
	//1~n까지 맵 입력을 받고 dfs탐색. 사방 탐색 가능 하다면가고
	// i==1인경우 대각선으로 가는 경우인데 그런경우 (i+1,j) (i,j+1)도 갈 수 있는지 탐색.
	// (n,n)도착시 경우의 수를 추가 해주고, 정답 출력
	static int[][] di = {{0,1},{1,1},{0,1,1}};
	static int[][] dj = {{1,1},{0,1},{1,1,0}};
	static int[][] direc = {{0,2},{1,2},{0,2,1}};
	static int[][] map;
	static int dir, cnt, n;
	static Point start;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n+1][n+1];
		for(int i=1;i<=n;i++) {
			for (int j = 1; j <=n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		dir = 0;
		cnt = 0;
		start = new Point(1, 2);
		dfs(start, dir);
		System.out.println(cnt);
	}
	private static void dfs(Point s, int d) {
//		System.out.println(s.i+" "+s.j+" "+d); // 0:가로 1:세로 2: 대각선
		if(s.i==n&&s.j==n) {
			cnt++;
			return;
		}
		for(int i=0;i<di[d].length;i++) {
			int ni = s.i+di[d][i];
			int nj = s.j+dj[d][i];
//			System.out.println("갈수 있는 곳 "+ni+" "+nj);
			if(1<=ni&&ni<=n&&1<=nj&&nj<=n&&map[ni][nj]!=1) {
				if(i==1) {
					if(s.i+1<=n&&map[s.i+1][s.j]==0&&s.j+1<=n&&map[s.i][s.j+1]==0) {
						dfs(new Point(ni, nj), direc[d][i]);		
					}
				}else {
					dfs(new Point(ni, nj), direc[d][i]);					
				}
			}
		}
	}
	static class Point{
		int i,j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}
