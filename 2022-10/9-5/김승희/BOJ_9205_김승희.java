package boj9205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
/*
 * 처음에 맥주는 20병을 가질 수 있다.
 * 상근이 집, 편의점, 락 페스티벌 좌표들로 그래프를 그리는데, 거리가 1000m 이하여야 연결되어 있다고 본다.
 * 그려진 그래프(map)를 가지고 BFS를 돌려 락 페스티벌에 도착하는지 확인한다.
 * */
public class Main {
	static class Tuple {
		int i, j, idx;

		public Tuple(int i, int j, int idx) {
			this.i = i;
			this.j = j;
			this.idx = idx;
		}
	}

	static int n;
	static Tuple party;
	static Tuple[] tuples; // 0은 집, 1-n까지는 편의점
	static ArrayList<Integer>[] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < TC; t++) {
			n = Integer.parseInt(br.readLine());
			tuples = new Tuple[n + 1];
			for (int i = 0; i < n + 1; i++) {
				String[] inArr = br.readLine().split(" ");
				tuples[i] = new Tuple(Integer.parseInt(inArr[0]), Integer.parseInt(inArr[1]), i);
			}
			String[] inArr = br.readLine().split(" ");
			party = new Tuple(Integer.parseInt(inArr[0]), Integer.parseInt(inArr[1]), -1);
			// end input
			map = new ArrayList[n + 1];
			for (int i = 0; i < n + 1; i++) {
				map[i] = new ArrayList<Integer>();
				for (int j = 1; j < n + 1; j++) {
					if (i == j)
						continue;
					int temp = distance(tuples[i].i, tuples[j].i) + distance(tuples[i].j, tuples[j].j);
					if (temp <= 1000) {
						map[i].add(tuples[j].idx);
					}
				}
				int temp = distance(tuples[i].i, party.i) + distance(tuples[i].j, party.j);
				if (temp <= 1000) {
					map[i].add(party.idx);
				}
			} // end map
			if (BFS()) {
				sb.append("happy\n");
			} else {
				sb.append("sad\n");
			}
		}
		System.out.println(sb.toString());
	}

	public static boolean BFS() {
		boolean[] visit = new boolean[n + 1];
		visit[0] = true;
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(0);
		while (!queue.isEmpty()) {
			int pop = queue.poll();
			for (int i = 0; i < map[pop].size(); i++) {
				if (map[pop].get(i) == -1)
					return true;
				if (visit[map[pop].get(i)])
					continue;

				queue.add(map[pop].get(i));
				visit[map[pop].get(i)] = true;
			}
		}
		return false;
	}

	public static boolean DFS(int idx, boolean[] visit) {
		visit[idx] = true;
		for (int i = 0; i < map[idx].size(); i++) {
			if (map[idx].get(i) == -1)
				return true;
			if (visit[map[idx].get(i)])
				continue;
			return DFS(map[idx].get(i), Arrays.copyOf(visit, n + 1));
		}
		return false;
	}

	public static int distance(int a, int b) {
		int dist = 0;
		if (a >= 0 && b >= 0) { // 둘 다 양수거나 0일 경우
			dist += Math.abs(a - b);
		} else if (a < 0 && b < 0) { // 둘다 음수일 겨웅
			dist += Math.abs(a - b);
		} else { // 둘이 부호가 다를 경우
			dist += Math.abs(a) + Math.abs(b);
		}
		return dist;
	}

}
