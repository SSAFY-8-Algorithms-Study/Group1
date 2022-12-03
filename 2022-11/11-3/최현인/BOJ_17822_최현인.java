package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public class Main{
	static int N, M, T, x, d, k, sum;
	static int[][] circle;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		circle = new int[N+1][M];
		sum = 0;
		for (int i = 1; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				circle[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			rotate();
			if (!checkZero()) {
				if (!findNear()) {
					findAvg();
				}
			}
		}
		for (int i = 1; i < N+1; i++) {
			for (int j = 0; j < M; j++) {
				sum += circle[i][j];
			}
		}
		System.out.println(sum);
	}
	public static void rotate() {
		for (int i = x; i <= N; i+=x) {
			ArrayDeque<Integer> q = new ArrayDeque<>();
			for (int j = 0; j < M; j++) {
				q.add(circle[i][j]);
			}
			for (int j = 0; j < k; j++) {
				if (d == 0) {
					q.addFirst(q.pollLast());
				}
				else {
					q.addLast(q.pollFirst());
				}
			}
			for (int j = 0; j < M; j++) {
				circle[i][j] = q.poll();
			}
		}
	}
	public static boolean checkZero() {
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < M; j++) {
				if (circle[i][j] != 0) {
					return false;
				}
			}
		}
		return true;
	}
	public static boolean findNear() {
		boolean check = false;
		int[][] newCircle = new int[N+1][M];
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < M; j++) {
				if (circle[i][j] == 0) {
					continue;
				}
				boolean tempCheck = false;
				for (int k = 0; k < 4; k++) {
					int ni = i + di[k];
					int nj = j + dj[k];
					if (ni < 1 || ni > N) {
						continue;
					}
					if (nj >= M) {
						nj = 0;
					}
					if (nj < 0) {
						nj = M-1;
					}
					
					if (circle[i][j] == circle[ni][nj]) {
						tempCheck = true;
					}
				}
				if (tempCheck) {
					newCircle[i][j] = 0;
					check = true;
				}
				else {
					newCircle[i][j] = circle[i][j];
				}
			}
		}
		circle = newCircle;
		return check;
	}
	public static void findAvg() {
		int sum = 0;
		int count = 0;
		for (int i = 1; i < N+1; i++) {
			for (int j = 0; j < M; j++) {
				sum += circle[i][j];
				if (circle[i][j] != 0) {
					count++;
				}
			}
		}
		double avg = (double)sum/count;
		for (int i = 1; i < N+1; i++) {
			for (int j = 0; j < M; j++) {
				if (avg < circle[i][j]) {
					circle[i][j]--;
				}
				else if (avg > circle[i][j] && circle[i][j] > 0) {
					circle[i][j]++;
				}
			}
		}
	}
}