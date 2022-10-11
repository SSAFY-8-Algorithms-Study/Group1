package week10_1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 상어 잡기 -> 상어 이동 좌표 구하기 -> 상어 이동 및 맵 초기화 의 과정을 반복 수행한다. 
 * 
 * 상어 잡기: 현재 낚시왕의 j좌표를 기준으로 map을 탐색하여 가장 위쪽에 위치한 상어를 map에서 삭제하고 총 상어의 무게를 갱신한다. 
 * 상어 이동 좌표 구하기: 상어의 현재 방향과 스피드를 이용하여 다음 상어의 위치를 구해서 상어 객체를 갱신한다. 
 * 상어 이동 및 맵 초기화: 갱신된 상어 객체의 좌표를 기준으로 map을 새로 생성한다. 
 * */

public class BOJ_17143_백자민 {
	
	static int R,C,M,result;
	
	static Shark[][] map;
	static ArrayList<Shark> sharks;
	
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,1,-1};
	
	static void initMap() {
		map = new Shark[R+1][C+1];
        int size = sharks.size();
        for(int i = size - 1; i >= 0; i--) {
            Shark shark = sharks.get(i);

            if(map[shark.i][shark.j] == null) {
                map[shark.i][shark.j] = shark;
            }

            else {
                if(map[shark.i][shark.j].size > shark.size) {
                    sharks.remove(shark);
                }else {
                    sharks.remove(map[shark.i][shark.j]);
                    map[shark.i][shark.j] = shark;
                }
            }
        }
	}
	
	static Shark update(Shark s) {
		int move = s.speed;
		
		if(s.dir<2) { //상하이동
			move %= ((R-1)*2);
			while(move>0) {
				if(s.i==1) {
					s.dir = 1;
				}
				if(s.i==R) {
					s.dir=0;
				}
				s.i += di[s.dir];
				move--;
			}
		}
		else {
			move %= ((C-1) * 2);
            while (move>0) {
                if(s.j == 1) {
                	s.dir = 2;
                }
                if(s.j == C) {
                	s.dir = 3;
                }
                s.j += dj[s.dir];
                move--;
            }
		}
		return s;
	}
	
	static void move() {
		for(Shark s: sharks) {
			s = update(s);
		}
	}
	
	static void getShark(int j) {
		for(int i=1;i<=R;i++) {
			if(map[i][j]!=null) {
				Shark temp = map[i][j];
				
				map[i][j] = null;
				result += temp.size;
				sharks.remove(temp);
				
				break;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new Shark[R+1][C+1];
		sharks = new ArrayList<>();
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			Shark temp = new Shark(Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken())-1,
						Integer.parseInt(st.nextToken()));
			
			map[temp.i][temp.j] = temp;
			sharks.add(temp);
		} //end input
		
		
		for(int c=1;c<=C;c++) {
			getShark(c);
			move();
			initMap();
		}
		
		System.out.println(result);
	}
	
	static class Shark  {
		int i,j,speed,dir,size;

		public Shark(int i, int j, int speed, int dir, int size) {
			this.i = i;
			this.j = j;
			this.speed = speed;
			this.dir = dir;
			this.size = size;
		}

		@Override
		public String toString() {
			return "Shark [i=" + i + ", j=" + j + ", speed=" + speed + ", dir=" + dir + ", size=" + size + "]";
		}
		
		
	}
}