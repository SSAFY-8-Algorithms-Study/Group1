import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class boj2310 {
   static int  n;
   static boolean visited[];
   static List<Point>[] adjList;
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      while(true) {
         n = Integer.parseInt(br.readLine());
         if(n==0) break;
         adjList = new LinkedList[n+1];
         for(int i=1;i<=n;i++) {
            adjList[i] = new LinkedList<>();
         }
         visited = new boolean[n+1];
         for(int i =1;i<=n;i++) {
            String[] txt = br.readLine().split(" ");
            int gob = 0;
            if(txt[0].equals("E")) {
               gob = 0;
            }else if(txt[0].equals("L")) {
               gob = 1;
            }else {
               gob = -1;
            }
            for(int j=2;j<txt.length-1;j++) {
               adjList[i].add(new Point(Integer.parseInt(txt[j]),Integer.parseInt(txt[1])*gob)); 
            }
         }
         if(dfs(1, 0)) {
            System.out.println("Yes");
         }else {
            System.out.println("No");
         }
         
      }
   }
   private static boolean dfs(int idx, int havemoney) {
      visited[idx] = true;
      System.out.println(idx+" money "+havemoney);
      if(idx==n) {
         return true;
      }
      for(Point tmp: adjList[idx]) {
         if(!visited[tmp.loc]&&havemoney+tmp.money>=0) {
            dfs(tmp.loc, havemoney+tmp.money);
         }
      }
      return false;
   }
   private static boolean bfs() {
      Queue<Point> que = new ArrayDeque<>();
      que.add(new Point(1,0));
      visited[1] = true;
      while(!que.isEmpty()) {
         Point cur  = que.poll();
         if(cur.loc == n) return true;
         for(Point tmp:adjList[cur.loc]) {
            if(!visited[tmp.loc]) {
               que.add(tmp);
               visited[tmp.loc] = true;
            }
         }
      }
      return false;
   }
   static class Point{
      int loc, money;

      public Point(int loc, int money) {
         this.loc = loc;
         this.money = money;
      }
      
   }
}