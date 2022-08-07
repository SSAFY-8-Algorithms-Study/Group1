package week8_1;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1931_백자민 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[][] time = new int[N][2];
		
		for(int i=0;i<N;i++) {
			time[i][0] = sc.nextInt();
			time[i][1] = sc.nextInt();
		}
		
		Arrays.sort(time, (o1,o2) -> {
			if(o1[1]==o2[1]) return o1[0]-o2[0];
			return o1[1]-o2[1];
		});
		
		int cnt = 1;
		int before = time[0][1];
		
		for(int i=1;i<N;i++) {
			if(time[i][0]>=before) {
				cnt++;
				before = time[i][1];
			}
		}
		
		System.out.println(cnt);
		
	}
}
