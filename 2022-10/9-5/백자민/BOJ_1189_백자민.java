package week9_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * dfs로 map을 탐색하며 출발지점에서 도착지점까지 거리가 K일 경우만 카운트한다. 
 * 탐색 경로가 K 이상인 경우는 더 이상 살펴볼 필요가 없으므로 제외한다(가지치기). 
 * */

public class BOJ_1189_백자민 {
	
	static int R,C,K,ans;
	static char[][] map;
	static boolean[][] visit;
	
	static int[] di = {0,0,1,-1};
	static int[] dj = {-1,1,0,0};
	
	static void dfs(int i, int j, int cnt) {
		if(i==0 && j==C-1) {
			if(cnt==K)
				ans++;
			return;
		}
		
		if(cnt>K) {
			return;
		}
		
		for(int d=0;d<4;d++) {
			int ni = i+di[d];
			int nj = j+dj[d];
			
			if(ni<0 || nj<0 || ni>=R || nj>=C) continue;
			
			if(visit[ni][nj]) continue;
			
			if(map[ni][nj]=='T') continue;
			
			visit[ni][nj] = true;
			dfs(ni,nj,cnt+1);
			visit[ni][nj] = false;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visit = new boolean[R][C];
		
		for(int i=0;i<R;i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		visit[R-1][0] = true;
		dfs(R-1,0,1);
		System.out.println(ans);
	}
}
