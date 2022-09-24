package boj2660;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;

/*
 * 회원의 최대 수가 50으로 작기 때문에 모든 회원의 점수를 구하여 가장 낮은 점수를 구했다.
 * 점수를 구하는 방법은 BFS를 사용하였다.
 * num과 친구인 회원을 큐에 넣어서 시작점으로 활용한다.
 * 큐의 크기만큼 for문을 돌려서 같은 관계인 회원들을 본다.
 * 이때 점수(score)가 회장 후보의 점수(minScore)보다 크다면 더 이상 볼 필요가 없기 때문에 return -> 가지치기
 * while문이 끝나면 모든 회원과의 관계를 갖는지 확인한다.
 * minScore와 answer를 update한다.
 * */

public class Main {
	static int N, minScore;
	static ArrayList<Integer> answer;
	static ArrayList<Integer>[] friends;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		friends = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			friends[i] = new ArrayList<>();
		}

		String[] inArr = br.readLine().split(" ");
		int a = Integer.parseInt(inArr[0]);
		int b = Integer.parseInt(inArr[1]);
		while (a != -1 && b != -1) {
			friends[a].add(b);
			friends[b].add(a);

			inArr = br.readLine().split(" ");
			a = Integer.parseInt(inArr[0]);
			b = Integer.parseInt(inArr[1]);
		}

		minScore = Integer.MAX_VALUE;
		answer = new ArrayList<>();
		for (int i = 1; i < N + 1; i++) {
			check(new boolean[N + 1], i);
		}
		Collections.sort(answer);
		System.out.println(minScore + " " + answer.size());
		for (int i = 0; i < answer.size(); i++) {
			System.out.print(answer.get(i) + " ");
		}

	}

	public static void check(boolean[] chk, int num) {
		int score = 0;
		chk[num] = true;
		Queue<Integer> queue = new ArrayDeque<>();
		for (int i = 0; i < friends[num].size(); i++) {
			chk[friends[num].get(i)] = true;
			queue.add(friends[num].get(i));
		}

		while (!queue.isEmpty()) {
			int size = queue.size();
			score++;
			if (score > minScore) {
				return;
			}
			for (int i = 0; i < size; i++) {
				int a = queue.poll();
				for (int j = 0; j < friends[a].size(); j++) {
					if (!chk[friends[a].get(j)]) {
						chk[friends[a].get(j)] = true;
						queue.add(friends[a].get(j));
					}
				}
			}
		}

		for (int i = 1; i < N+1; i++) {
			if (!chk[i]) {
				return;
			}
		}

		if (minScore > score) {
			answer = new ArrayList<>();
			answer.add(num);
			minScore = score;
		} else if (minScore == score) {
			answer.add(num);
		}
	}

}
