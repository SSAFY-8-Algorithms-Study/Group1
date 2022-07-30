import java.util.Scanner;

public class Main {
	
	static int N;
	static int M;
	static int[][] map;
	
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	
	public static void melt() {
		int cnt = 0;
		boolean[][] visit = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j] != 0) visit[i][j] = true;
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				int around = 0;
				for(int k=0;k<4;k++) {
					int nx = dx[k]+i;
					int ny = dy[k]+j;
					if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
					
					if(map[nx][ny]==0 && !visit[nx][ny]) around++;
				}
				map[i][j] -= around;
				if(map[i][j]<=0) map[i][j] = 0;
			}
		}
	}
	
	public static int cntIce() {
		boolean[][] visit = new boolean[N][M];
		
		int cnt = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]!=0 && !visit[i][j]) {
					search(i,j,visit);
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	public static void search(int x, int y, boolean[][] visit) {
		visit[x][y] = true;
		
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
			
			if(map[nx][ny]!=0 && !visit[nx][ny]) search(nx,ny,visit);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N][M];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		int year = 0;
		int ice = 0;
		
		while((ice = cntIce()) < 2) {
			if (ice == 0) {
				year = 0;
				break;
			}
			melt();
			year++;
		}
		
		System.out.println(year);
	}
	
}
