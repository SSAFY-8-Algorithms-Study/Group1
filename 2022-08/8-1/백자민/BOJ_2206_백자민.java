package week8_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206_백자민 {
	
	//상,하,좌,우
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	
	static int[][] map, visit;
	
	static int N;
	static int M;
	
	static int go(int gi, int gj) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {gi,gj,1,0});
		visit[gi][gj] = 0; //아직 아무 벽도 부수지 않음 
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			//System.out.println(temp[0]+" "+temp[1]+" "+temp[2]+" "+temp[3]);
			
			//도착지점 
			if(temp[0]==N-1&& temp[1]==M-1)
				return temp[2];
			
			for(int i=0;i<4;i++) {
				int ni = temp[0]+di[i];
				int nj = temp[1]+dj[i];
				
				if(ni>=0 && nj>=0 && ni<N && nj<M) { 
				
					
					if(visit[ni][nj] <= temp[3]) continue;
					
					//벽이 아닌 경우
					if (map[ni][nj]==0){
						visit[ni][nj] = temp[3];
						q.offer(new int[] {ni, nj, temp[2]+1, temp[3]});
					}
					
					//벽인데 아직 벽을 한 번도 뚫지 않은 경우(뚫고 지나감)
					else {
						if(temp[3]==0) {
							visit[ni][nj] = temp[3]+1;
							q.offer(new int[] {ni, nj,temp[2]+1,temp[3]+1});
						}
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
		visit = new int[N][M];
		
		for(int i=0;i<N;i++) {
			s = br.readLine().split("");
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(s[j]);
				visit[i][j] = Integer.MAX_VALUE;
			}
		}
		
		System.out.println(go(0,0));
	}
}
