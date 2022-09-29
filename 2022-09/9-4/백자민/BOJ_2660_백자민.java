package week9_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
 * 양방향 그래프에 데이터를 입력받아 플루이드 연산을 수행하며 최단거리 값을 갱신한다. 
 * 각 정점에서 최단거리를 1차원 배열에 저장한 후, 현재 그래프에서 가장 짧은 거리의 값을 갖고 있는 정점의 개수와 번호를 출력한다. 
 * 
 * */

public class BOJ_2660_백자민 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();

		int[][] map = new int[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i != j) {
                	map[i][j] = 51;
                }
            }
        }
		
		while(true) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			if(x==-1 && y==-1)
				break;
			map[x][y] = map[y][x] = 1;
		}
		
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(map[i][j] > map[i][k] + map[k][j]){
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}
		
		int min = 51;
		int[] result = new int[N+1];
		for(int i=1; i<=N; i++) {
			int temp =0;
			for(int j=1; j<=N; j++) {
				if (map[i][j] != 51) 
					temp = Math.max(temp, map[i][j]);
			}
			result[i] = temp;
			min = Math.min(min, temp);
		}
		
		
		int cnt =0;
		for(int i=1; i<=N; i++) {
			if(result[i] == min) {
				cnt++;
				sb.append(i +" ");
			}
		}
       
		
		System.out.println(min+" "+cnt);
		System.out.println(sb.toString());
		
	}
}
