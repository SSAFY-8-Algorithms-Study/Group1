package week10_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 가장 왼쪽부터 시작해서 N번째 칸까지 각 칸별로 해당 칸에 도착하는 최소횟수를 구한다.
 * */

public class BOJ_11060_백자민 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
				
		int[] nums = new int[N];
		int[] jump = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			nums[i] = Integer.parseInt(st.nextToken()); 
			jump[i] = Integer.MAX_VALUE; //초기화 
		}
		
		jump[0] = 0;
		for(int i=0;i<N;i++) {
			if(jump[i] >= Integer.MAX_VALUE) continue; // 못 밟는 칸은 패스 
			
			for(int j=1;j<=nums[i];j++) {
				if(i+j>=N) break; //N을 넘어가면 멈추기
				jump[i+j] = Math.min(jump[i+j], jump[i]+1); //둘 중 최솟값 저장
			}
		}
		
		System.out.println(jump[N-1]>=Integer.MAX_VALUE?-1:jump[N-1]); 
	}
}