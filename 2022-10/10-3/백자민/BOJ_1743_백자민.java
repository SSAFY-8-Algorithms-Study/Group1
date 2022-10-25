package week10_3;

/*
 * 쓰레기의 위치를 받아 2차원 배열(map)에 저장해두고, 전체적으로 배열의 요소를 탐색하면서 쓰레기가 있다면 주위 4방향의 쓰레기의 양을 조사한다. 
 * 배열을 탐색하며 최댓값을 갱신해나간다.
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1743_백자민 {
	
	static int N,M,K,max;
	
	static int[][] map;
	
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	
	static int bfs(int i, int j) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(i,j));
		map[i][j] = 0;
		int cnt = 1;
		while(!q.isEmpty()) {
			Point temp = q.poll();
			
			for(int d=0;d<4;d++) {
				int ni = temp.i+di[d];
				int nj = temp.j+dj[d];
				
				if(ni<0 || ni>=N || nj<0 || nj>=M) continue;
				if(map[ni][nj]==0) continue;
				
				q.add(new Point(ni,nj));
				map[ni][nj] = 0;
				cnt++;
			}
		}
		
		return cnt;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int k=0;k<K;k++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken())-1;
			int j = Integer.parseInt(st.nextToken())-1;
			
			map[i][j]++;
		}
		
		max = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]>0) {
					int temp = bfs(i,j);
					max = max<temp?temp:max;
				}
			}
		}
		
		System.out.println(max);
	}
	
	static class Point {
		int i,j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
		
	}
}
