package study.oct2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14267 {
	//  상사가 직속부하 칭찬하면 그 모든 부하가 칭찬을 받으니
	// 인접리스트 사용해서 상관이랑이어주고, 직원번호(h) , 칭찬(v)를 받았을때.
	//  직속부하 칭찬하면 그 모든 부하가 칭찬을 받으니, 1번 사장부터 밑으로 부하들 칭찬을 더해서 값을 넣어줌.
	
	
	//n번 전부 다돌면 시간초과
	static int n, m;
	static int[] ans;
	static LinkedList<Integer> adjList[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		adjList = new LinkedList[n + 1];
		for (int i = 1; i <= n; i++) {
			adjList[i] = new LinkedList<>();
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			int boss = Integer.parseInt(st.nextToken());
			if(boss==-1) continue;
			adjList[boss].add(i);
		}
		ans = new int[n+1];
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			ans[h] += v;
		}
		dfs(1, 0);
		for(int i =1;i<=n;i++) {
			System.out.print(ans[i]+" ");
		}
		
	}

	private static void dfs(int h, int v) {
		ans[h] += v;
		for(int next: adjList[h]) {
			dfs(next, ans[h]);
		}
	}
}
