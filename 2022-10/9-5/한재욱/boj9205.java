import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

//처음 - 편의점의 좌표들 - 락페스티벌 좌표 를 두고
//bfs탐색을 통해서 상근이가 맥주를 마시면서 락페스티벌 지점 까지 도달할 수 있는가를 파악
public class Main {
	static List<Point> list;
	static int n;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int Tc = sc.nextInt();
		for(int tc=1;tc<=Tc;tc++) {
			n = sc.nextInt();
			list = new LinkedList<>();
			for(int i=0;i<n+2;i++) {
				list.add(new Point(sc.nextInt(), sc.nextInt()));
			}
			System.out.println(bfs()? "happy":"sad");
		}
	}
	
	private static boolean bfs() {
		Queue<Point> que = new ArrayDeque<>();
		visited = new boolean[list.size()];
		que.add(list.get(0));
		visited[0] = true;
		while(!que.isEmpty()) {
			Point cur = que.poll();
//			System.out.println(cur.i+" "+cur.j);
			if(cur.i==list.get(n+1).i&&cur.j==list.get(n+1).j) {
				return true;
			}
			for(int i=1;i<list.size();i++) {
//				System.out.println("dist : "+dist(cur, list.get(i)));
				if(!visited[i] && dist(cur, list.get(i))<=1000) {
					que.add(list.get(i));
					visited[i] = true;
				}
			}
		}
		return false;
	}
	
	static int dist(Point a, Point b) {
		return Math.abs((a.i-b.i))+Math.abs((a.j-b.j));
	}

	static class Point{
		int i, j;
		public Point() {}
		
		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}		
	}
}