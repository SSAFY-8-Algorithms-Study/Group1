package week10_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * M번동안 문제에서 제시하는 순서대로 시뮬레이션을 돌린다. 
 * 1. 구름 이동 위치를 계산하여 구름의 위치를 갱신하고 바구니에 물을 채운다.
 * 2. 대각선 물바구니를 채워준다. 
 * 3. 바구니에 저장된 물의 양을 기준으로 구름을 새로 생성한다. 
 * 
 * */

public class BOJ_21610_백자민 {
	
	static int N,M;
	
	static int[][] map;
	static boolean[][] visit;
	
	static List<Point> cloud;
	
	static int[] di = {0,-1,-1,-1,0,1,1,1};
	static int[] dj = {-1,-1,0,1,1,1,0,-1};
	
	static void makeCloud() { //새로 구름 만들기+구름 리스트 초기화
		cloud = new ArrayList<>();
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]>=2 && !visit[i][j]) {
					map[i][j] -= 2;
					cloud.add(new Point(i,j));
				}
			}
		}
	}
	
	static void copyMagic() { //대각선 물바구니 체크
		for(Point c: cloud) {
			int cnt = 0;
			for(int d=1;d<8;d+=2) {
				int ni = c.i+di[d];
				int nj = c.j+dj[d];
				
				if(ni<0 || ni>=N || nj<0 || nj>=N) continue;
				
				if(map[ni][nj]>0) cnt++;
			}
			map[c.i][c.j] += cnt;
		}
	}
	
	static void move(int d, int s) { //구름 이동 + 바구니 채우기
		for(Point c: cloud) { 
			//구름 이동 위치 계산
			int ni = (c.i + N + di[d] * s%N) % N;
			int nj = (c.j + N + dj[d] * s%N) % N;
			
			visit[ni][nj] = true; //방문체크
			map[ni][nj]++; //바구니에 물넣기
			c.i = ni;
			c.j = nj;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		cloud = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cloud.add(new Point(N-1,0));
		cloud.add(new Point(N-1,1));
		cloud.add(new Point(N-2,0));
		cloud.add(new Point(N-2,1));
		
		for(int m=0;m<M;m++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken())-1;
			int s = Integer.parseInt(st.nextToken());
			
			visit = new boolean[N][N]; //방문배열 초기화
			move(d,s);
			copyMagic();
			makeCloud();
		}
		
		int ans = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				ans += map[i][j];
			}
		}
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
