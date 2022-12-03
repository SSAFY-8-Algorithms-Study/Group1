package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public class Main{
	static int N;
	static int leaf;
	static ArrayList<Integer>[] graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			graph[from].add(to);
			graph[to].add(from);
		}
		leaf = 0;
		bfs();
		System.out.println((double)W/leaf);
	}
	public static void bfs() {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		boolean[] check = new boolean[N+1];
		check[1] = true;
		q.add(1);
		while (!q.isEmpty()) {
			int temp = q.poll();
			int childCnt = 0;
			for (int next : graph[temp]) {
				if (!check[next]) {
					q.add(next);
					childCnt++;
					check[next] = true;
				}
			}
			if (childCnt == 0) {
				leaf++;
			}
		}
		
	}
}