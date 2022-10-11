package week10_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * bfs를 이용하여 map에서 울타리로 둘러쌓여 있는 부분을 탐색하면서 양과 늑대의 개수를 카운팅한다. 
 * 이후 양과 늑대 중 살아남는쪽의 전체 카운트를 갱신해주고, 탐색한 부분을 방문처리 해준다. 
 * 양과 늑대 모두 대각선 이동이 불가능하므로 상,하,좌,우 네 방향만 탐색을 진행한다. 
 * */

public class BOJ_3187_백자민 {
	
	static int R,C,vcnt, kcnt;
	static char[][] map;
	
	static int[] di = {0,0,-1,1};
	static int[] dj = {-1,1,0,0};
	
	static void count(int i, int j) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(i,j));
		
		int tempv=0, tempk=0;
		
		while(!q.isEmpty()) {
			Point temp = q.poll();
			if(map[temp.i][temp.j]=='v') tempv++;
			if(map[temp.i][temp.j]=='k') tempk++;
			
			map[temp.i][temp.j] = '#';
			
			for(int d=0;d<4;d++) {
				int ni = temp.i+di[d];
				int nj = temp.j+dj[d];
				
				if(ni<0 || nj<0 || ni>=R || nj>=C) continue;
				if(map[ni][nj]=='#') continue;
				
				if(map[ni][nj]=='v') tempv++;
				if(map[ni][nj]=='k') tempk++;
				
				map[ni][nj]='#';
				q.offer(new Point(ni,nj));
			}
		}
		if(tempv<tempk) kcnt+=tempk;
		else vcnt+=tempv;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][];
		for(int i=0;i<R;i++)
			map[i] = br.readLine().toCharArray();
		
		vcnt=0;
		kcnt=0;
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j]!='#')
					count(i,j);
			}
		}
		System.out.println(kcnt+" "+vcnt);
	}
	
	static class Point {
		int i,j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}
