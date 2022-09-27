package Sep4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2660 {
	//회장 뽑기
	/**
	 * 인접리스트 그래프 문제로 품.
	 * 
	 * bfs탐색으로 가장 먼곳에 있는 것의 값이 회장후보의 점수라고 생각하고 그 값을 우선순위 큐에 담음
	 * 우선순위 큐에 담고 그 값을 꺼내서 가장 큰 회장후보의 점수와 같은 것을 리스트에 담고
	 * 리스트의 사이즈(회장 후보의 수)와 최대 점수를 답으로 출력.
	 */
	static LinkedList<Integer> adj[];
	static boolean[] visited;
	static int n;
	static PriorityQueue<Point> p;
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		adj = new LinkedList[n + 1];
		sb = new StringBuilder();
		p = new PriorityQueue<>();
		for (int i = 1; i <= n; i++) {
			adj[i] = new LinkedList<>();
		}
		while (true) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			if (from == -1 && to == -1)
				break;
			adj[from].add(to);
			adj[to].add(from);
		} // input end
		for (int i = 1; i <= n; i++) {
			bfs(i);
		}
		int max = 0;
		LinkedList<Integer> list = new  LinkedList<>();
		for (int i = 0, size = p.size(); i < size; i++) {
			Point cur = p.poll();
			if(i==0) {
				max = cur.cnt;
				list.add(cur.loc);
			}
			else if(i!=0&&max==cur.cnt) {
				list.add(cur.loc);
			}
		}
		sb.append(max+" "+list.size()).append("\n");
		for(int i=0;i<list.size();i++)
		{
			sb.append(list.get(i)+" ");
		}
		System.out.println(sb);
	}

	private static void bfs(int i) {
		Queue<Integer> que = new ArrayDeque<>();
		visited = new boolean[n + 1];
		que.add(i);
		visited[i] = true;
		int cnt = -1;
		while (!que.isEmpty()) {
			cnt++;
			int size = que.size();
			while (--size >= 0) {
				int cur = que.poll();
				for (int next : adj[cur]) {
					if (!visited[next]) {
						que.add(next);
						visited[next] = true;
					}
				}
			}
		}
		p.add(new Point(i, cnt));
	}

	static class Point implements Comparable<Point> {
		public int loc, cnt;

		public Point(int loc, int cnt) {
			this.loc = loc;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Point o) {
			if (this.cnt == o.cnt) {
				return this.loc - o.loc;
			} else
				return this.cnt - o.cnt;
		}
	}
}
