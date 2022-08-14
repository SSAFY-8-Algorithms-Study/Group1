package week8_2;

import java.util.Scanner;

public class BOJ_1193_백자민 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = 2;
		int sum = 1;
		int x = sc.nextInt();
		
		while(sum<x) sum += t++;
		
		int i = 1, j = t-i;
			
		sum = t-(sum-x)-2;
			
		while(sum>0) {
			i++;
			j--;
			sum--;
		}
		
		if(t%2!=0)
			System.out.println(i+"/"+j);
		else
			System.out.println(j+"/"+i);
	}
}
