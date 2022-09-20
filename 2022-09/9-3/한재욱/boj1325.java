package Sep3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1325 {
	static LinkedList<Integer> adj[];
	static int n, m;
	static boolean visited[];
	static int[] ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		ans = new int[n+1];
		adj = new LinkedList[n + 1];
		for (int i = 1; i <= n; i++) {
			adj[i] = new LinkedList<>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adj[from].add(to);
		}
		for (int i = 1; i <= n; i++) {
			visited = new boolean[n + 1];
			visited[i] = true;
			bfs(i);
		}
		int max = Integer.MIN_VALUE;
		for(int i=1;i<=n;i++) {
			max = Math.max(max, ans[i]);
		}
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=n;i++) {
			if(max==ans[i]) {
				sb.append(i).append(" ");
			}
		}
		System.out.println(sb);
	}

	private static void bfs(int s) {
		Queue<Integer> que = new ArrayDeque<>();
		que.add(s);
		while(!que.isEmpty()) {
			int cur = que.poll();
			for(int temp : adj[cur]) {
				if(!visited[temp]) {
					visited[temp] = true;
					que.add(temp);
					ans[temp]++;
				}				
			}
		}
	}

}
