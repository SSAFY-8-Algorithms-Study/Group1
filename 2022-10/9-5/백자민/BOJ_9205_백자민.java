package week9_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 집, 편의점, 페스티벌의 좌표를 배열에 저장한 후, 거리가 1000m(20x50m) 이하인 정점끼리 인접리스트에 저장한다(이동할 수 있는 거리).
 * bfs를 이용하여 집에서부터 페스티벌 좌표까지 가능한 경로가 존재하는지 탐색한다. 
 * 
 * */

public class BOJ_9205_백자민 {
	
	static int n;
	static Point[] list;
	static ArrayList<Integer>[] adjList;
	
	static boolean bfs() {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visit = new boolean[n+2];
		
		q.offer(0); 
		visit[0] = true;
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			
			if(temp == n+1)
				return true;
			
			for(int cur: adjList[temp]) {
				if(!visit[cur]) {
					visit[cur] = true;
					q.offer(cur);
				}
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			n = Integer.parseInt(br.readLine());
			list = new Point[n+2];
			adjList = new ArrayList[n+2];
			
			for(int i=0;i<n+2;i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				list[i] = new Point(x,y);
				
				adjList[i] = new ArrayList<>();
			}
			
			for(int i=0;i<n+2;i++) {
				for(int j=i+1;j<n+2;j++) {
					int len = Math.abs(list[i].x-list[j].x) + Math.abs(list[i].y - list[j].y);
					if(len <= 1000) {
						adjList[i].add(j);
						adjList[j].add(i);
					}
				}
			}
			
			System.out.println(bfs()?"happy":"sad");
		}
	}
	
	static class Point {
		int x,y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
