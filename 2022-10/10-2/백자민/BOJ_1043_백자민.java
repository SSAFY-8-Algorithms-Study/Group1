package week10_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 파티 정보를 모두 입력받은 후 bfs를 통해 모든 파티를 체크한다. 
 * 1. 진실을 아는 사람들을 큐에 넣기
 * 2. 각 파티별로 진실을 아는 사람이 있는지 확인
 * - 진실을 아는 사람이 있는 경우(거짓말을 못하는 파티일 경우) 해당 파티의 모든 참석자들이 진실을 알게 되므로 큐에 넣기 
 * */


public class BOJ_1043_백자민 {
	
	static int N,M,ans;
	
	static int[] tpeople;
	static ArrayList<Integer>[] party;
	
	static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		boolean[] checkParty = new boolean[M];
		boolean[] checkPeople = new boolean[N+1];
		
		for(int i=0,size=tpeople.length;i<size;i++) {
			q.add(tpeople[i]); //진실 아는 사람 일단 큐에 넣고 방문체크
			checkPeople[tpeople[i]] = true;
		}
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			for(int i=0;i<M;i++) {
				if(checkParty[i]) continue; //거짓말 못하는 파티임을 이미 알고있음
				
				if(!party[i].contains(temp)) continue; //해당 참석자가 없으면 패스 
				
				for(int j=0,size=party[i].size();j<size;j++) { //아직 확인 안 한 파티 - 파티 참석자 체크
					int person = party[i].get(j);
					
					if(checkPeople[person]) continue; //이미 진실을 아는 사람
					
					checkPeople[person] = true;
					q.add(person);
				}
				
				checkParty[i] = true;
				ans--;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		party = new ArrayList[M];
		
		st = new StringTokenizer(br.readLine());
		tpeople = new int[Integer.parseInt(st.nextToken())]; //진실을 아는 사람 저장
		for(int i=0,size=tpeople.length;i<size;i++) {
			tpeople[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			party[i] = new ArrayList<>();
			
			for(int j=0,size=Integer.parseInt(st.nextToken());j<size;j++) {
				party[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		ans = M;
		bfs();
		System.out.println(ans);
	}
}
