package week8_4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_16235_백자민 {
	
	static int N, M, K;
	static int[][] A, map;
	
	static Queue<Tree> alive;
	
	static int[] di = {1,1,0,-1,-1,-1,0,1};
	static int[] dj = {0,1,1,1,0,-1,-1,-1};
	
	static void ss() {
		ArrayList<Tree> dead = new ArrayList<Tree>();
		
		for(int i=0, size=alive.size();i<size;i++) {
			Tree temp = alive.poll();
			
			if(map[temp.i][temp.j] < temp.age) { //양분 부족 -> 죽음
				dead.add(new Tree(temp.i, temp.j, temp.age/2));
			}
			else {
				map[temp.i][temp.j] -= temp.age;
				alive.add(new Tree(temp.i, temp.j, temp.age+1));
			}
		}
		
		for(Tree t: dead) {
			map[t.i][t.j] += t.age;
		}//양분 추가
	}
	
	static void fall() { //아기나무부터 저장
		ArrayList<Tree> oldT = new ArrayList<>();
		
		for(int i=0,size=alive.size();i<size;i++) {
			Tree temp = alive.poll();
			
			if(temp.age%5==0) {
				for(int d=0;d<8;d++) {
					int ni = temp.i+di[d];
					int nj = temp.j+dj[d];
					
					if(ni>=0 && ni<N && nj>=0 && nj<N) {
						alive.add(new Tree(ni,nj,1));
					}
				}
			}
			oldT.add(temp);
		}
		
		for(Tree t: oldT) 
			alive.add(t);
	}
	
	static void winter() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j] += A[i][j];
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		
		A = new int[N][N];
		map = new int[N][N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				A[i][j] = sc.nextInt();
				map[i][j] = 5; //초기 양분은 5 
			}
		}
		
		alive = new LinkedList<>();
		for(int m=0;m<M;m++)
			alive.add(new Tree(sc.nextInt()-1, sc.nextInt()-1, sc.nextInt()));
		
		Collections.sort((List<Tree>)alive);
		
		while(K>0) {
			ss();
			fall();
			winter();
			K--;
		}
		
		System.out.println(alive.size());
	}
	
	static class Tree implements Comparable<Tree> {
		int i, j, age;

		public Tree(int i, int j, int age) {
			this.i = i;
			this.j = j;
			this.age = age;
		}

		@Override
		public int compareTo(Tree o) {
			return this.age-o.age;
		}
	}
}
