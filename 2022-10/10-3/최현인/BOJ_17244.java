// 17244 아맞다우산
// 시작지점과 모든 물건들에서 다른 지점으로 가는 거리를 전부 구함
// 물건을 줍는 순서를 순열로 구함
// 순열로 만들어진 순서대로 거리를 구해보고 가장 작은 거리를 구함
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, M, countStuff, answer;
	//bfs를 위한 변수들
	static int[][] map;
	static boolean[][] check;
	static int[][] distance;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static class coord{
		int i, j, w;
		public coord(int i, int j, int w) {
			this.i = i;
			this.j = j;
			this.w = w;
		}
	}
	//순열을 구하기 위한 변수들
	static int[] result;
	static boolean[] select;
	
	// 시작 지점은 0, 끝 지점은 8, 벽은 -1, 빈 공간은 9
	static final int WALL = -1, BLANK = 9, END = 8, START = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력 받기 위한 버퍼리더
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); 
		N = Integer.parseInt(st.nextToken());
		countStuff = 0;
		map = new int[N][M];
		coord s, e = new coord(0,0,0);
		ArrayList<coord> clist = new ArrayList<>(); //시작점, 물건의 위치를 저장할 배열
		clist.add(new coord(0,0,1));
		for (int i = 0; i < N; i++) {
			char[] c = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				// 시작 지점은 0, 끝 지점은 8, 벽은 -1, 빈 공간은 9, 물건은 입력받는 순서대로 1번부터 개수만큼
				if (c[j] == 'S') {
					map[i][j] = START;
					clist.set(0, new coord(i, j, 0));
				}
				else if (c[j] == 'E') {
					map[i][j] = END;
					e = new coord(i, j, 0);
				}
				else if (c[j] == '#') {
					map[i][j] = -1;
				}
				else if (c[j] == '.') {
					map[i][j] = 9;
				}
				else {
					clist.add(new coord(i,j,0));
					map[i][j] = ++countStuff;
				}
			}
		}
		distance = new int[countStuff+1][countStuff+2]; //시작 지점+물건으로 부터 모든 지점으로 가는 거리를 구하기 위함
		
		for (int i = 0; i <= countStuff; i++) {
			distance[i][i] = 0; //자기 자신으로 가는 거리는 0
			bfs(clist.get(i), i); //각 지점으로 가는 거리를 구해보자
		}
		
		if (countStuff != 0) { //물건의 개수가 0개가 아닐때
			answer = Integer.MAX_VALUE;
			select = new boolean[countStuff+1];
			result = new int[countStuff];
			perm(0);
			System.out.println(answer);
		}
		else { //개수가 0개일 때, 시작점에서 끝점까지의 거리를 출력
			System.out.println(distance[0][1]);
		}
		
	}
	public static void bfs(coord c, int n) {
		ArrayDeque<coord> q = new ArrayDeque<>();
		check = new boolean[N][M];
		check[c.i][c.j] = true;
		q.add(c);
		while (!q.isEmpty()) {
			coord temp = q.poll();
			for (int i = 0; i < 4; i++) {
				int ni = temp.i + di[i];
				int nj = temp.j + dj[i];
				if (ni < 0 || nj < 0 || ni >= N || nj >= M || map[ni][nj] == WALL || check[ni][nj]) {
					continue;
				}
				if (map[ni][nj] != BLANK) {
					if (map[ni][nj] == END) {
						distance[n][countStuff+1] = temp.w+1;
					}
					else {
						distance[n][map[ni][nj]] = temp.w+1;
					}
				}
				check[ni][nj] = true;
				q.add(new coord(ni,nj,temp.w+1));
			}
		}
	}
	public static void perm(int idx) {
		if (idx == countStuff) {
			int temp = 0;
			temp += distance[0][result[0]];
			for (int i = 0; i < countStuff-1; i++) {
				temp += distance[result[i]][result[i+1]];
			}
			temp += distance[result[countStuff-1]][countStuff+1];
			answer = Integer.min(answer, temp);
			return;
		}
		for (int i = 1; i <= countStuff; i++) {
			if (!select[i]) {
				result[idx] = i;
				select[i] = true;
				perm(idx+1);
				select[i] = false;
			}
		}
	}
}
