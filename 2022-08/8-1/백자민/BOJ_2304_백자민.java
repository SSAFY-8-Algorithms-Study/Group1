package week8_1;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2304_백자민 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[1001];
		int start=1000,end=0,maxh=0,maxhIdx=0,ans=0;
		
		for(int i=0;i<N;i++) {
			int l = sc.nextInt();
			int h = sc.nextInt();
			
			arr[l] = h;
			
			//창고의 시작점과 끝점
			if(start>l) start = l;
			if(end<l) end = l;
			
			//가장 높은 건물 
			if(h>maxh) {
				maxhIdx = l;
				maxh = h;
			}
		}
		ans += maxh;
		
		//search right side
		int temp = maxhIdx+1;
		while(true) {
			if(temp == end+1) break;
			//가장 높은 높이와 인덱스 찾기 
			int h = 0;
			int hidx = 0;
			
			for(int i=temp;i<=end;i++) {
				if(arr[i]>h) {
					h = arr[i];
					hidx = i;
				}
			}
			ans += (h*(hidx+1-temp));

			
			temp = hidx+1;
		}
		
		//search left side
		temp = maxhIdx;
		while(true) {
			if(temp == start) break;
			int h=0;
			int hidx = 0;
			
			for(int i=temp-1;i>=start;i--) {
				if(arr[i]>h) {
					h = arr[i];
					hidx = i;
				}
			}
			
			ans += ((temp-hidx)*h);

			temp = hidx;
		}
		
		System.out.println(ans);
		
	}
}
