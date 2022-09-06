package week9_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10025_백자민 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int dist = 1+2*K; //idx 1부터 시작 
		
		int[] ice = new int[1000001];
		
		while(N>0) {
			st = new StringTokenizer(br.readLine());
			int g = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			
			ice[x] = g;
			N--;
		}
		
		int sum = 0;
		int maxsum = 0;
		
		for(int i=0;i<=1000000;i++) {
			sum += ice[i]; //뒤에꺼 넣어주기
			
			if(i>=dist)
				sum -= ice[i-dist]; //앞에꺼 빼주기
			
			if(maxsum<sum)
				maxsum = sum;
		}
		
		System.out.println(maxsum);
	}
}
