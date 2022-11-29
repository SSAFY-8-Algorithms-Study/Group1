package boj1956;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
/*
 * bfs를 돌려서 시작 마을까지 올 수 있는지 확인했다.
 * 도로 길이의 합이 가장 작은 사이클을 찾는 것이기 때문에 현재 가장 작은 도로 길이의 합보다 크다면 바로 버렸다.
 * */
public class Main {
	static int V, E, result;
	static ArrayList<ArrayList<Tuple>> adj;
	static class Tuple{
		int v, dist;
		public Tuple(int v, int dist) {
			super();
			this.v = v;
			this.dist = dist;
		}
		
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inArr = br.readLine().split(" ");
		V = Integer.parseInt(inArr[0]);
		E = Integer.parseInt(inArr[1]);
		adj = new ArrayList<ArrayList<Tuple>>();
		for(int i = 0; i < V+1; i++) {
			adj.add(new ArrayList<Tuple>());
		}
		
		for(int i = 0; i < E; i++) {
			inArr = br.readLine().split(" ");
			int a = Integer.parseInt(inArr[0]);
			int b = Integer.parseInt(inArr[1]);
			int c = Integer.parseInt(inArr[2]);
			
			adj.get(a).add(new Tuple(b, c));
		}
		result = Integer.MAX_VALUE;
		for(int i = 1; i < V+1; i++) {
			bfs(i);
		}
		if(result == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(result);
		}
	}
	
	static void bfs(int start) {
		boolean[] visit = new boolean[V+1];
		visit[start] = true;
		Queue<Tuple> Q = new ArrayDeque<>();
		Q.add(new Tuple(start, 0));
		while(!Q.isEmpty()) {
			Tuple tp = Q.poll();
			ArrayList<Tuple> list = adj.get(tp.v);
			for(int i = 0; i < list.size(); i++) {
				Tuple t = list.get(i);
				if(t.v == start) {
					result = Math.min(result, tp.dist + t.dist);
				}
				if(visit[t.v]) continue;
				int temp = tp.dist + t.dist;
				if(temp > result) continue;
				visit[t.v] = true;
				Q.add(new Tuple(t.v, temp));
			}
		}
	}

}
