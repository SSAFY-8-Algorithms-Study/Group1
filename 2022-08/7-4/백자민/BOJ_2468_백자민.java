import java.util.Scanner;

public class Main {
	
	public static int[][] map;
	public static boolean[][] visit;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	public static int N;
	
	public static void search(int h, int a, int b) {
		visit[a][b] = true;
		
		for(int i=0;i<4;i++) {
			int nx = a+dx[i];
			int ny = b+dy[i];
			
			if(nx<1 || ny<1 || nx>N || ny>N) continue;
			
			if(!visit[nx][ny] && map[nx][ny]>=h) {
				visit[nx][ny] = true;
				search(h, nx, ny);
			}
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N+1][N+1];
		int ans = 0;
		
		int maxheight = 0; // 건물 최고 높이 
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				map[i][j] = sc.nextInt();
				maxheight = Math.max(maxheight, map[i][j]);
			}
		}
		
		for(int h=1;h<=maxheight;h++) {
			int cnt = 0;
			visit = new boolean[N+1][N+1];
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					//방문한 적이 없고 비높이 이상이면 잠기지 않은 지역!
					if(!visit[i][j] && map[i][j] >= h) {
						cnt++;
						search(h,i,j);
					}
				}
			}
			ans = Math.max(ans, cnt);
			
		}
		System.out.println(ans);
		
		
	}
	
}
