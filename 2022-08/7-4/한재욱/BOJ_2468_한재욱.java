import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	
	public static int[][] spread(int y, int x, int h, int[][]map, int[][]visited){
		for(int i=0; i<4; i++) {
			int ny = y + dy[i];
			int nx = x+ dx[i];
			if(0<=nx && nx<map.length && 0<=ny && ny<map.length && visited[ny][nx]==0&& map[ny][nx]>h) {
				visited[ny][nx] = 1;
				visited = spread(ny, nx, h, map, visited);
			}
		}
		return visited;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int map[][] = new int[n][n];
		int visited[][];
		
		for (int i = 0; i < map.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < map.length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int max = 1;
		for(int i=1;i<101;i++) {
			int cnt = 0;
			visited = new int[n][n];
			for (int j = 0; j < visited.length; j++) {
				for (int k = 0; k < visited.length; k++) {
					if(visited[j][k]==0 && map[j][k]>i) {
						visited[j][k] = 1;
						cnt++;
						visited = spread(j, k, i, map, visited);
					}
				}
			}
			max = Math.max(cnt, max);
		}
		System.out.println(max);
	}
}