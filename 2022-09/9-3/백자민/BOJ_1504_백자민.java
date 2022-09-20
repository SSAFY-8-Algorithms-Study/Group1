package week9_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1504_백자민 {
	
	static int N, E;
	static ArrayList<Point>[] adjList;
	static boolean[] visit;
	static int dist[];
	static final int maxVal = 200000000;
	
	static int go(int start, int end) {
		Arrays.fill(dist, maxVal);
		visit = new boolean[N+1];
		PriorityQueue<Point> q = new PriorityQueue<>();
		
		q.offer(new Point(start, 0));
		dist[start] = 0;
		
		while(!q.isEmpty()) {
			Point temp = q.poll();
			int next = temp.next;
			
			if(visit[next]) continue;
			
			visit[next] = true;
			
			for(Point p: adjList[next]) {
				if(!visit[p.next] && dist[p.next] > dist[next]+p.weight) {
					dist[p.next] = dist[next] + p.weight;
					q.add(new Point(p.next, dist[p.next]));
				}
			}
		}
		
		return dist[end];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList[N+1]; //1부터 시작
		dist = new int[N+1];
		
		for(int n=1;n<=N;n++) {
			adjList[n] = new ArrayList<>();
		}
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			//양방향
			adjList[s].add(new Point(e,w));
			adjList[e].add(new Point(s,w));
		}
		
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		//v1먼저가기
		int ansv1 = go(1,v1);
		ansv1 += go(v1,v2);
		ansv1 += go(v2,N);
		
		//v2먼저가기
		int ansv2 = go(1,v2);
		ansv2 += go(v2,v1);
		ansv2 += go(v1,N);
		
		if(ansv1>=maxVal && ansv2>=maxVal)
			System.out.println(-1);
		else
			System.out.println(Math.min(ansv1, ansv2));		
	}
	
	static class Point implements Comparable<Point> {
		int next, weight;
		
		public Point(int next, int weight) {
			this.next = next;
			this.weight = weight;
		}

		@Override
		public int compareTo(Point o) {
			return this.weight-o.weight;
		}
		
	}
}
