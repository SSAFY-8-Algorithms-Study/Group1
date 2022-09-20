package week9_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 인접리스트에 신뢰관계 저장, dfs로 탐색하면서 컴퓨터 배열에 해킹 가능한 횟수 증가
 * 
 * */

public class BOJ_1325_백자민 {
	
	static ArrayList<Integer>[] adjList;
	static int[] com; //해킹할 수 있는 컴퓨터 개수를 셀 배열
	
	static void dfs(int cur, boolean[] visit) {
		visit[cur] = true; //현재 컴퓨터 해킹
		
		for(int next: adjList[cur]) {
			if(!visit[next]) {
				com[next]++;
				dfs(next,visit);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList[N+1]; //computer 번호 1부터 시작
		com = new int[N+1];
		
		for(int n=1;n<=N;n++) {
			adjList[n] = new ArrayList<>();
		}
		
		for(int m=0;m<M;m++) { //입력받기
			st = new StringTokenizer(br.readLine());
			adjList[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
		}
		
		for(int n=1;n<=N;n++) {
			boolean[] visit = new boolean[N+1];
			dfs(n, visit); 
		}
		
		int max = 0;
		for(int c: com) {
			max = Math.max(c, max);
		}
		
		for(int i=1;i<=N;i++) {
			if(com[i]==max)
				sb.append(i+" ");
		}
		
		System.out.println(sb);
	}
}
