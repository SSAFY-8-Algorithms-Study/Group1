package week10_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5427_백자민 {
	
	static int W,H,ans;
	
	static char[][] map;
	
	static Queue<Point> fire;
	
	
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	
	static void bfs(Point sg) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(sg.i, sg.j,0));
				
		int size = 0;
		while(!q.isEmpty()) {
			//불 번짐
			size = fire.size();
			for(int i=0;i<size;i++) {
				Point temp = fire.poll();
				for(int d=0;d<4;d++) {
					int ni = temp.i+di[d];
					int nj = temp.j+dj[d];
					
					if(ni<0 || ni>=H || nj<0 || nj>=W) continue;
					
					if(map[ni][nj]=='.' || map[ni][nj]=='@') {
						map[ni][nj] = '*';
						fire.add(new Point(ni,nj,-1));
					}
				}
			}
			//상근 이동
			size = q.size();
			for(int i=0;i<size;i++) {
				Point temp = q.poll();
				for(int d=0;d<4;d++) {
					int ni = temp.i+di[d];
					int nj = temp.j+dj[d];
					
					if(ni<0 || ni>=H || nj<0 || nj>=W) { //범위 밖이면 탈출 성공
						ans = temp.cnt+1;
						return;
					}
					
					if(map[ni][nj]=='.') {
						map[ni][nj] = '@';
						q.add(new Point(ni,nj,temp.cnt+1));
					}
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			map = new char[H][];
			fire = new LinkedList<>();
			Point sg = null;
			for (int i=0;i<H;i++) {
				map[i] = br.readLine().toCharArray();
				for (int j=0;j<W;j++) {
					if (map[i][j]=='@') 
						sg = new Point(i,j,0);
					else if (map[i][j] == '*') 
						fire.add(new Point(i,j,-1));
				}
			}
			ans = 0;
			bfs(sg);
			System.out.println(ans==0?"IMPOSSIBLE":ans);
		}
	}
	
	static class Point {
		int i,j,cnt;

		public Point(int i, int j, int cnt) {
			this.i = i;
			this.j = j;
			this.cnt = cnt;
		}
	}
}
