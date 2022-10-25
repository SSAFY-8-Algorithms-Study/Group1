// 14267 회사 문화 1
// 그래프 문제이긴 하지만 완전 DP만 가지고도 풀 수 있는 문제
// 완전 DP보다는 그래프+DP가 접근이 쉬움
// 이 문제에는 조건이 하나 명시가 애매한데, 같은 상사를 다른 부하가 직속으로 가질 수 있다 라는 부분이 명시되어있지 않음
// 따라서 해당 부분을 잘 고려했어야함.
// 나에게 연결된 부하를 그래프 형식으로 저장하고, 칭찬 지수를 배열로 저장한다
// 시작 지점은 무조건 1번, 즉 사장이 1번에 위치한다.
// 1번부터 그래프를 탐색하면서 자신에게 연결된 부하에게 자신의 칭찬 지수를 더해주면 끝.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] graph = new ArrayList[N];
		int[] answer = new int[N];
		for (int i = 0; i < N; i++) {
			graph[i] = new ArrayList<>();
		}
		st = new StringTokenizer(br.readLine());
		// 직속 부하 그래프 연결
		for (int i = 0; i < N; i++) {
			int parent = Integer.parseInt(st.nextToken());
			if (parent == -1) {
				continue;
			}
			graph[parent-1].add(i);
		}
		// 칭찬 지수 저장
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int now = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken());
			answer[now] += weight;
		}
		// 사장부터 쭉 돌면서 자신의 직속 부하들에게 자신의 칭찬 값 더해주기, 이때 같은 배열에 값을 초기화 해주면서 DP적인 접근을 가져감
		for (int now = 0; now < N; now++) {
			for (int next : graph[now]) {
				answer[next] += answer[now];
			}
		}
		// 출력양이 많아질걸 예상하여 SB사용
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(answer[i]).append(" ");
		}
		System.out.println(sb);
		
	}
}