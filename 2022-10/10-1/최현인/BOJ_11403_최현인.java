// 11403 경로찾기
// 1 부터 N까지 방문한 모든 경로를 answer 배열에 기록해준다
// 모든 경로 방문을 위해 DFS를 사용하였고, 중복 방문을 방지하기 위해 check 배열을 사용하였다

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
	static int[][] graph;
	static int[][] answer;
	static boolean[][] check;
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		
		N = Integer.parseInt(br.readLine());
		
		graph = new int[N][N];
		answer = new int[N][N];
		check = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String[] temp = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		for (int i = 0; i < N; i++) {
			dfs(i, i, 0);
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(answer[i][j] + " ");				
			}
			System.out.println();
		}
		
	}
	public static void dfs(int i, int j, int count) {
		if (count == N) {
			return;
		}
		for (int k = 0; k < N; k++) {
			if (graph[j][k] == 1 && answer[i][k] == 0) {
				answer[i][k] = 1;
				dfs(i, k, count+1);
			}
		}
	}
}