package week8_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178_백자민 {
	
	static int N, M;
	static int[][] map;
	static boolean[][] visit;
	
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	
	static int go(int i, int j, int cnt) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {i, j, cnt});
		
		visit[i][j] = true;
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			
			if(temp[0]==N-1 && temp[1]==M-1)
				return temp[2];
			for(int d=0;d<4;d++) {
				int ni = temp[0]+di[d];
				int nj = temp[1]+dj[d];
				
				if(ni>=0 && nj>=0 && ni<N && nj<M) {
					
					if(map[ni][nj]==1 && visit[ni][nj]==false) {
						visit[ni][nj] = true;
						q.offer(new int[] {ni, nj, temp[2]+1});
					}
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);	
		
		map = new int[N][M];
		visit = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			s = br.readLine().split("");
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		System.out.println(go(0,0,1));
	}
}
