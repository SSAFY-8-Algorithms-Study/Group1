package week9_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * 0부터 나무 높이의 최댓값 사이의 값들을 이분탐색하면서 최대 자를 수 있는 높이를 구한다.
 * 
 * */

public class BOJ_2805_백자민 {
	
	static int N, M;
	static int[] trees;
	
	static long cut(int height) {
		long result = 0;
		for(int t: trees) {
			if(t>height)
				result += (t-height);
		}
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		trees = new int[N];
		
		int minh=0, maxh=0; // 나무 높이의 최솟값, 최댓값
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			if(trees[i]>maxh)
				maxh = trees[i];
		}
		
		long temp = 0; //가져갈 나무 길이
		while(minh<maxh) {
			int mid = (minh+maxh)/2;
			temp = cut(mid);
			if(temp<M)
				maxh = mid;
			else
				minh = mid+1;
		}
		System.out.println(minh-1);
	}
}
