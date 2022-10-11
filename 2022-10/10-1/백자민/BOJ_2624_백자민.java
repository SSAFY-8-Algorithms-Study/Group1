package week10_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
 * knapsack 알고리즘을 사용하여 해당 금액을 만들 수 있는 가짓수를 계산한다.
 * 만약 금액의 합이 T를 초과한다면 가짓수를 갱신하지 않는다. 
 * 마지막으로 해당 금액이 나왔을 경우의 가짓수를 출력한다. 
 * */
public class BOJ_2624_백자민 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		
		int[][] money = new int[K+1][2];
		
		for(int i=1;i<=K;i++) {
			st = new StringTokenizer(br.readLine());
			money[i][0] = Integer.parseInt(st.nextToken());
			money[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int[][] sum = new int[K+1][T+1];
		sum[0][0] = 1;
		for(int i=1;i<=K;i++) {
			int temp = money[i][0];
			for(int j=0;j<=money[i][1];j++) {
				for(int k=0;k<=T;k++) {
					int cost = k+temp*j;
					if(cost>T) break;
					sum[i][cost] += sum[i-1][k];
				}
			}
		}
		
		System.out.println(sum[K][T]);
	}
}
