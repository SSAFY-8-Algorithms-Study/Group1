package boj1504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
/*
 * 다익스트라 알고리즘으로 풀이
 * a와 b가 반드시 거쳐야 하는 정점.
 * s2 : 출발노드가 1인 최단경로
 * a2 : 출발노드가 a인 최단 경로
 * b2 : 출발노드가 b인 최단 경로
 * 1->a->b->N 경로의 거리와 1->b->a->N 경로의 거리를 비교한다.
 * 이때, 경로가 없을 경우도 있기 때문에 이를 고려해줘야 한다.
 * */
public class Main {
	static class Point implements Comparable<Point>{
		int v, dist;

		public Point(int b, int dist) {
			super();
			this.v = b;
			this.dist = dist;
		}

		@Override
		public int compareTo(Point o) {
			return this.dist - o.dist;
		}

	}

	static int N;
	static ArrayList<Point>[] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inArr = br.readLine().split(" ");
		N = Integer.parseInt(inArr[0]);
		int M = Integer.parseInt(inArr[1]);

		map = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			map[i] = new ArrayList<Point>();
		}
		for (int i = 0; i < M; i++) {
			inArr = br.readLine().split(" ");
			int a = Integer.parseInt(inArr[0]);
			int b = Integer.parseInt(inArr[1]);
			int c = Integer.parseInt(inArr[2]);
			map[a].add(new Point(b, c));
			map[b].add(new Point(a, c));
		}
		inArr = br.readLine().split(" ");
		int a = Integer.parseInt(inArr[0]);
		int b = Integer.parseInt(inArr[1]);

		int[] s2 = dijkstra(1);
		int[] a2 = dijkstra(a);
		int[] b2 = dijkstra(b);
//		System.out.println(Arrays.toString(s2));
//		System.out.println(Arrays.toString(e2));
		
		int answer = Integer.MAX_VALUE;
		if(s2[a] != Integer.MAX_VALUE &&  a2[b]  != Integer.MAX_VALUE && b2[N] != Integer.MAX_VALUE) {
			answer = Math.min(answer, s2[a] + a2[b] + b2[N]);
		}
		if(s2[a] != Integer.MAX_VALUE &&  a2[b]  != Integer.MAX_VALUE && b2[N] != Integer.MAX_VALUE) {
			answer = Math.min(answer, s2[b] + b2[a] + a2[N]);
		}
		
		if(answer == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(answer);
		}

	}

	public static int[] dijkstra(int start) {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.add(new Point(start, 0));
		int[] dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		while (!pq.isEmpty()) {
			Point tp = pq.poll();
			if (dist[tp.v] < tp.dist) {
				continue;
			}
			for (int i = 0; i < map[tp.v].size(); i++) {
				int ndist = dist[tp.v] + map[tp.v].get(i).dist;
				if (dist[map[tp.v].get(i).v] > ndist) {
					dist[map[tp.v].get(i).v] = ndist;
					pq.add(new Point(map[tp.v].get(i).v, ndist));
				}
			}
		}
		return dist;
	}

}
