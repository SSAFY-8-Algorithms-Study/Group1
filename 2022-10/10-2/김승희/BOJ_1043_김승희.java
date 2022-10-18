package boj1043;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

/*
 * party[i] : i번째 파티에 참가하는 사람들
 * person[i] : i번 사람이 참가한 파티
 * 
 * vParty, vPerson은 진실을 들은 사람과 진실을 얘기한 파티는 true
 * 
 * Q에 진실을 아는 사람을 넣는다.
 * Q에서 빼낸 사람이 참가한 파티 중 방문 안한 파티를 본다.
 * 파티에 참가한 사람들 중 방문이 안된 사람을 큐에 넣는다.
 * 
 * 마지막에 방문이 안된 파티만 count하면 된다.
 * */

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		Queue<Integer> Q = new ArrayDeque<>();
		boolean[] vParty = new boolean[M + 1];
		boolean[] vPerson = new boolean[N + 1];
		int[][] party = new int[M][];
		ArrayList<Integer>[] person = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			person[i] = new ArrayList<>();
		}
		int size = sc.nextInt();
		for (int i = 0; i < size; i++) {
			Q.add(sc.nextInt());
			vPerson[Q.peek()] = true;
		}
		for (int i = 0; i < M; i++) {
			size = sc.nextInt();
			int[] temp = new int[size];
			for (int j = 0; j < size; j++) {
				temp[j] = sc.nextInt();
				person[temp[j]].add(i);
			}
			party[i] = temp;
		}

		while (!Q.isEmpty()) {
			int a = Q.poll();
			for (int i = 0; i < person[a].size(); i++) {
				int p = person[a].get(i);
				if (vParty[p])
					continue;
				vParty[p] = true;
				for (int j = 0; j < party[p].length; j++) {
					if (vPerson[party[p][j]])
						continue;
					Q.add(party[p][j]);
					vPerson[party[p][j]] = true;
				}
			}
		}

		int cnt = 0;
		for (int i = 0; i < M; i++) {
			if (!vParty[i])
				cnt++;
		}
		System.out.println(cnt);
	}

}
