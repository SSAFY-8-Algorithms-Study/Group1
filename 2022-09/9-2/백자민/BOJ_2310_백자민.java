package week9_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2310_백자민 {
	
	static int N;
	static ArrayList<Integer>[] map;
	static boolean[] visit;
	static boolean isEnd;
	
	static void go(int idx, int money) {
		if(idx==N) {
			isEnd = true;
			return;
		}
		
		if(isEnd) //끝까지 간거 확인
			return;
		
		for(int i=1;i<map[idx].size();i++) {
			int next = map[idx].get(i); //다음방
			
			if(visit[next]) 
				continue;
			
			visit[next] = true; 
			
			if(map[next].get(0) > 0) { //다음 방이 돈주는 방
				if(money >= map[next].get(0))  //일정량 이상이면 그냥 고 
					go(next, money);
				else 
					go(next, map[next].get(0));
			}
			
			else if(map[next].get(0)<0) { //다음방에 트롤있음
				if(money+map[next].get(0)>=0)
					go(next, money+map[next].get(0));
				else {
					visit[next] = false;
					return;
				}
			}
			
			else //다음방 빈방
				go(next, money);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N==0) break;
			
			map = new ArrayList[N+1];
			visit = new boolean[N+1];
			isEnd = false;
			
			for(int n=1;n<=N;n++) {
				map[n] = new ArrayList<>();
				st = new StringTokenizer(br.readLine());
				
				//방의 type에 따라 입력받기 - 트롤은 음수
				String type = st.nextToken();
				if(type.equals("T")) 
					map[n].add(Integer.parseInt(st.nextToken())*(-1));
				else
					map[n].add(Integer.parseInt(st.nextToken()));
					
				// 연결된 방 번호 입력받기 - ArrayList
				while(true) {
					int num = Integer.parseInt(st.nextToken());
					if(num==0) break;
					map[n].add(num);
				}
			}
			
			
			if(map[1].get(0)<0) {
				System.out.println("No");
				continue;
			}
			else {
				visit[1] = true;
				go(1,0);
			}
			
			if(isEnd) System.out.println("Yes");
			else System.out.println("No");
			
		}
	}
}
