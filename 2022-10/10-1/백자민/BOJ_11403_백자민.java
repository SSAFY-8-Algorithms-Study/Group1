package week10_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 플로이드-워셜 알고리즘을 통해 가능한 경로가 있으면 해당 배열을 1로 바꿔준다. 
 * 해당 그래프는 가중치를 고려하지 않기 때문에 i에서 k까지의 경로가 존재하고, k에서 j로의 경로가 존재하면 i에서 j로의 경로가 존재한다고 판단할 수 있다. 
 * */

public class BOJ_11403_백자민 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int k=0;k<N;k++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(arr[i][k]==1 && arr[k][j]==1) {
						arr[i][j] = 1;
					}
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}
